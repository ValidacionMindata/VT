package com.mindata.challenge.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.mindata.challenge.model.Course;

@Service
public class CourseService {
	List<Course> courses = new ArrayList<Course>();
	
	public CourseService () throws ParseException {
		String[] catalog = {"VSICM67", "VMCEV95", "RHCT", "RHCSA", "RHCE", "RHCA", "RHCSS", "MCSA", "MCAD", "MCDBA", "MCSE", "MCSD", "MCITP"};
		
		Random r = new Random();
		
		for (int i=0;i<50;i++){
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, r.nextInt(400));
			c.set(Calendar.HOUR, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
			courses.add(new Course(catalog[r.nextInt(catalog.length)], c.getTime()));
		}		
	}
	
	public Result<Course> find(String course, Date fromDate, Integer page){
		return new Result<>(courses.size(), courses);
	}
}
