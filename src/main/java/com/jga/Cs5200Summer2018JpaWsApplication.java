package com.jga;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jga.dao.CourseDao;
import com.jga.models.Course;
import com.jga.repositories.CourseRepository;

@SpringBootApplication
public class Cs5200Summer2018JpaWsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Cs5200Summer2018JpaWsApplication.class, args);
	}
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	CourseDao courseDao;
	
	@Override
	public void run(String... args) throws Exception {
		
		// using the repository
		List<Course> courses = (List<Course>) courseRepository.findAll();
		for(Course course : courses) {
			System.out.println(course.getTitle());
		}
		
		// using a dao
		courses = courseDao.findAllCourses();
		for(Course course : courses) {
			System.out.println(course.getTitle());
		}
	}
}
