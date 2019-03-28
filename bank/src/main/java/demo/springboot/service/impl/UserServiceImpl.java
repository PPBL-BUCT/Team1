package demo.springboot.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import demo.springboot.dao.UserDao;
import demo.springboot.domain.User;
import demo.springboot.service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User selectByUsername(String username) {
		return userDao.selectByUsername(username);
	}

	@Override
	public String update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
		return null;
	}
}
