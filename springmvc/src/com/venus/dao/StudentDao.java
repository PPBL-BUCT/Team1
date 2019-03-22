package com.venus.dao;

import java.util.List;

import com.venus.domain.Student;

public interface StudentDao {
    public Student selectStudentById(Integer Id);  
    
    public List<Student> selectAllStudent();  
    
    void addStudent(Student student);
    
    void deleteStudent(int Id);
    
    void updateStudent(Student student);
}
