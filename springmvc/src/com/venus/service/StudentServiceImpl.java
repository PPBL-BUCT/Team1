package com.venus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venus.dao.StudentDao;
import com.venus.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	public Student selectStudentById(Integer Id) {
		return studentDao.selectStudentById(Id);

	}

	@Override
	public List<Student> selectAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.selectAllStudent();
	}
	
	
	public int getTotal() {
        return studentDao.getTotal();
    }

	public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }
    
    public Student getStudent(int id) {
        return studentDao.getStudent(id);
    }
    
    public List<Student> list(int start, int count) {
        return studentDao.list(start, count);
    }
}