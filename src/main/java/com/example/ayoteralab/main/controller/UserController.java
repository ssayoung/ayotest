package com.example.ayoteralab.main.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ayoteralab.main.dto.StationMiseDTO;
import com.example.ayoteralab.main.dto.UserDTO;
import com.example.ayoteralab.main.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/test")
@Api(value = "/test", description = "About user", consumes = "application/json")
public class UserController {
	
	final Logger L = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@ApiOperation(httpMethod = "GET"
			,value = "전체 stationMise 리스트 조회"
			,notes = "Select all stationMist List"
			,response = UserDTO.class
			,responseContainer = "ArrayList")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<UserDTO>> selectUser(){
		L.info("Select Start");
		return ResponseEntity.ok(userService.selectUser());
	}
	
	@ApiOperation(httpMethod = "GET"
			,value = "전체 Station Mise 리스트 조회"
			,notes = "Select All Station Mise List"
			,response = UserDTO.class
			,responseContainer = "ArrayList")
	@RequestMapping(value = "/stationMise", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<StationMiseDTO>> selectStationMise(){
		L.info("Select Station Mise Start");
		return ResponseEntity.ok(userService.selectStationMise());
	}
	
	@ApiOperation(httpMethod = "GET"
			,value = "선택 Station Mise 리스트 조회"
			,notes = "Select Station Mise List by stationName"
			,response = UserDTO.class
			,responseContainer = "ArrayList")
	@RequestMapping(value = "/stationMise/{stationName}", method = RequestMethod.GET)
	public ResponseEntity<StationMiseDTO> selectStationMiseById(
			@ApiParam(value = "stationName", required = true) @PathVariable("stationName") String stationName){
		L.info("Select Station Mise by stationName Start");
		return ResponseEntity.ok(userService.selectStationMiseById(stationName));
	}
	
	@ApiOperation(httpMethod = "POST"
			,value = "Station Mise 항목 추가"
			,notes = "Insert Station Mise"
			,response = UserDTO.class
			,responseContainer = "Integer")
	@RequestMapping(value = "/stationMise", method = RequestMethod.POST)
	public ResponseEntity<?> insertStationMise(
			@ApiParam(value = "StationMiseDTO", required = true) @RequestBody StationMiseDTO smDTO){
		L.info("Insert Station Mise");		
		return ResponseEntity.ok(userService.insertStationMise(smDTO));
	}
	
	@ApiOperation(httpMethod = "PUT"
			,value = "Station Mise 항목 변경"
			,notes = "Update Station Mise"
			,response = UserDTO.class
			,responseContainer = "Integer")
	@RequestMapping(value = "/stationMise/{stationName}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStationMise(
			@ApiParam(value = "StationMiseDTO", required = true) @RequestBody StationMiseDTO smDTO,
			@ApiParam(value = "stationName", required = true) @PathVariable("stationName") String stationName){
		L.info("Update Station Mise");		
		return ResponseEntity.ok(userService.updateStationMise(smDTO, stationName));
	}
	
	@ApiOperation(httpMethod = "DELETE"
			,value = "Station Mise 항목 변경"
			,notes = "Update Station Mise"
			,response = UserDTO.class
			,responseContainer = "Integer")
	@RequestMapping(value = "/stationMise/{stationName}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteStationMise(
			@ApiParam(value = "stationName", required = true) @PathVariable("stationName") String stationName){
		L.info("Update Station Mise");		
		return ResponseEntity.ok(userService.deleteStationMise(stationName));
	}
	
	@ApiOperation(httpMethod = "GET"
			,value = "Station Mise 항목 REST call"
			,notes = "REST call Station Mise"
			,response = UserDTO.class
			,responseContainer = "null")
	@RequestMapping(value = "/stationMiseRest/{stationName}", method = RequestMethod.GET)
	public ResponseEntity<?> restCallById(
			@ApiParam(value = "stationName", required = true) @PathVariable("stationName") String stationName){
		L.info("REST call Station Mise");		
		return ResponseEntity.ok(userService.restCallById(stationName));
	}	
	
	@ApiOperation(httpMethod = "GET"
			,value = "Excel Download"
			,notes = "Excel Download User List")
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<?> downExcel(HttpServletRequest request, HttpServletResponse response){
		
		L.info("Download Start");
		
		userService.downExcel(request, response);		
		return ResponseEntity.ok().build();
	}

}
