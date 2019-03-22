package com.venus.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.venus.domain.Class1;
import com.venus.domain.DataGrid;
import com.venus.domain.JsonData;
import com.venus.domain.Pagination;
import com.venus.domain.Student;
import com.venus.service.ClassService;
import com.venus.service.StudentService;

/*@Controller
@RequestMapping("")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/addStudent.do")
	public String addStudent(HttpServletRequest request,
			HttpServletResponse response) {

		Student student = new Student();

		int studentID = Integer.parseInt(request.getParameter("id"));
		int classID = Integer.parseInt(request.getParameter("classid"));
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String nation = request.getParameter("nation");
		Date birthday = null;
		// String 类型按照 yyyy-MM-dd 的格式转换为 java.util.Date 类
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			birthday = simpleDateFormat.parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		student.setId(studentID);
		student.setName(name);
		student.setClassId(classID);
		student.setSex(sex);
		student.setBirthday(birthday);
		student.setNation(nation);

		studentService.addStudent(student);

		return "redirect:student_list";
	}*/

    @Controller
    public class StudentController {
	    @Autowired(required = false)
	    private StudentService studentService;

	@RequestMapping("toStudentList.do")
	public ModelAndView toStudentList(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("student_list"); // html文件名
		return mav;
	}

	@RequestMapping("toAddStudent.do")
	public ModelAndView toAdd(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = true) Integer id) {
		ModelAndView mav = new ModelAndView("edit_student"); // html文件名
		if (id == 0) {
			return mav;
		} else {
			Student student = studentService.selectStudentById(id);
			mav.addObject("student", student);
			return mav;
		}

	}

	@RequestMapping(value = "StudentList.do")
	@ResponseBody
	public DataGrid StudentList(HttpServletRequest request,
			HttpServletResponse response) {
		DataGrid dataGrid = new DataGrid();
		List<Student> list = this.studentService.selectAllStudent();
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
	@RequestMapping(value = "addClass.do")
	public JsonData addStudent(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Student vo) {
		JsonData json = new JsonData();
		String msg = "";
		if (vo.getId() > 0) {
			vo.setStatus(1);
			//vo.setNumber(0);
			msg = studentService.addStudent(vo);
		} else {
			msg = studentService.updateStudent(vo);
		}

		if (msg != null) {
			json.setSuccess(false);
			json.setMsg(msg);
		} else {
			json.setSuccess(true);
		}
		return json;}
    }
	/*@RequestMapping("toStudentList.do")
	public ModelAndView toClassList(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("student_list"); // html文件名
		return mav;
	}
    
	@RequestMapping(value = "StudentList.do")
	@ResponseBody
	public DataGrid ClassList(HttpServletRequest request,
			HttpServletResponse response) {
		DataGrid dataGrid = new DataGrid();
		List<Student> list = this.studentService.selectAllStudent();
		Pagination pagination = new Pagination();
		pagination.setList(list);
		dataGrid.setTotal(pagination.getTotalCount());
		dataGrid.setRows(pagination.getList());
		return dataGrid;
	}

	@RequestMapping("/deleteStudent.do")
	public String deleteStudent(int id) {
		studentService.deleteStudent(id);
		return "redirect:student_list";
	}

	@RequestMapping("/editStudent.do")
	public ModelAndView editStudent(int id) {
		ModelAndView mav = new ModelAndView("editStudent");
		Student student = studentService.getStudent(id);
		mav.addObject("student", student);
		return mav;
	}

	@RequestMapping("/updateStudent.do")
	public String updateStudent(HttpServletRequest request,
			HttpServletResponse response) {

		Student student = new Student();

		int studentID = Integer.parseInt(request.getParameter("id"));
		int classID = Integer.parseInt(request.getParameter("classid"));
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String nation = request.getParameter("nation");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = simpleDateFormat.parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		student.setId(studentID);
		student.setClassId(classID);
		student.setName(name);
		student.setSex(sex);
		student.setBirthday(birthday);
		student.setNation(nation);

		studentService.updateStudent(student);
		return "redirect:student_list";
	}*/
