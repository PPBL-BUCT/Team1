package com.venus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venus.dao.ClassDao;
import com.venus.domain.Class1;

@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassDao classDao;

	@Override
	public Class1 selectById(Integer id) {
		return classDao.selectById(id);

	}

	@Override
	public List<Class1> selectAll() {
		// TODO Auto-generated method stub
		return classDao.selectAll();
	}

}
