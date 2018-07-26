package com.jga.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jga.models.Course;
import com.jga.repositories.CourseRepository;

@Component
public class CourseDao {
	@Autowired
	CourseRepository courseRepository;
	
	public List<Course> findAllCourses() {
		return (List<Course>) courseRepository.findAll();
	}
}
