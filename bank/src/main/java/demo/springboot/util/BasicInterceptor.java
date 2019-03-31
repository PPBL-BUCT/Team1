package demo.springboot.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
public class BasicInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(BasicInterceptor.class);
	 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
 
		/*
		 * User user = (User)request.getSession().getAttribute("user");
		 * if(user==null) { response.sendRedirect(request.getContextPath()+"/");
		 * logger.info("用户未登录，不允许进行请求:"+request.getRequestURL()); return false;
		 * }
		 * 
		 * String url = request.getRequestURI(); if(url.indexOf("/admin") >= 0)
		 * { if(user==null || user.getIdentity()!=0) {
		 * response.sendRedirect(request.getContextPath()+"/");
		 * logger.info("用户权限错误，不允许进行请求:"+request.getRequestURL()); return false;
		 * } }
		 */
		return true;
	}
 
}