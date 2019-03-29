package com.mybatisboot;

import com.mybatisboot.entity.*;
import com.mybatisboot.mapper.UserMapper;
import com.mybatisboot.mapper.UserProfileMapper;
import com.mybatisboot.mapper.UserProfileRelationMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
 @WebAppConfiguration
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserProfileRelationMapper userProfileRelationMapper;

    @Autowired
    private UserProfileMapper UserProfileMapper;

    @Test
    public void findUserTest() {
        org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
        User user = userMapper.queryById(1);
        System.out.println(user);
    }

    @Test
    @Transactional
    public void addUserTest() {
        org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
        double ssoid = Math.random() * 10000;
        User user = new User();
        user.setEmail("aa@aa.com");
        user.setFirstName("111");
        user.setLastName("222");
        user.setSsoId(ssoid + "");
        user.setState(State.ACTIVE.getState());
        user.setPassword("123");

        int r = userMapper.save(user);
        System.out.println("result:" + r);
        System.out.println(user);

        UserProfile userProfile = UserProfileMapper.findByType(UserProfileType.ADMIN.getUserProfileType());

        System.out.println(userProfile);

        UserProfileRelation userProfileRelation = new UserProfileRelation();
        userProfileRelation.setUserId(user.getId());
        userProfileRelation.setUserProfileId(userProfile.getProfileId());
        userProfileRelationMapper.addUserProfileRelation(userProfileRelation);
    }
}
