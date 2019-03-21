package com.venus.service;

import java.util.List;

import com.venus.domain.Class1;

public interface ClassService {

	Class1 selectById(Integer id);

	List<Class1> selectAll();

}
