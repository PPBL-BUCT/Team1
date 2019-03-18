package com.venus.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.venus.domain.User;
import com.venus.service.UserService;

@Controller 
public class UserController {  
    @Resource  
    private UserService userService;  
      
    @RequestMapping("SingleUser.do")    
    public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "UserId", required = true) Integer userId) {      
        ModelAndView mav = new ModelAndView("SingleUser");   
        User user = userService.selectUserById(userId);  
        mav.addObject("user", user);   
        return mav;    
    }
    
    /**
     *  @ResponseBody 返回中文显示乱码，
     *  配置spring-mvc中mvc:annotation-driven标签内容，会自动转换对象为JSON串
     * @param request
     * @param response
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value="SingleUser.json")  
    public User getUserById(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "UserId", required = true) Integer userId) {
    	return userService.selectUserById(userId);
    }
    
    /**
     *  @ResponseBody 返回中文显示乱码，
     *  配置spring-mvc中mvc:annotation-driven标签内容，会自动转换对象为JSON串，如上方法
     * @param request
     * @param response
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("SingleUser1.json")  
    public String getUserById1(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "UserId", required = true) Integer userId) {
    	return JSON.toJSONString(userService.selectUserById(userId));
    }
    
    /**
     * 中文显示正常，
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("SingleUser2.json")  
    public void getUserById2(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "UserId", required = true) Integer userId) throws UnsupportedEncodingException, IOException {
    	String returnStr = JSON.toJSONString(userService.selectUserById(userId));
    	response.setHeader("Content-Type", "application/json; charset=utf-8");
    	response.getOutputStream().write(returnStr.getBytes("UTF-8"));
    	response.getOutputStream().flush();
    	response.getOutputStream().close();
    }
    
    /**
     *  @ResponseBody 返回中文显示乱码，
     *  配置spring-mvc中mvc:annotation-driven标签内容，会自动转换对象为JSON串
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="AllUser.json")  
    public List<User> getAllUser(HttpServletRequest request, HttpServletResponse response) {
    	return userService.selectAllUser();
    }
    
    /**
     *  @ResponseBody 返回中文显示乱码，
     *  配置spring-mvc中mvc:annotation-driven标签内容，会自动转换对象为JSON串，如上方法
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="AllUser1.json")  
    public String getAllUser1(HttpServletRequest request, HttpServletResponse response) {
    	return JSON.toJSONString(userService.selectAllUser());
    }
}  