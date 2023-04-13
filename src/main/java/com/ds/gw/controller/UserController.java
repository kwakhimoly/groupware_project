package com.ds.gw.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ds.gw.domain.UserDto;
import com.ds.gw.service.UserService;

@Controller
public class UserController {
	@Resource(name = "userService")
	UserService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/user/list")
	public String getList(UserDto dto, Model model){
		List<UserDto> resultList = service.getList(dto);
		model.addAttribute("result", resultList);
		return "user_list";
	}
	
	@GetMapping("/user/write")
	public String getWrite(UserDto dto, Model model) {
		List<UserDto> resultList = service.getList(dto);
		model.addAttribute("result", resultList);
		return "user_write";
	}
	
	@PostMapping("/user/save")
	public String postSave(UserDto dto) {
		System.out.println(dto.getUser_id());
		return "redirect:/user/list";
	}
	
	/*
	 * @RequestMapping("/user/idcheck")
	 * 
	 * @ResponseBody public Map<String, String> idCheck(UserDto dto){ Map<String,
	 * String> map = new HashMap<>();
	 * 
	 * if(service.isDuplicate(dto)) { map.put("result", "success"); } else {
	 * map.put("result", "fail"); } System.out.println("실행"); return map; }
	 */
}
