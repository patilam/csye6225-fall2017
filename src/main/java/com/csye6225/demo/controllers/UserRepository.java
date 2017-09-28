package com.csye6225.demo.controllers;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface UserRepository extends CrudRepository<user, Long> {

    List<user> findAll(Specification<user> spec);
    }

