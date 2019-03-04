package com.example.demo.memberDev.mapper;

import com.example.demo.memberDev.model.UserDev;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapperDev {

    List<UserDev> findAll();
}
