package demo.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import demo.springboot.domain.User;

@Mapper
public interface UserDao {

	public User selectByUsername(@Param("username") String username);

	void update(User user);

    User selectById(int user_id);
}
