package com.pa.dao;

import java.util.List;

import com.pa.model.User;

public interface UserMapper {

	List<User> findAll();
}
