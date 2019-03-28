package demo.springboot.dao;



import demo.springboot.domain.User;

public interface UserDao {
	
	
	public User selectByUsername(String username) ;
	
	String update(User user);
    
}
