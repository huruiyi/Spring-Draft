package com.example.demo.memberDev.service.impl;


import com.example.demo.memberDev.mapper.UserMapperDev;
import com.example.demo.memberDev.model.UserDev;
import com.example.demo.memberDev.service.UserServiceDev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDevImpl implements UserServiceDev {

    @Autowired
    private UserMapperDev userMapperDev;

    @Override
    public List<UserDev> findAll() {
        return userMapperDev.findAll();
    }

}
