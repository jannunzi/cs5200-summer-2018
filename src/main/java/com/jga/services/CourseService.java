package com.jga.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.Course;
import com.jga.models.Faculty;
import com.jga.repositories.CourseRepository;

@RestController
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/api/course")
	public Course createCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
	
	@GetMapping("/api/course/{courseId}/author")
	public Faculty findCourseAuthor(@PathVariable("courseId") int cId) {
		Optional<Course> course = courseRepository.findById(cId);
		return course.get().getAuthor();
	}

}
