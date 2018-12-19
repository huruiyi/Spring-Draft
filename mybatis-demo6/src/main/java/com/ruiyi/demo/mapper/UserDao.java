package com.ruiyi.demo.mapper;


import com.ruiyi.demo.dto.User;

public interface UserDao {
	public User selectUser(Long id);
	public void insertUser(User user);
}

