package com.venus.dao;

import java.util.List;

import com.venus.domain.Class1;

public interface ClassDao {

	int getTotal(); // 获取到班级的总数

	public List<Class1> list(int start, int count); // 列举出从 start 位置开始的 count
													// 条数据

	public Class1 selectById(Integer id);

	public List<Class1> selectAll();

	public void delete(Integer id);

	public void insert(Class1 c);

	public void update(Class1 c);
}
