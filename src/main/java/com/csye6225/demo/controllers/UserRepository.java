package com.csye6225.demo.controllers;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<user, Long> {

    }

