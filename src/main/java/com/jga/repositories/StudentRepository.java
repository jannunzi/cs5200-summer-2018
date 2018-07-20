package com.jga.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jga.models.Faculty;
import com.jga.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
