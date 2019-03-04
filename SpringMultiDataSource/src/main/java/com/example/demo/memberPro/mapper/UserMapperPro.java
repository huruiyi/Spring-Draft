package com.example.demo.memberPro.mapper;

import com.example.demo.memberPro.model.UserPro;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapperPro {

    List<UserPro> findAll();
}
