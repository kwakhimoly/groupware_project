package com.ds.gw.repository;

import java.util.List;

import com.ds.gw.domain.LnkgDto;

public interface LnkgDao {
	List<LnkgDto> getList(LnkgDto dto);
	void insert(LnkgDto dto);
}
