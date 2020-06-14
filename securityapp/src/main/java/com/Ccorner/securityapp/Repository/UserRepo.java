package com.Ccorner.securityapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import com.Ccorner.securityapp.Model.Customers;

public interface UserRepo extends  JpaRepository<Customers, Integer>  {
	Customers findByUserName(String username);

    Customers findByEmail(String email);



}
