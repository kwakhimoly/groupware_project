package com.ds.gw.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ds.gw.domain.DeptDto;
import com.ds.gw.domain.HobbyDto;
import com.ds.gw.domain.LnkgDto;
import com.ds.gw.domain.UserDto;
import com.ds.gw.service.DeptService;
import com.ds.gw.service.HobbyService;
import com.ds.gw.service.LnkgService;
import com.ds.gw.service.UserService;

@Controller
public class AdminController {
	@Resource(name = "userService")
	UserService user_service;
	
	@Resource(name = "deptService")
	DeptService dept_service;

	@Resource(name = "hobbyService")
	HobbyService hob_service;

	@Resource(name = "lnkgService")
	LnkgService lnkg_service;
	
	@GetMapping("/admin")
	public String getList(DeptDto dept_dto, HobbyDto hob_dto, UserDto dto, Model model){
		List<UserDto> resultList = user_service.getList(dto);
		model.addAttribute("result", resultList);
		
		List<DeptDto> deptList = dept_service.getList(dept_dto);
		model.addAttribute("deptList", deptList);
		
		List<HobbyDto> hobList = hob_service.getList(hob_dto);
		model.addAttribute("hobList", hobList);
		
		return "admin";
	}
	
	@GetMapping("/admin/view/{user_id}")
	public String getView(@PathVariable String user_id, Model model, DeptDto dept_dto, HobbyDto hob_dto, UserDto dto) {
		UserDto viewdto = user_service.getView(user_id);
		model.addAttribute("view", viewdto);

		List<DeptDto> deptList = dept_service.getList(dept_dto);
		model.addAttribute("deptList", deptList);
		
		List<HobbyDto> hobList = hob_service.getList(hob_dto);
		model.addAttribute("hobList", hobList);
		
		List<LnkgDto> lnkgList = lnkg_service.getList(user_id);
		StringBuffer user_hobby = new StringBuffer();
		for (int i = 0; i < lnkgList.size(); i++) {
			user_hobby.append(lnkgList.get(i).getLnkg_hobby_id());
			if(i<lnkgList.size()-1) {
				user_hobby.append(",");
			}
		}
		System.out.println(user_hobby);
		model.addAttribute("viewHob",user_hobby);
		
		List<UserDto> resultList = user_service.getList(dto);
		model.addAttribute("result", resultList);
		
		return "admin_view";
	}
	
	@PostMapping("/admin/find")
	public String findByNm() {
		
		return "admin";
	}
}
