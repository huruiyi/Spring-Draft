package com.mybatisboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatisboot.entity.UserProfile;
import com.mybatisboot.mapper.UserProfileMapper;


@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileMapper userProfileMapper;

    public List<UserProfile> findAll() {
        return userProfileMapper.findAll();
    }

    public UserProfile findByType(String type) {
        return userProfileMapper.findByType(type);
    }

    public UserProfile findById(int id) {
        return userProfileMapper.findById(id);
    }
}
