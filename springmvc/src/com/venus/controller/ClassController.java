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

import com.venus.domain.Class1;
import com.venus.domain.DataGrid;
import com.venus.domain.JsonData;
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

	@RequestMapping("toAddClass.do")
	public ModelAndView toAdd(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = true) Integer id) {
		ModelAndView mav = new ModelAndView("edit_class"); // html文件名
		if (id == 0) {
			return mav;
		} else {
			Class1 class1 = classService.selectById(id);
			mav.addObject("class1", class1);
			return mav;
		}

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

	@ResponseBody
	@RequestMapping(value = "deleteClass.do")
	public JsonData DeleteClass(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = true) Integer id) {
		JsonData json = new JsonData();
		String msg = classService.deleteById(id);
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
	public JsonData addClass(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute Class1 vo) {
		JsonData json = new JsonData();
		String msg = "";
		if (vo.getId() <= 0) {
			vo.setStatus(1);
			vo.setNumber(0);
			msg = classService.insert(vo);
		} else {
			msg = classService.update(vo);
			
		}

		if (msg != null) {
			json.setSuccess(false);
			json.setMsg(msg);
		} else {
			json.setSuccess(true);
		}
		return json;

	}

}