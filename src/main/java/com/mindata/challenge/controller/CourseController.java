package com.mindata.challenge.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindata.challenge.model.Course;
import com.mindata.challenge.service.CourseService;
import com.mindata.challenge.service.Result;

@Controller
public class CourseController {
	public final static int pageSize = 10;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/find")
	public String find(@RequestParam(required=false) String course, @RequestParam(required=false) @DateTimeFormat(pattern="dd/MM/yyyy") Date fromDate, @RequestParam(required=false) Integer page, Model model) {
		Result<Course> results = courseService.find(course, fromDate, page);
		
		//valores devueltos a la página para ser mostrados
		model.addAttribute("courses", results.getPagedResults());
		model.addAttribute("totalResults", results.getTotalQuantity());
		model.addAttribute("pageSize", pageSize);
		return "find";
	}
}
