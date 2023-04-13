package com.ds.gw.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ds.gw.user.dao.UserDao;
import com.ds.gw.user.dto.UserDto;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name = "userDao")
	UserDao dao;

	@Override
	public List<UserDto> getList(UserDto userdto) {
		
		return dao.getList(userdto);
	}
}
