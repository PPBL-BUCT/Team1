package demo.springboot.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.domain.JsonData;
import demo.springboot.domain.User;
import demo.springboot.domain.VerifyCodeUtils;
import demo.springboot.service.UserService;

@RestController
@RequestMapping(value = "/Login")
public class LoginController {

	@Autowired
	UserService userService;

	// Map<Cookie[], User> onlineUserMap = new HashMap<Cookie[], User>();

	@RequestMapping(method = RequestMethod.POST)
	public JsonData postBook(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute User user) {

		JsonData json = new JsonData();
		// 先验证验证码 TODO
		HttpSession session = request.getSession();
		String codeKey = (String) session.getAttribute("CodeKey");
		if (!codeKey.equals(user.getPassKey())) {
			json.setSuccess(false);
			json.setMsg("验证码错误");
			System.out.println(codeKey + "您输入的：" + user.getPassKey());
			return json;
		}

		// 再从库中取出来
		User realUser = userService.selectByUsername(user.getUsername());
		if (realUser == null) {
			json.setSuccess(false);
			json.setMsg("用户名/密码错误，您已累计输入错误1次，累计输入3次错误，账户将被锁定，次日解锁");
			return json;
		}

		// 判断用户是否被锁定
		if (realUser.getCount() == 3) {
			json.setSuccess(false);
			json.setMsg("该用户因错误输入密码三次已被锁定，请24小时后再试");
			return json;
		}
		// 比对密码
		if (realUser.getPassword().equals(user.getPassword())) {
			json.setSuccess(true);
			// onlineUserMap.put(request.getCookies(), realUser);
			// request.getSession();
			System.out.println("登陆成功");
			return json;
		} else {
			realUser.setCount(realUser.getCount() + 1);
			userService.update(realUser);
			json.setSuccess(false);
			json.setMsg("用户名/密码错误，您已累计输入错误" + realUser.getCount()
					+ "次，累计输入3次错误，账户将被锁定，次日解锁");
			return json;
		}
	}

	/**
	 * 
	 * Description:加载验证码
	 * 
	 * @Title: loadPasskey
	 * @author Jalf
	 * @since 2016年5月31日 下午2:27:30
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/loadPasskey")
	public void loadPasskey(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		HttpSession session = request.getSession();
		int width = 80, height = 30;
		ServletOutputStream responseOutputStream = null;
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			String codeKey = VerifyCodeUtils.outputVerifyImage(width, height,
					outputStream, 4);
			session.setAttribute("CodeKey", codeKey);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != responseOutputStream) {
				responseOutputStream.flush();
				responseOutputStream.close();
			}
		}
	}
}
