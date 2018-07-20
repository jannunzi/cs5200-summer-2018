package com.jga.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Faculty extends User {
	private String office;
	private Boolean tenure;
	@OneToMany(mappedBy="author")
	private List<Course> authoredCourses;

	public void authoredCourse(Course course) {
		this.authoredCourses.add(course);
		if(course.getAuthor() != this) {
			course.setAuthor(this);
		}
	}

	
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Boolean getTenure() {
		return tenure;
	}
	public void setTenure(Boolean tenure) {
		this.tenure = tenure;
	}
	public List<Course> getAuthoredCourses() {
		return authoredCourses;
	}
	public void setAuthoredCourses(List<Course> authoredCourses) {
		this.authoredCourses = authoredCourses;
	}
}
