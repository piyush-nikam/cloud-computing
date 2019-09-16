package com.cloud.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.assignment.dao.FoodOrderDAO;
import com.cloud.assignment.model.FoodOrder;
import com.cloud.assignment.model.Login;

@RestController
public class FoodAppController {

//	@Autowired
	FoodOrderDAO fodao = new FoodOrderDAO();

	@GetMapping("/add")
	public String addFood() {
		FoodOrder fo = new FoodOrder();
		fo.setUserName("user1");
		fo.setFoodType("veg");
		fo.setFoodName("pizza");
		fodao.save(fo);
		return "order processed!";
	}
	
	@PostMapping(path = "/login", consumes = "application/json")
	public String login(@RequestBody Login login) {
		return "success";
	}

	@GetMapping("/health")
	public String checkApp() {
		return "Application is working";

	}
}
