package com.ruiy;

import com.ruiyi.dto.User;
import com.ruiyi.mapper.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Demo1 {

    @Test
    public void Test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean(UserDao.class);
        User user = userDao.selectUser(1l);
        System.out.println(user);
    }
}
