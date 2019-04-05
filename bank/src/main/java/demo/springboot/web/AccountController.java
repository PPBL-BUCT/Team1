package demo.springboot.web;

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
import demo.springboot.service.AccountService;
import demo.springboot.service.LogService;
import demo.springboot.service.UserService;

@RestController
@RequestMapping(value = "/Account")
public class AccountController {
	@Autowired
	UserService userService;
	@Autowired
	AccountService accountService;

	@Autowired
	LogService logService;

	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request,
			HttpServletResponse response, @RequestParam int page,
			@RequestParam int limit) {
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

	@RequestMapping("/log")
	@ResponseBody
	public Map<String, Object> log(HttpServletRequest request,
			HttpServletResponse response, @RequestParam int page,
			@RequestParam int limit, @ModelAttribute Log log) {
		Map<String, Object> map = new HashMap<>();
		HttpSession session = request.getSession();

		List<Log> logs = logService.selectList(log);
		List<Log> logs2;
		if (page * limit - 1 < logs.size() - 1) {
			logs2 = logs.subList((page - 1) * limit, page * limit - 1);
		} else {
			logs2 = logs.subList((page - 1) * limit, logs.size());
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", logs.size());
		map.put("data", logs2);
		return map;
	}
}
