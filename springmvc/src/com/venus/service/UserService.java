package com.venus.service;

import java.util.List;

import com.venus.domain.User;

public interface UserService {

	User selectUserById(Integer userId);

	List<User> selectAllUser();
}
