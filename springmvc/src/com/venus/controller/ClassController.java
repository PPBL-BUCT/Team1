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
import com.venus.domain.Class1;
import com.venus.domain.JsonData;
import com.venus.domain.User;
import com.venus.service.ClassService;
import com.venus.service.UserService;

@Controller 
public class ClassController {  
	@Resource  
    private ClassService classService;  
    @RequestMapping("toClassList.do")    
    public ModelAndView toClassList(HttpServletRequest request, HttpServletResponse response
			) {      
        ModelAndView mav = new ModelAndView("class_list");  //html文件名 
        
        return mav;    
    }
    
    @ResponseBody
    @RequestMapping(value="ClassList.do")  
    public List<Class1> ClassList(HttpServletRequest request, HttpServletResponse response
			) {
    	
    	return classService.selectAll();
    }
    
    @ResponseBody
    @RequestMapping(value="DeleteClass.do")  
    public JsonData DeleteClass(HttpServletRequest request, HttpServletResponse response
			) {
    	
    	return classService.selectAll();
    }
    
 
}  