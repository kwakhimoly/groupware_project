package com.ds.gw.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ds.gw.domain.DeptDto;
import com.ds.gw.domain.HobbyDto;
import com.ds.gw.domain.UserDto;
import com.ds.gw.domain.allDto;
import com.ds.gw.service.DeptService;
import com.ds.gw.service.HobbyService;
import com.ds.gw.service.UserService;

@Controller
public class UserController {
	@Resource(name = "userService")
	UserService user_service;
	
	@Resource(name = "deptService")
	DeptService dept_service;

	@Resource(name = "hobbyService")
	HobbyService hob_service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/user/list")
	public String getList(UserDto dto, Model model){
		List<UserDto> resultList = user_service.getList(dto);
		model.addAttribute("result", resultList);
		return "user_list";
	}
	
	@GetMapping("/user/write")
	public String getWrite(DeptDto dept_dto, HobbyDto hob_dto, Model model) {
		allDto form = new allDto();
		model.addAttribute("form", form);
		List<DeptDto> deptList = dept_service.getList(dept_dto);
		model.addAttribute("deptList", deptList);
		List<HobbyDto> hobList = hob_service.getList(hob_dto);
		model.addAttribute("hobList", hobList);
		return "user_write";
	}
	
//	@ModelAttribute("hobList")
//	public Map<String, String> hoblist(HobbyDto hob_dto) {
//		List<HobbyDto> hobList = hob_service.getList(hob_dto);
//	    Map<String, String> hobMap = new LinkedHashMap<>();
//		for (int i = 0; i < hobList.size(); i++) {
//			hobMap.put(hobList.get(i).getHobby_id(), hobList.get(i).getHobby_nm());
//		}
//	    return hobMap;
//	}
	
	@PostMapping("/user/save")
	public String postSave(@ModelAttribute allDto form, UserDto dto, HobbyDto hob_dto) {
		UserDto userResult = new UserDto();
		userResult.setUser_addr(form.getUser_addr());
		userResult.setUser_dept_se_no(form.getUser_dept_se_no());
		userResult.setUser_eml_addr(form.getUser_eml_addr());
		userResult.setUser_id(form.getUser_id());
		userResult.setUser_nm(form.getUser_nm());
		userResult.setUser_telno(form.getUser_telno());
		user_service.insert(userResult);
		return "redirect:/";
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
