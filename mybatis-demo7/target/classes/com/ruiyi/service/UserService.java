package com.ruiyi.service;


import com.ruiyi.dto.User;


public interface UserService {

    User selectUser(Long id);

    void insertUser(User user);
}
