package com.cloud.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.assignment.dao.FoodOrderDAO;
import com.cloud.assignment.dao.UserDAO;
import com.cloud.assignment.model.FoodOrder;
import com.cloud.assignment.model.Login;
import com.cloud.assignment.model.OrderEntry;
import com.cloud.assignment.model.User;

@CrossOrigin(origins = "*")
@RestController
public class FoodAppController {

	@Autowired
	FoodOrderDAO fodao;

	@Autowired
	UserDAO udao;

	@PostMapping(path = "/add", consumes = "application/json")
	public @ResponseBody String addFood(@RequestBody OrderEntry entry) {
		FoodOrder fo = new FoodOrder();
		fo.setUserName(entry.getUserName());
		fo.setFoodType(entry.getFoodType());
		fo.setFoodName(entry.getFoodName());
		fodao.save(fo);
		return "{ \"add\": \"order processed!\" }";
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<FoodOrder> allEntries() {
		return fodao.findAll();

	}

	@PostMapping(path = "/register", consumes = "application/json")
	public @ResponseBody String register(@RequestBody User user) {
		udao.save(user);
		return "{ \"register\": \"success\" }";
	}

	@PostMapping(path = "/login", consumes = "application/json")
	public @ResponseBody String login(@RequestBody Login login) {
		String access = "Not Registered";
		for (User user : udao.findAll()) {
			if (user.getUserName().equals(login.getUserName()) && user.getPassword().equals(login.getPassword())) {
				access = "success";
				break;
			}
		}
		return "{ \"auth\": \"" + access + "\" }";
	}

	@GetMapping("/health")
	public @ResponseBody String checkApp() {
		return "{ \"health\": \"good\" }";
	}
}
