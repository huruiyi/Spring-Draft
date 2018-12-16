package com.example.service.impl;

import java.util.List;

import com.example.mapper.UserMapper;
import com.example.model.MUser;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;


    //使用mybatis
    public List<User> likeName(String name) {
        return userMapper.likeName(name);
    }

    public User getById(Long id) {
        return userMapper.getById(id);
    }

    public List<User> getUsers() {
        return userMapper.getUsers();
    }


    //使用JPA
    public MUser findByName(String name) {
        return userRepository.findByName(name);
    }

    public MUser findByNameAndAge(String name, Integer age) {
        return userRepository.findByNameAndAge(name, age);
    }

	/*public MUser findUser(String name){
		return userRepository.findUser(name);
	}*/

}
