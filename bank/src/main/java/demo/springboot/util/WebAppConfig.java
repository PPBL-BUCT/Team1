package demo.springboot.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
/**
 * Title:
 * @author: chenmingyue
 * @date: 2018/3/16 12:01
 * Description:配置URLInterceptor拦截器，以及拦截路径
 */
 
 
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
 
	/**
	 * 配置拦截器，阻止普通用户和游客进入管理员界面，阻止游客进行个人信息有关操作
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new BasicInterceptor())
			.addPathPatterns("/admin/**","/news/admin/**","/team/admin/**","/user/info");
	}
 
}
