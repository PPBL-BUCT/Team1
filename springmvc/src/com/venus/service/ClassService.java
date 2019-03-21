package com.venus.service;

import java.util.List;

import com.venus.domain.Class1;
import com.venus.domain.User;

public interface ClassService {

	Class1 selectById(Integer id);
    
    List<Class1> selectAll();

}
