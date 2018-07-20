package com.jga.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jga.models.Section;
public interface SectionRepository extends CrudRepository<Section, Integer> {
	
}
