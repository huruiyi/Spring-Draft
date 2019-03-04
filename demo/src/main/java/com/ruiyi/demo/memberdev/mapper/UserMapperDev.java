package com.ruiyi.demo.memberdev.mapper;

import com.ruiyi.demo.memberdev.model.UserDev;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapperDev {

    List<UserDev> findAll();
}
