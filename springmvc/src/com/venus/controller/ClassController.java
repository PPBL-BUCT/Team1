package com.venus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.venus.domain.Class1;
import com.venus.domain.DataGrid;
import com.venus.domain.Pagination;
import com.venus.service.ClassService;

@Controller
public class ClassController {
	@Autowired(required = false)
	private ClassService classService;

	@RequestMapping("toClassList.do")
	public ModelAndView toClassList(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("class_list"); // html文件名
		return mav;
	}

	@RequestMapping(value = "ClassList.do")
	@ResponseBody
	public DataGrid ClassList(HttpServletRequest request,
			HttpServletResponse response) {
		DataGrid dataGrid = new DataGrid();
		List<Class1> list = this.classService.selectAll();
		Pagination pagination = new Pagination();
		pagination.setList(list);
		dataGrid.setTotal(pagination.getTotalCount());
		dataGrid.setRows(pagination.getList());
		return dataGrid;
	}

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="DeleteClass.do") public JsonData
	 * DeleteClass(HttpServletRequest request, HttpServletResponse response ) {
	 * 
	 * return classService.delete(); }
	 */

}