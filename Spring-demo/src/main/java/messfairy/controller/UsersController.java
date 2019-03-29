package messfairy.controller;

import messfairy.dao.UsersDao;
import messfairy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/users"})
public class UsersController {
    @Autowired
    private UsersDao userDao;

    @RequestMapping(value = {""}, method = {RequestMethod.GET})
    public List<User> list() {
        List<User> users = userDao.queryAll();
        return users;
    }
}
