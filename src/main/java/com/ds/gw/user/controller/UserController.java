package com.ds.gw.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ds.gw.user.dto.UserDto;
import com.ds.gw.user.service.UserService;

@Controller
public class UserController {
	@Resource(name = "userService")
	UserService service;
	
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/user/list")
	public String getList(UserDto dto, Model model){
		List<UserDto> resultList = service.getList(dto);
		model.addAttribute("result", resultList);
		return "user_list";
	}
}
