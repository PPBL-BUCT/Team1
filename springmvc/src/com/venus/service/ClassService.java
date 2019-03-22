package com.venus.service;

import java.util.List;

import com.venus.domain.Class1;

public interface ClassService {
	
	/**
	 * 找到一条数据
	 * 
	 * @param id
	 * @return
	 */
	Class1 selectById(Integer id);

	List<Class1> selectAll();

	/**
	 * 获取到 Student 的总数
	 * 
	 * @return
	 */
	int getTotal();
	/**
	 * 列举出从 start 位置开始的 count 条数据
	 * 
	 * @param start
	 * @param count
	 * @return
	 */
	List<Class1> list(int start, int count);

	String deleteById(Integer id);

	String insert(Class1 c);

	String update(Class1 c);

}
