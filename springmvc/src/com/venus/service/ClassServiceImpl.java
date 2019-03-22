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
		return classDao.selectAll();
	}

	public int getTotal() {
		return classDao.getTotal();
	}

	public List<Class1> list(int start, int count) {
		return classDao.list(start, count);
	}

	@Override
	public String deleteById(Integer id) {
		// 先从数据库取出来
		Class1 class1 = classDao.selectById(id);
		// 判断人数是否为0
		if (class1.getNumber() > 0) {
			return "人数大于0，无法删除";
		}
		// 可以删的话把class的status改为0
		class1.setStatus(0);
		classDao.update(class1);
		// 如果任何一步出错就return "错误提醒"
		return null;
	}

	@Override
	public String insert(Class1 c) {
		classDao.insert(c);
		return null;
	}

	@Override
	public String update(Class1 c) {
		classDao.update(c);
		return null;
	}

}
