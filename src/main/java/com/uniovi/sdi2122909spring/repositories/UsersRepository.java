package com.uniovi.sdi2122909spring.repositories;

import com.uniovi.sdi2122909spring.entities.*;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
}
