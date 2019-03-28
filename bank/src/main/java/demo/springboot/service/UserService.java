package demo.springboot.service;

import demo.springboot.domain.User;

public interface UserService {
      	
	public User selectByUsername(String username);
	
	String update(User user);
}
