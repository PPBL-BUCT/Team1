package com.venus.service;

import java.util.List;

import com.venus.domain.Class1;

public interface ClassService {

	Class1 selectById(Integer id);

	List<Class1> selectAll();
	
	/**
     * 获取到 Student 的总数
     * @return
     */
    int getTotal();

    /**
     * 增加一条数据
     * @param student
     */
    void addClass(Class1 class1);

    /**
     * 删除一条数据
     * @param id
     */
    void deleteClass(Integer id);

    /**
     * 更新一条数据
     * @param student
     */
    void updateClass(Class1 class1);

    /**
     * 找到一条数据
     * @param id
     * @return
     */
    Class1 getClass(Integer id);
    /**
     * 列举出从 start 位置开始的 count 条数据
     * @param start
     * @param count
     * @return
     */
    List<Class1> list(int start, int count);
}
