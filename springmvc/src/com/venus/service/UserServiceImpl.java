package com.venus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venus.dao.UserDao;
import com.venus.domain.User;

@Service  
public class UserServiceImpl implements UserService{  
    @Autowired  
    private UserDao userDao;  
  
    public User selectUserById(Integer userId) {  
        return userDao.selectUserById(userId);  
          
    }

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userDao.selectAllUser();
	}  
  
}  