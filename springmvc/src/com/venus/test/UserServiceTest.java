package com.venus.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.venus.domain.User;
import com.venus.service.UserService;

public class UserServiceTest extends SpringTestCase {  
    @Autowired  
    private UserService userService;  
      
    @Test  
    public void selectUserByIdTest(){  
        User user = userService.selectUserById(1);  
        logger.debug("查找结果: " + user);  
    }
    
    @Test  
    public void selectAllUserTest(){  
        List<User> users = userService.selectAllUser();
        logger.debug("查找结果: ");  
        
        for(User user : users)
        	logger.debug(""+user);
    } 
}  