package com.Ccorner.securityapp;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;

import com.Ccorner.securityapp.Model.Customers;
import com.Ccorner.securityapp.Repository.UserRepo;

@SpringBootApplication
public class SecurityappApplication {

	
	  @Autowired
	    private UserRepo repository;

	    @PostConstruct
	    public void initUsers() {
	    	
	    repository.save(new Customers(101, "prakash", "password", "prakashshindalkar9929@gmail.com"));
	    	
	    	
	
	    }
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityappApplication.class, args);
	}

}
