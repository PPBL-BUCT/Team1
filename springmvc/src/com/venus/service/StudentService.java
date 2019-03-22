package com.venus.service;

import java.util.List;

import com.venus.domain.Student;

public interface StudentService {

	Student selectStudentById(Integer id);
    
    List<Student> selectAllStudent();
    
    /**
     * 获取到 Student 的总数
     * @return
     */
    int getTotal();

    /**
     * 增加一条数据
     * @param student
     */
    void addStudent(Student student);
    
    /**
     * 删除一条数据
     * @param id
     */
    void deleteStudent(int id);

    /**
     * 更新一条数据
     * @param student
     */
    void updateStudent(Student student);
    
    /**
     * 找到一条数据
     * @param id
     * @return
     */
    Student getStudent(int id);
    
    /**
     * 列举出从 start 位置开始的 count 条数据
     * @param start
     * @param count
     * @return
     */
    List<Student> list(int start, int count);
}
