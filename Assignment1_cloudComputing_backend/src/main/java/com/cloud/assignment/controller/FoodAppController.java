package com.cloud.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodAppController {
	
	@GetMapping("/add")
	public String addFood() {
		return "Get ready to eat";
	}
}
