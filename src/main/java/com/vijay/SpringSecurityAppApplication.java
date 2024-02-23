package com.vijay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.vijay.entity.Authority;
import com.vijay.entity.User;
import com.vijay.repository.UserRepository;


import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class SpringSecurityAppApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	} 
	
	@PostConstruct
	protected void init() {
		
		List<Authority> authorityList=new ArrayList<>();
		authorityList.add(createAuthority("ROLE_ADMIN","ROLE_ADMIN"));
		authorityList.add(createAuthority("ROLE_USER","ROLE_USER"));
		authorityList.add(createAuthority("ROLE_NORMAL","NORMAL_USER"));
		
        List<Authority> authorityList1=new ArrayList<>();
		authorityList1.add(createAuthority("ROLE_USER","ROLE_USER"));
		
		List<Authority> authorityList2=new ArrayList<>();
		authorityList2.add(createAuthority("ROLE_NORMAL","NORMAL_USER"));
			
		
		User user=User.builder()
				.userName("admin")
				.firstName("Vijay")
				.lastName("Rathod")
				.email("omvijay44@gmail.com")
				.phoneNumber("9086354")
				.password(passwordEncoder.encode("admin"))
				.enabled(true)
				.authorities(authorityList)
				.build();
		
		
        User user1=new User();
		user1.setUserName("user");
		user1.setFirstName("Kirna");
		user1.setLastName("Rathod");
		user1.setEmail("Kiran@gmail.com");
		user1.setPassword(passwordEncoder.encode("user"));
		user1.setEnabled(true);
		user1.setAuthorities(authorityList1);
		
		 User user2=new User();
			
		 user2.setUserName("normal");
		 user2.setFirstName("Ramesh");
		 user2.setLastName("Jadhav");
		 user2.setEmail("jadhav@gmail.com");
			
		 user2.setPassword(passwordEncoder.encode("normal"));
		 user2.setEnabled(true);
		 user2.setAuthorities(authorityList2);
		
		  List<User> users = Arrays.asList(user,user1,user2);
		  userDetailsRepository.saveAll(users);
	      log.info("user Added successfully");
		
		 
		
		
		
	}
	
	
	private Authority createAuthority(String roleCode,String roleDescription) {
		Authority authority=new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}
	
	

}
