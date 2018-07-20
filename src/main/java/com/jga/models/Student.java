package com.jga.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student extends User {
	private float gpa;
	private int graduationYear;
	
	@ManyToMany
	@JoinTable(name="STUDENT_SECTION",
		joinColumns=@JoinColumn(
				name="STUDENT_ID", 
				referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(
				name="SECTION_ID",
				referencedColumnName="ID"))
	@JsonIgnore
	private List<Section> enrolledSections;
	
	public void enrollSection(Section section) {
		this.enrolledSections.add(section);
		if(!section.getEnrolledStudents().contains(this)) {
			section.getEnrolledStudents().add(this);
		}
	}	
	
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public int getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}
	public List<Section> getEnrolledSections() {
		return enrolledSections;
	}
	public void setEnrolledSections(List<Section> enrolledSections) {
		this.enrolledSections = enrolledSections;
	}
}
