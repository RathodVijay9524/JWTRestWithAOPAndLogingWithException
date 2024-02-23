package com.vijay.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRoleController {
	
	
	 @GetMapping
	//@PreAuthorize("hasRole('ROLE_USER')")
	public String UserRole() {
		return "Hi I am User as Role";
	}
	@GetMapping("/hello")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public String normalUsers() {
		return "Hi... User role";
	}


}
