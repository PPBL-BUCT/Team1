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
	
	public int getTotal() {
	    return classDao.getTotal();
	}

	public void addClass(Class1 class1) {
	    classDao.addClass(class1);
	}

	public void deleteClass(Integer id) {
	    classDao.deleteClass(id);
	}

	public void updateClass(Class1 class1) {
	    classDao.updateClass(class1);
	}

	public Class1 getClass(Integer id) {
	    return classDao.getClass(id);
	}
	public List<Class1> list(int start, int count) {
	    return classDao.list(start, count);
	}
}
