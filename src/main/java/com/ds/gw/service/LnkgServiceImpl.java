package com.ds.gw.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ds.gw.domain.LnkgDto;
import com.ds.gw.repository.LnkgDao;

@Service("lnkgService")
public class LnkgServiceImpl implements LnkgService {
	@Resource(name = "lnkgDao")
	LnkgDao dao;

	@Override
	public List<LnkgDto> getList(LnkgDto dto) {
		return dao.getList(dto);
	}

	@Override
	public void insert(LnkgDto dto) {
		dao.insert(dto);
	}

}
