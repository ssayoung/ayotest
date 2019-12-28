package com.example.ayoteralab.main.auth;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.ayoteralab.main.dto.MyUserDetails;
import com.example.ayoteralab.main.service.MyUserDetailsService;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String loginId = (String) authentication.getPrincipal();
		String loginPass = (String) authentication.getCredentials();
		
		System.out.println(loginId);
		System.out.println(loginPass);
		System.out.println(authentication);
		
		MyUserDetails mud = (MyUserDetails) myUserDetailsService.loadUserByUsername(loginId);
		
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();		
		Boolean matchPass = passEncoder.matches(loginPass, mud.getPassword());
		
		if(mud == null || !matchPass) return null;
		
		//권한 가져오는 로직
		ArrayList<String> userRole = myUserDetailsService.getUserRoleByUserId(mud.getUserId());
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
		for(String eachRole : userRole) {
			authorities.add(new SimpleGrantedAuthority(eachRole));
		}
		
		//(principal, credentials, authorities)
		return new UsernamePasswordAuthenticationToken(loginId, loginPass, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
}
