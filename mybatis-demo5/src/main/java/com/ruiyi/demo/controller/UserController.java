package com.ruiyi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruiyi.demo.model.User;
import com.ruiyi.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String list(ModelMap map) {
		List<User> userList = userService.findAll();
		map.addAttribute("userList", userList);
		return "/user/list";
	}
}