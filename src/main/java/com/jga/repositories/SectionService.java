package com.jga.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.Section;
import com.jga.models.Student;

@RestController
public class SectionService {
	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/api/section/{zId}/student/{sId}")
	public void enrollStudentInSection(
			@PathVariable("zId") int zId,
			@PathVariable("sId") int sId) {
		Optional<Section> section = sectionRepository.findById(zId);
		Optional<Student> student = studentRepository.findById(sId);
		section.get().enrollStudent(student.get());
		sectionRepository.save(section.get());
	}	
	
	@PostMapping("/api/section")
	public Section createSection(@RequestBody Section section) {
		return sectionRepository.save(section);
	}
	
	@GetMapping("/api/section/{sId}/student")
	public Iterable<Student> findSectionEnrolledStudents(
						@PathVariable("sId") int sId) {
		Optional<Section> section = sectionRepository.findById(sId);
		return section.get().getEnrolledStudents();
	}

	
	
	
	@GetMapping("/api/section")
	public Iterable<Section> findAllSections() {
		return sectionRepository.findAll();
	}
}
