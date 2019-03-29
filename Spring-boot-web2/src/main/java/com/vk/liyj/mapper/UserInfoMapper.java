package com.vk.liyj.mapper;

import java.util.List;

import com.vk.liyj.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    //查询所有的人员信息
    List<UserInfo> selectAllUsers();
}