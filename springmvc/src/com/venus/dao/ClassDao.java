package com.venus.dao;

import java.util.List;

import com.venus.domain.Class1;


public interface ClassDao {
	
	public Class1 selectById(Integer id);    //查询单条记录
    public List<Class1> selectAll();	//查询所有记录
    
    int getTotal();  //获取到班级的总数
    public void addClass(Class1 class1);  //增加班级
    public void deleteClass(int id);   //删除班级
    public void updateClass(Class1 class1);  //修改班级
    Class1 getClass(int id);  //查找班级
    public List<Class1> list(int start, int count);  //列举出从 start 位置开始的 count 条数据
}
