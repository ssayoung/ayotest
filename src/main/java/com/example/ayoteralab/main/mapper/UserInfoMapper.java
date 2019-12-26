package com.example.ayoteralab.main.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.example.ayoteralab.main.dto.MyUserDetails;
import com.example.ayoteralab.main.dto.UserDTO;

public interface UserInfoMapper {

	MyUserDetails getUserInfoById(@Param("username") String username);

	void signupUser(@Param("user") UserDTO user);

	ArrayList<String> getUserRoleByUserId(Integer userId);

}
