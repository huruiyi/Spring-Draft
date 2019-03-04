package com.ruiyi.demo.memberdev.service.impl;


import com.ruiyi.demo.memberdev.mapper.UserMapperDev;
import com.ruiyi.demo.memberdev.model.UserDev;
import com.ruiyi.demo.memberdev.service.UserServiceDev;
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
