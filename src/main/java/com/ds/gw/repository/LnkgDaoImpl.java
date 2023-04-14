package com.ds.gw.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.gw.domain.LnkgDto;

@Repository("lnkgDao")
public class LnkgDaoImpl implements LnkgDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<LnkgDto> getList(LnkgDto dto) {
		return sm.selectList("Lnkg_getList", dto);
	}

	@Override
	public void insert(LnkgDto dto) {
		sm.insert("Lnkg_insert", dto);
	}

}
