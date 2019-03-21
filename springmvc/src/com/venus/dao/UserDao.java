package com.venus.dao;

import java.util.List;

import com.venus.domain.User;

public interface UserDao {  
    
    public User selectUserById(Integer userId);  
    
    public List<User> selectAllUser();  
    
    
}  