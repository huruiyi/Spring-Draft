package com.mybatisboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mybatisboot.entity.UserProfileRelation;

@Mapper
public interface UserProfileRelationMapper {
    @Insert("insert into app_user_profile(user_id,user_profile_id) values(#{userId},#{userProfileId})")
    int addUserProfileRelation(UserProfileRelation userProfileRelation);

    @Select("select user_id as userId,user_profile_id as userProfileId from app_user_profile where user_id=#{userId}")
    List<UserProfileRelation> findUserProfileRelationsByUserId(int userId);

    @Select("select user_id as userId,user_profile_id as userProfileId from app_user_profile where user_profile_id=#{profileId}")
    List<UserProfileRelation> findUserProfileRelationsByProfileId(int profileId);
}
