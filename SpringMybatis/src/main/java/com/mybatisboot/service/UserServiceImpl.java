package com.mybatisboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatisboot.entity.User;
import com.mybatisboot.entity.UserProfile;
import com.mybatisboot.entity.UserProfileRelation;
import com.mybatisboot.mapper.UserMapper;
import com.mybatisboot.mapper.UserProfileRelationMapper;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserProfileRelationMapper userProfileRelationMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.save(user);
        UserProfileRelation userProfileRelation = new UserProfileRelation();
        for (UserProfile userProfile : user.getUserProfiles()) {
            userProfileRelation.setUserId(user.getId());
            userProfileRelation.setUserProfileId(userProfile.getProfileId());
            userProfileRelationMapper.addUserProfileRelation(userProfileRelation);
        }
    }

    public User findById(int id) {
        return userMapper.queryById(id);
    }

    public User findBySso(String sso) {
        return userMapper.queryBySsoId(sso);
    }

}
