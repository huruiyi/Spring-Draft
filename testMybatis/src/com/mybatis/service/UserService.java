package com.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dto.User;
import com.mybatis.mapper.UserDao;

@Service("userService")
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User selectUser(Long id){
		return userDao.selectUser(id);
	}
	
	public void insertUser(User user){
		userDao.insertUser(user);
	}
}
