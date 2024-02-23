package com.vijay.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/normal")
public class NormalUserController {
	
	
	
	@GetMapping
	//@PreAuthorize("hasRole('ROLE_NORMAL')")
	public String normalUser() {
		return "Hi I am normal user";
	}
	
	@GetMapping("/hello")
	//@PreAuthorize("hasRole('ROLE_NORMAL')")
	public String normalUsers() {
		return "Hi... normal";
	}

}
