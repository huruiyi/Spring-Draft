package com.example.service;

import java.util.List;

import com.example.model.MUser;
import com.example.model.User;

public interface UserService {

    List<User> likeName(String name);

    User getById(Long id);

    List<User> getUsers();


    MUser findByName(String name);

    MUser findByNameAndAge(String name, Integer age);

    /*MUser findUser(String name);*/

}
