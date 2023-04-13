package com.ds.gw.user.service;

import java.util.List;

import com.ds.gw.user.dto.UserDto;

public interface UserService {
	List<UserDto> getList(UserDto userdto);
}
