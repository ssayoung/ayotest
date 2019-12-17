package com.example.ayoteralab.main.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ayoteralab.main.dto.StationMiseDTO;
import com.example.ayoteralab.main.dto.UserDTO;

@Mapper
public interface UserMapper {

	ArrayList<UserDTO> selectUser();

	ArrayList<StationMiseDTO> selectStationMise();

	StationMiseDTO selectStationMiseById(String stationName);

	Integer insertStationMise(@Param("mydto") StationMiseDTO smDTO);

	Integer updateStationMise(@Param("mydto") StationMiseDTO smDTO, String stationName);

	Integer deleteStationMise(String stationName);

}
