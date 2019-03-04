package com.example.demo.memberPro.service.impl;


import com.example.demo.memberPro.service.UserServicePro;
import com.example.demo.memberPro.mapper.UserMapperPro;
import com.example.demo.memberPro.model.UserPro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceProImpl implements UserServicePro {

    @Autowired
    private UserMapperPro userMapperPro;

    @Override
    public List<UserPro> findAll() {
        return userMapperPro.findAll();
    }

}
