package com.ds.gw.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.gw.domain.UserDto;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<UserDto> getList(UserDto userdto) {
		
		return sm.selectList("User_getList", userdto);
	}

	@Override
	public int getTotalCnt(UserDto dto) {
		return sm.selectOne("User_getTotalCnt", dto);
	}

	@Override
	public UserDto getView(UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserDto dto) {
		sm.insert("User_insert", dto);
		
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
	 * @Override public boolean isDuplicate(UserDto dto) { int result =
	 * sm.selectOne("User_idCheck", dto);
	 * 
	 * if(result==0) { return true; }
	 * 
	 * return false; }
	 */

}
