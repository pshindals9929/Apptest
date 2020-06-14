package com.Ccorner.securityapp.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Ccorner.securityapp.Model.Customers;
import com.Ccorner.securityapp.Repository.UserRepo;

@Service
public class CustomeuserDetailsService  implements UserDetailsService {

	@Autowired
	private UserRepo userrepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Customers user=	userrepo.findByUserName(username);
		return new User(user.getUsername(),user.getPassword(),(Collection<? extends GrantedAuthority>) new ArrayList<GrantedAuthority>());
	}

}
