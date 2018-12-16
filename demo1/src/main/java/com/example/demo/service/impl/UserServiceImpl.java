package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsersMapper;
import com.example.demo.model.Users;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{
		
	@Autowired
	private UsersMapper usersMapper;

	@Override
	public void saveUsers(Users users) {
		usersMapper.insert(users);
	}
	
	
}
