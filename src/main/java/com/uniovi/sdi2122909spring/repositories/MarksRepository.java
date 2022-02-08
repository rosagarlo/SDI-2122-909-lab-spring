package com.uniovi.sdi2122909spring.repositories;

import com.uniovi.sdi2122909spring.entities.Mark;
import org.springframework.data.repository.CrudRepository;

// Esta clase es un Bean al utilizar CrudRepository; se puede inyectar en cualquier componente
public interface MarksRepository extends CrudRepository<Mark, Long> {

}
