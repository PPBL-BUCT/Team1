package com.venus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.venus.domain.DataGrid;
import com.venus.domain.JsonData;
import com.venus.domain.Pagination;
import com.venus.domain.Student;
import com.venus.service.StudentService;

@Controller
public class StudentController {
	@Autowired(required = false)
	private StudentService studentService;

	@RequestMapping("toStudentList.do")
	public ModelAndView toStudentList(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = true) Integer id) {
		ModelAndView mav = new ModelAndView("student_list"); // html文件名
		mav.addObject("id", id);
		return mav;
	}

	@RequestMapping("toAddStudent.do")
	public ModelAndView toAdd(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("edit_student"); // html文件名
		return mav;

	}

	@RequestMapping(value = "StudentList.do")
	@ResponseBody
	public DataGrid StudentList(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = true) Integer id) {
		DataGrid dataGrid = new DataGrid();
		List<Student> list = this.studentService.selectStudentByClass(id);
		Pagination pagination = new Pagination();
		pagination.setList(list);
		dataGrid.setTotal(pagination.getTotalCount());
		dataGrid.setRows(pagination.getList());
		return dataGrid;
	}

	@ResponseBody
	@RequestMapping(value = "deleteStudent.do")
	public JsonData DeleteStudent(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = true) Integer id) {
		JsonData json = new JsonData();
		String msg = studentService.deleteStudent(id);
		if (msg != null) {
			json.setSuccess(false);
			json.setMsg(msg);
		} else {
			json.setSuccess(true);
		}
		return json;

	}

	@ResponseBody
	@RequestMapping(value = "addStudent.do")
	public JsonData addStudent(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Student vo) {
		JsonData json = new JsonData();
		String msg = studentService.addStudent(vo);

		if (msg != null) {
			json.setSuccess(false);
			json.setMsg(msg);
		} else {
			json.setSuccess(true);
		}
		return json;
	}
}
