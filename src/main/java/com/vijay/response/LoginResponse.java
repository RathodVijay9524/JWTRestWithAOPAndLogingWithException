package com.vijay.response;

import com.vijay.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
	
	private String token;
	private User user;

	
	
	

}
