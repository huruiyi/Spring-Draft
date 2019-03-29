package com.mybatisboot.service;

import java.util.List;

import com.mybatisboot.entity.UserProfile;


public interface UserProfileService {

    List<UserProfile> findAll();

    UserProfile findByType(String type);

    UserProfile findById(int id);
}
