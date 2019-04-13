package demo.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springboot.dao.UserDao;
import demo.springboot.domain.User;
import demo.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User selectById(String user_id) {
		return userDao.selectById(user_id);
	}

	@Override
	public User selectByUsername(String username) {
		return userDao.selectByUsername(username);
	}

	@Override
	public String update(User user) {
		// TODO Auto-generated method stub
		try {
			userDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "更新用户失败，请联系管理员";
		}
		return null;
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);

	}
}
