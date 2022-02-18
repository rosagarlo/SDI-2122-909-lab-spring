package com.uniovi.notaneitor.repositories;

import com.uniovi.notaneitor.entities.Mark;
import org.springframework.data.repository.CrudRepository;

// Esta clase es un Bean al utilizar CrudRepository; se puede inyectar en cualquier componente
public interface MarksRepository extends CrudRepository<Mark, Long> {

}
