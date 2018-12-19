package com.ruiyi.demo.web;

import com.ruiyi.demo.dto.User;
import com.ruiyi.demo.mapper.UserDao;
import com.ruiyi.demo.service.UserService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller()
@RequestMapping("/ctx")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(params = "test")
    @ResponseBody
    protected void list() {
        User user = new User();
        user.setName("1");
        user.setPassword("123");
        user.setSex(0);
        userService.insertUser(user);
        user = userService.selectUser(Long.valueOf(1));
    }

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        userService = (UserService) ctx.getBean("userService");
        User user = new User();
        user.setName("1");
        user.setPassword("123");
        user.setSex(0);
        userService.insertUser(user);
    }
}
