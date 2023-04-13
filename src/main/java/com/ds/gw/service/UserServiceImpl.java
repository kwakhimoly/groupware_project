package com.ds.gw.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ds.gw.domain.UserDto;
import com.ds.gw.repository.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name = "userDao")
	UserDao dao;

	@Override
	public List<UserDto> getList(UserDto userdto) {
		
		return dao.getList(userdto);
	}

	@Override
	public int getTotalCnt(UserDto dto) {
		return dao.getTotalCnt(dto);
	}

	@Override
	public UserDto getView(UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserDto dto) {
		dao.insert(dto);
	}

	@Override
	public void update(UserDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserDto dto) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public boolean isDuplicate(UserDto dto) { return
	 * dao.isDuplicate(dto); }
	 */
}
