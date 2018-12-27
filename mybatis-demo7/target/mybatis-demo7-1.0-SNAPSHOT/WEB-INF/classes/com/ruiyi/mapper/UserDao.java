package com.ruiyi.mapper;

import com.ruiyi.dto.User;


public interface UserDao {
    public User selectUser(Long id);
    public void insertUser(User user);
}

