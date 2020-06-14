package com.Ccorner.securityapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ccorner.securityapp.Model.AuthRequest;
import com.Ccorner.securityapp.Model.Customers;
import com.Ccorner.securityapp.Repository.UserRepo;
import com.Ccorner.securityapp.Util.JwtUtil;
import com.Ccorner.securityapp.service.Registerservice;

@RestController
public class WelcomeController {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private Registerservice register;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authentication;  
	
	@RequestMapping("/")
	public String welcome() {
	return "welcom to Ccorner";}
	
	@PostMapping("/authenticate" )
	public String test(@RequestBody  AuthRequest authrequest) throws Exception {
	
	try {	
     authentication
	 .authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUserName(),authrequest.getPassword() ));
	}
	catch(Exception e){
		throw new Exception("Invalid Username/Password");
	}
		
		
		return jwtUtil.generateToken(authrequest.getUserName()); 
		
		
}
	
@PostMapping("/register")
public String register(@RequestBody Customers customer)	{
	
	Customers cust=register.customerregistration(customer.getEmail());
	
	if(cust!=null) {
		
		return "user already exist";
	}
	
	repo.save(customer);
	
	
	return "registered successfully";
	
	
	
	
}


@GetMapping("/all")
	public List viewAll() {
		List<Customers> cust =register.allCustomers();
		
		return cust;
	}
	
	
}















