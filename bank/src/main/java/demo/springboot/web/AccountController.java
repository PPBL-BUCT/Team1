package demo.springboot.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.domain.Account;
import demo.springboot.domain.Log;
import demo.springboot.domain.Transform;
import demo.springboot.domain.TransformRecode;
import demo.springboot.service.AccountService;
import demo.springboot.service.LogService;
import demo.springboot.service.UserService;
import demo.springboot.util.CusAccessObjectUtil;
import demo.springboot.util.JsonData;
import demo.springboot.util.ReceiveBalance;
import demo.springboot.util.ReceiveTransList;
import demo.springboot.util.ReceiveTransfer;

@RestController
@RequestMapping(value = "/Account")
public class AccountController {
	@Autowired
	UserService userService;
	@Autowired
	AccountService accountService;

	@Autowired
	LogService logService;

	// 查询账户列表
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request,
			HttpServletResponse response, @RequestParam int page,
			@RequestParam int limit) {
		Log log = new Log();
		log.setOperation("查询账户列表");
		log.setUser_id((String) request.getSession().getAttribute("user_id"));
		log.setCreate_time(new Date());
		log.setIp(CusAccessObjectUtil.getIpAddress(request));
		log.setType(3);
		log.setSuccess(1);
		logService.insertSelective(log);
		Map<String, Object> map = new HashMap<>();
		HttpSession session = request.getSession();
		List<Account> users = accountService.getAll((String) session
				.getAttribute("user_id"));
		List<Account> users2;
		if (page * limit - 1 < users.size() - 1) {
			users2 = users.subList((page - 1) * limit, page * limit - 1);
		} else {
			users2 = users.subList((page - 1) * limit, users.size());
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", users.size());
		map.put("data", users2);
		System.out.println(users2.get(0).getAccount());
		return map;
	}

	// 查询账户列表
	@RequestMapping("/transformList")
		@ResponseBody
		public Map<String, Object> transformList(HttpServletRequest request,
				HttpServletResponse response, @RequestParam int page,
			@RequestParam int limit, @ModelAttribute TransformRecode recode) {
			Log log = new Log();
			log.setOperation("查询账户列表");
			log.setUser_id((String) request.getSession().getAttribute("user_id"));
			log.setCreate_time(new Date());
			log.setIp(CusAccessObjectUtil.getIpAddress(request));
			log.setType(4);
			log.setSuccess(1);
			logService.insertSelective(log);
			Map<String, Object> map = new HashMap<>();
			HttpSession session = request.getSession();
			
		List<TransformRecode> list = ReceiveTransList.receiveTransList(
				recode.getPayerAccountNo(), recode.getDateFrom(),
				recode.getDateTo(), page + "", limit + "");
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", list.size());
			map.put("data", list);
			return map;
		}

	@RequestMapping("/allList")
	@ResponseBody
	public JsonData allList(HttpServletRequest request,
			HttpServletResponse response) {
		JsonData json = new JsonData();
		try {
			HttpSession session = request.getSession();
			List<Account> users = accountService.getAll((String) session
					.getAttribute("user_id"));
			json.setSuccess(true);
			json.setObj(users);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("错误");
		}
		return json;

	}
	// 查询日志
	@RequestMapping("/log")
	@ResponseBody
	public Map<String, Object> log(HttpServletRequest request,
			HttpServletResponse response, @RequestParam int page,
			@RequestParam int limit, @ModelAttribute Log log) {
		
		/*
		 * Log log5 = new Log(); log5.setOperation("日志查询");
		 * log5.setUser_id((String)
		 * request.getSession().getAttribute("user_id"));
		 * log5.setCreate_time(new Date());
		 * log5.setIp(CusAccessObjectUtil.getIpAddress(request));
		 * log5.setType(5); log5.setSuccess(1);
		 * logService.insertSelective(log5);
		 */
		
		Map<String, Object> map = new HashMap<>();

		List<Log> logs = logService.selectList(log, page, limit);
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", logService.selectListCount(log));
		map.put("data", logs);
		return map;
	}

	// 加挂账户
	@RequestMapping("/add")
	@ResponseBody
	public JsonData add(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Account account) {
		Log log2 = new Log();
		log2.setOperation("加挂账户");
		log2.setUser_id((String) request.getSession().getAttribute("user_id"));
		log2.setCreate_time(new Date());
		log2.setIp(CusAccessObjectUtil.getIpAddress(request));
		log2.setType(2);
		log2.setSuccess(1);
		

		JsonData json = new JsonData();

		try {
			// 调用远程数据库 ,查询结果
			if (ReceiveBalance.checkAccount(account.getAccount(), account
					.getPassword(),
					(String) request.getSession().getAttribute("user_id"))) {
				account.setUserId((String) request.getSession().getAttribute(
						"user_id"));
				account.setCurrency(1);
				account.setStatus(1);
				accountService.insert(account);
				json.setSuccess(true);
			} else {
				json.setMsg("账户验证失败");
				log2.setSuccess(0);
			}

		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("未知错误，请联系管理员");
			log2.setSuccess(0);
		}
		logService.insertSelective(log2);

		return json;
	}

	// 余额查询
	@RequestMapping("/getBalance")
	@ResponseBody
	public JsonData getBalance(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Account account) {
		
		JsonData json = new JsonData();

		try {
			// 调用远程数据库 ,查询结果
			String balance = ReceiveBalance
					.receiveBalance(account.getAccount());

			account.setBalance(balance);
			json.setObj(account);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("未知错误，请联系管理员");

		}
		return json;
	}

	// 确认转账页面，把收到的数据全部反倒页面
	@RequestMapping("/confirmTransfer")
	@ResponseBody
	public JsonData confirmTransfer(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Transform transform) {
		JsonData json = new JsonData();
		try {
			json.setObj(transform);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("未知错误，请联系管理员");
		}
		return json;
	}

	@RequestMapping("/transfer")
	@ResponseBody
	public JsonData transfer(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Transform transform) {
		JsonData json = new JsonData();
		try {
			// 调用远程数据库 ,查询结果

			if (ReceiveTransfer.receiveTransfer(transform.getPayaccount(),
					transform.getRecieveaccount(), transform.getPayeename(),
					transform.getAmount(), "CNY",
					transform.getTransferpassword(),
					transform.getPurpose(), "转账")) {
				json.setSuccess(true);
			} else {
				json.setSuccess(false);
			}
			// json.setObj(transform);

		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("未知错误，请联系管理员");
		}
		return json;
	}
}
