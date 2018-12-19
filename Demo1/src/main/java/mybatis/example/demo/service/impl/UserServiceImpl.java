package mybatis.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.example.demo.dao.UsersMapper;
import mybatis.example.demo.model.Users;
import mybatis.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{
		
	@Autowired
	private UsersMapper usersMapper;

	@Override
	public void saveUsers(Users users) {
		usersMapper.insert(users);
	}
	
	
}
