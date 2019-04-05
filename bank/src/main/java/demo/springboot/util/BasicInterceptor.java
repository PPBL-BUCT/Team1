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
		System.out.println("拦截session");
		try {
			String status = (String) request.getSession().getAttribute(
					"isLogin");
			if (status.equals("1")) {
				System.out.println("放行用户"
						+ request.getSession().getAttribute("user_id"));
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
 
}