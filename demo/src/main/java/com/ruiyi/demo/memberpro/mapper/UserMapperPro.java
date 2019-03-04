package com.ruiyi.demo.memberpro.mapper;

import com.ruiyi.demo.memberpro.model.UserPro;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapperPro {

    List<UserPro> findAll();
}
