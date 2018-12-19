package mybatis.example.service;

import java.util.List;

import mybatis.example.model.MUser;
import mybatis.example.model.User;

public interface UserService {

    List<User> likeName(String name);

    User getById(Long id);

    List<User> getUsers();


    MUser findByName(String name);

    MUser findByNameAndAge(String name, Integer age);

    /*MUser findUser(String name);*/

}
