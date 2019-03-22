package com.venus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venus.dao.StudentDao;
import com.venus.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao userDao;

	public Student selectStudentById(Integer Id) {
		return userDao.selectStudentById(Id);

	}

	@Override
	public List<Student> selectAllStudent() {
		// TODO Auto-generated method stub
		return userDao.selectAllStudent();
	}
}