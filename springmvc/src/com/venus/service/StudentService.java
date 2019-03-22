package com.venus.service;

import java.util.List;

import com.venus.domain.Student;

public interface StudentService {

	Student selectStudentById(Integer Id);
    
    List<Student> selectAllStudent();
}
