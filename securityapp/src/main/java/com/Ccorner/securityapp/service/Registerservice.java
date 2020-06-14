package com.Ccorner.securityapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ccorner.securityapp.Model.Customers;
import com.Ccorner.securityapp.Repository.UserRepo;

@Service
public class Registerservice {

	
	@Autowired
	private UserRepo repo;
	
	public Customers customerregistration (String email) {
		
	Customers cust=	repo.findByEmail(email);
	return cust;
	
	}
	
	
	
	public List<Customers> allCustomers(){
		
		 List<Customers> cust=	repo.findAll();
		
		return cust;
		
		
		
	}
	
}
