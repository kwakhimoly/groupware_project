package com.ds.gw.user.dao;

import java.util.List;

import com.ds.gw.user.dto.UserDto;

public interface UserDao {
	List<UserDto> getList(UserDto userdto);
}
