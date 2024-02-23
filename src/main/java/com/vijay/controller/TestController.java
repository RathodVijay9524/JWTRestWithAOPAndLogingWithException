package com.vijay.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String admin() {
		return "Hi I am Admin as Role";
	}
	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String user() {
		return "Hi... User role";
	}
	
	@GetMapping("/normal")
	@PreAuthorize("hasRole('ROLE_NORMAL')")
	public String normal() {
		return "Hi... Normal role";
	}

	
	
	
	
	

}
