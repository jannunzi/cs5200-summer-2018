package com.jga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.Faculty;
import com.jga.models.Student;
import com.jga.repositories.FacultyRepository;
import com.jga.repositories.StudentRepository;

@RestController
public class StudentService {
	@Autowired
	StudentRepository repository;
	@GetMapping("/api/student")
	public Iterable<Student> findAllStudents() {
		return repository.findAll();
	}
}
