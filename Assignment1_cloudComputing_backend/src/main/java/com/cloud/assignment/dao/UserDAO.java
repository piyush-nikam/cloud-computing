package com.cloud.assignment.dao;

import org.springframework.data.repository.CrudRepository;

import com.cloud.assignment.model.User;

public interface UserDAO extends CrudRepository<User, Integer> {
}