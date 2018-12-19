package com.mybatis.mapper;

import com.mybatis.dto.User;

public interface UserDao {
	public User selectUser(Long id);
	public void insertUser(User user);
}
