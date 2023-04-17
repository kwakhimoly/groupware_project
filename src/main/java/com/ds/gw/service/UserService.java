package com.ds.gw.service;

import java.util.List;

import com.ds.gw.domain.UserDto;

public interface UserService {
	List<UserDto> getList(UserDto userdto);
	int getTotalCnt(UserDto dto);
	UserDto getView(String user_id);
	void insert(UserDto dto);
	void update(UserDto dto);
	void delete(UserDto dto);
}
