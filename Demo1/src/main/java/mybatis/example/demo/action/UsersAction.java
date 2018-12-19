package mybatis.example.demo.action;

import mybatis.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mybatis.example.demo.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UsersAction {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveUsers")
    @ResponseBody
    public int saveUsers(String name, String pwd) {
        Users users = new Users();
        users.setName(name);
        users.setPwd(pwd);
        userService.saveUsers(users);
        return 1;
    }

}
