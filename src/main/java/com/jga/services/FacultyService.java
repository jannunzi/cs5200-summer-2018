package com.jga.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.Course;
import com.jga.models.Faculty;
import com.jga.repositories.CourseRepository;
import com.jga.repositories.FacultyRepository;

@RestController
public class FacultyService {
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping("/api/faculty")
	public Iterable<Faculty> findAllFaculty() {
		return facultyRepository.findAll();
	}
	
	@PutMapping("/api/faculty/{fId}/authored/{cId}")
	public void authoredCourse(
			@PathVariable("fId") int fId,
			@PathVariable("cId") int cId) {
		Optional<Faculty> ofaculty = facultyRepository.findById(fId);
		Optional<Course> ocourse   = courseRepository.findById(cId);
		if(ofaculty.isPresent() && ocourse.isPresent()) {
			Course course = ocourse.get();
			Faculty faculty = ofaculty.get();
			course.setAuthor(faculty);
			courseRepository.save(course);
			faculty.authoredCourse(course);
			facultyRepository.save(faculty);
		}
	}
	
	@GetMapping("/api/faculty/{facultyId}/authored")
	public Iterable<Course> findAuthoredCourses(
			@PathVariable("facultyId") int fId) {
		Optional<Faculty> ofaculty = facultyRepository.findById(fId);
		return ofaculty.get().getAuthoredCourses();
	}
}
