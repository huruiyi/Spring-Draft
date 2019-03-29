package com.mybatisboot.service;

import com.mybatisboot.entity.User;

public interface UserService {

    void save(User user);

    User findById(int id);

    User findBySso(String sso);

}