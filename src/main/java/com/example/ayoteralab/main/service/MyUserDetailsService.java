package com.example.ayoteralab.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ayoteralab.main.dto.MyUserDetails;
import com.example.ayoteralab.main.dto.UserDTO;
import com.example.ayoteralab.main.mapper.UserInfoMapper;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUserDetails mud = userInfoMapper.getUserInfoById(username);
		return mud;
	}

	public void signupUser(UserDTO user) {
		userInfoMapper.signupUser(user);		
	}
	
}
