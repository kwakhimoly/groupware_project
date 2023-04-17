package com.ds.gw.repository;

import java.util.List;

import com.ds.gw.domain.UserDto;

public interface UserDao {
	List<UserDto> getList(UserDto userdto);
	int getTotalCnt(UserDto dto);
	UserDto getView(String user_id);
	void insert(UserDto dto);
	void update(UserDto dto);
	void delete(UserDto dto);
}
