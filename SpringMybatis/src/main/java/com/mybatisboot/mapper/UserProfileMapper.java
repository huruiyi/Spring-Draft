package com.mybatisboot.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mybatisboot.entity.UserProfile;

@Mapper
public interface UserProfileMapper {
    @Select("select * from user_profile")
    List<UserProfile> findAll();

    @Select("select * from user_profile where profileid=#{profileId}")
    UserProfile findById(int id);

    @Select("select * from user_profile where type=#{type}")
    UserProfile findByType(String type);

    @Select("select p.profileid,p.type from user_profile p,app_user_profile up where up.user_id=#{userId} and up.user_profile_id=p.profileid")
    Set<UserProfile> findUserProfileByUserId(int userId);
}
