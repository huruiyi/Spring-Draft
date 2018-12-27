package com.ruiyi.service.impl;

import com.ruiyi.dto.User;
import com.ruiyi.mapper.UserDao;
import com.ruiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    public User selectUser(Long id) {
        return userDao.selectUser(id);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
