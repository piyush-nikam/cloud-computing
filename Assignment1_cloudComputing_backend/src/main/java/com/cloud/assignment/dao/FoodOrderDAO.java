package com.cloud.assignment.dao;

import org.springframework.data.repository.CrudRepository;

import com.cloud.assignment.model.FoodOrder;

public interface FoodOrderDAO extends CrudRepository<FoodOrder, String>{

}
