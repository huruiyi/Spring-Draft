package com.ruiyi.demo.service;


import com.ruiyi.demo.dto.User;
import com.ruiyi.demo.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
