package demo.springboot.service;

import demo.springboot.domain.User;

public interface UserService {

	public User selectById(String user_id);
      	
	public User selectByUsername(String username);
	
	String update(User user);

	public void insert(User user);
}
