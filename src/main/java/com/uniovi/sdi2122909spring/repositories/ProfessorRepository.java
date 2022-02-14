package com.uniovi.sdi2122909spring.repositories;

import com.uniovi.sdi2122909spring.entities.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    
}
