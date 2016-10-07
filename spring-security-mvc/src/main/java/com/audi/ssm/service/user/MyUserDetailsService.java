package com.audi.ssm.service.user;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.audi.ssm.repository.UserRepository;

//@Service
public class MyUserDetailsService implements UserDetailsService {
	@Resource
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

}
