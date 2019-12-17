package com.example.ayoteralab.main.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.ayoteralab.main.Entity.RealTimeAirList;
import com.example.ayoteralab.main.dto.StationMiseDTO;
import com.example.ayoteralab.main.dto.UserDTO;
import com.example.ayoteralab.main.mapper.UserMapper;
import com.google.gson.Gson;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	private String restUrl = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?sidoName=서울&pageNo=1&numOfRows=10&ServiceKey=JQO%2FnYOv49DPPMO2AuXUcstVFJy9eJiqB6MdtHYwh9nEx%2FlVcY67%2BzHq47vQbvn%2BWSM7xroxzQu44Pxn4N1T6Q%3D%3D&ver=1.3&_returnType=json";

	public ArrayList<UserDTO> selectUser() {
		return userMapper.selectUser();
	}
	
	public ArrayList<StationMiseDTO> selectStationMise() {
		return userMapper.selectStationMise();
	}
	
	public StationMiseDTO selectStationMiseById(String stationName) {
		return userMapper.selectStationMiseById(stationName);
	}
	
	public Integer insertStationMise(StationMiseDTO smDTO) {
		return userMapper.insertStationMise(smDTO);
	}
	
	public Integer updateStationMise(StationMiseDTO smDTO, String stationName) {
		return userMapper.updateStationMise(smDTO, stationName);
	}
	
	public Integer deleteStationMise(String stationName) {
		return userMapper.deleteStationMise(stationName);
	}
	
	public StationMiseDTO restCallById(String stationName) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		URI url = URI.create(restUrl);
		
		HttpEntity<String> request = new HttpEntity<>(httpHeaders);
		
		ResponseEntity<String> responseEntity = null;
		responseEntity = restTemplate.postForEntity(url, request, String.class);
		
		String res = responseEntity.getBody();
		
		Gson gson = new Gson();
		RealTimeAirList rtal = gson.fromJson(res, RealTimeAirList.class);
		
		System.out.println(rtal.getList().size());
		System.out.println(rtal.getList().get(3).toString());
		
		return null;
	}

	public void downExcel(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/msexcel");
		response.setHeader("Content-Disposition", "attachment; filename=\"TestDown.xlsx\"");
		
		try {
			InputStream io = new ClassPathResource("templates/download_template.xlsx").getInputStream();
			OutputStream os = response.getOutputStream();
			
//			ArrayList<UserDTO> dataList = selectUser();
			
			List<UserDTO> dataList = new ArrayList<>();
			
			UserDTO test1 = new UserDTO();
			test1.setSeq("1");
			test1.setName("AyoteraLab");
			test1.setLocation("SEOUL");
			test1.setPhone("900");
			
			dataList.add(test1);
			
			Context context = new Context();
			context.putVar("dataList", dataList);
			
			JxlsHelper.getInstance().processTemplate(io, os, context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
