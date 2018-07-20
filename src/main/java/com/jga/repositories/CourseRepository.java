package com.jga.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jga.models.Course;
public interface CourseRepository extends CrudRepository<Course, Integer> {
	
}
