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

	@Override
	public Student selectStudentById(Integer id) {
		return studentDao.selectStudentById(id);

	}

	@Override
	public List<Student> selectAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.selectAllStudent();
	}

	@Override
	public List<Student> selectStudentByClass(int classId) {
		// TODO Auto-generated method stub
		return studentDao.selectStudentByClass(classId);
	}

	public int getTotal() {
		return studentDao.getTotal();
	}

	public String addStudent(Student student) {
		studentDao.addStudent(student);
		return null;

	}

	public String deleteStudent(int id) {
		// studentDao.deleteStudent(id);
		// 先从数据库取出来
		Student student = studentDao.selectStudentById(id);
		student.setStatus(0);
		studentDao.updateStudent(student);
		return null;
	}

	public String updateStudent(Student student) {
		studentDao.updateStudent(student);
		return null;
	}

	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}

	public List<Student> list(int start, int count) {
		return studentDao.list(start, count);
	}
}