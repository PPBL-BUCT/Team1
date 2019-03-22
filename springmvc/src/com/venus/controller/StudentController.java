package com.venus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.venus.domain.Student;
import com.venus.service.StudentService;

import utill.Page;

@Controller
@RequestMapping("")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/addStudent")
    public String addStudent(HttpServletRequest request, HttpServletResponse response) {

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

        return "redirect:listStudent";
    }

    @RequestMapping("/listStudent")
    public String listStudent(HttpServletRequest request, HttpServletResponse response) {

        // 获取分页参数
        int start = 0;
        int count = 10;

        try {
            start = Integer.parseInt(request.getParameter("page.start"));
            count = Integer.parseInt(request.getParameter("page.count"));
        } catch (Exception e) {
        }

        Page page = new Page(start, count);

        List<Student> students = studentService.list(page.getStart(), page.getCount());
        int total = studentService.getTotal();
        page.setTotal(total);

        request.setAttribute("students", students);
        request.setAttribute("page", page);

        return "listStudent";
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(int id) {
        studentService.deleteStudent(id);
        return "redirect:listStudent";
    }

    @RequestMapping("/editStudent")
    public ModelAndView editStudent(int id) {
        ModelAndView mav = new ModelAndView("editStudent");
        Student student = studentService.getStudent(id);
        mav.addObject("student", student);
        return mav;
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(HttpServletRequest request, HttpServletResponse response) {

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
        return "redirect:listStudent";
    }
}