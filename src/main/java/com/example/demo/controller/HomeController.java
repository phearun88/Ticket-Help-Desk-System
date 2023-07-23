package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String home() {
		return "/admin/dashboard";
	}
	
	
	@GetMapping("/user_register")
	public String addUser() {
		return "/admin/add_user";
	}
	
	
	@GetMapping("/users")
	public String listUser() {
		return "/admin/list_user";
	}
	
	@GetMapping("/users_log")
	public String listUserLog() {
		return "/admin/list_user_log";
	}
	
	
	@GetMapping("/myinfor")
	public String userDetail() {
		return "/admin/user_detail";
	}
	
	
	
	@GetMapping("/categories")
	public String listCategories() {
		return "/admin/category";
	}

	@GetMapping("/test")
	public String test() {
		return "/admin/test";
	}
	
	@GetMapping("/request")
	public String listRequest() {
		return "/admin/list_request";
	}
	
	@GetMapping("/request_form")
	public String formRequest() {
		return "/admin/form_request";
	}
	
	@GetMapping("/request_temp")
	public String formRequestTemp() {
		return "/admin/list_request_temp";
	}
	
	
	@GetMapping("/request_tempEdit/{request_id}")
	public String formRequestEdit() {
		return "/admin/form_request_temp";
	}
	
	
	@GetMapping("/request/{request_id}")
	public String request() {
		return "/admin/check_request";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/admin/login";
	}
}
