package com.example.ayoteralab.main.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		//password encryption
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		String encryptPass = passEncoder.encode(user.getLoginPass());
		
		user.setLoginPassEncrypt(encryptPass);
		
		userInfoMapper.signupUser(user);		
	}
	
	public ArrayList<String> getUserRoleByUserId(Integer userId) {
		return userInfoMapper.getUserRoleByUserId(userId);
	}
	
}
