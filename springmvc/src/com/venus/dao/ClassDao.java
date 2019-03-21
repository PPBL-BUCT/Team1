package com.venus.dao;

import java.util.List;

import com.venus.domain.Class1;


public interface ClassDao {
	
	public Class1 selectById(Integer id);  
    
    public List<Class1> selectAll();  
    
    public void delete(Integer id);  
}
