package com.ruiyi.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruiyi.demo.dao.UserMapper;
import com.ruiyi.demo.model.User;
import com.ruiyi.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

}
