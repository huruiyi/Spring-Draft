package com.ruiyi.demo.memberpro.service.impl;


import com.ruiyi.demo.memberpro.mapper.UserMapperPro;
import com.ruiyi.demo.memberpro.model.UserPro;
import com.ruiyi.demo.memberpro.service.UserServicePro;
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
