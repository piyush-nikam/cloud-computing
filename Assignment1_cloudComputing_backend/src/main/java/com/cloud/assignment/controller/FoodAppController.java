package com.cloud.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.assignment.dao.FoodOrderDAO;
import com.cloud.assignment.model.FoodOrder;

@RestController
public class FoodAppController {
	
	@Autowired FoodOrderDAO fodao;
	
	@GetMapping("/add")
	public String addFood() {
		FoodOrder fo = new FoodOrder();
		fo.setUserName("user1");
		fo.setFoodType("veg");
		fo.setFoodName("pizza");
		fodao.save(fo);
		return "order processed!";
	}
	
	@GetMapping("/health")
	public String checkApp() {
		return "Application is working";
		
	}
}
