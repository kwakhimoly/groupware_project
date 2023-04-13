package com.ds.gw.user.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.gw.user.dto.UserDto;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<UserDto> getList(UserDto userdto) {
		
		return sm.selectList("User_getList", userdto);
	}

}
