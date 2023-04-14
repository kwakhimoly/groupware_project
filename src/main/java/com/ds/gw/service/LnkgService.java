package com.ds.gw.service;

import java.util.List;

import com.ds.gw.domain.LnkgDto;

public interface LnkgService {
	List<LnkgDto> getList(LnkgDto dto);
	void insert(LnkgDto dto);
}
