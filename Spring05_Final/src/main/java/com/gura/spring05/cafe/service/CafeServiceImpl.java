package com.gura.spring05.cafe.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gura.spring05.cafe.dao.CafeDao;
import com.gura.spring05.cafe.dto.CafeDto;

@Service
public class CafeServiceImpl implements CafeService{
	// 의존객체 DI
	@Autowired
	public CafeDao cafeDao;
	
	/* 위의 의존객체가 Spring Bean Container에서 이렇게 변경된다.
	public void setCafeDao(CafeDao cafeDao) {
		this.cafeDao = cafeDao;
	}
	*/
	@Override
	public void saveContent(CafeDto dto) {
		cafeDao.insert(dto);
	}

	
}
