package com.vijay.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminRoleController {
	
	
	
	@GetMapping 
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String UserRole() {
		return "Hi I am Admin as Role";
	}
	@GetMapping("/hello")
	//@PreAuthorize("hasRole('ROLE_ADMIN')") 
	public String normalUsers() {
		return "Hi... Admin role";
	}


}



// 
//@PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and #userId == principal.userId)") 