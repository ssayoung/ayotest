package com.example.ayoteralab.main.dto;

public class StationMiseDTO {
	
	private String stationName;
	private String no2Value;
	private String o3Value;
	private String pm10Value;
	private String pm25Value;
	private String dateTime;
	
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getNo2Value() {
		return no2Value;
	}
	public void setNo2Value(String no2Value) {
		this.no2Value = no2Value;
	}
	public String getO3Value() {
		return o3Value;
	}
	public void setO3Value(String o3Value) {
		this.o3Value = o3Value;
	}
	public String getPm10Value() {
		return pm10Value;
	}
	public void setPm10Value(String pm10Value) {
		this.pm10Value = pm10Value;
	}
	public String getPm25Value() {
		return pm25Value;
	}
	public void setPm25Value(String pm25Value) {
		this.pm25Value = pm25Value;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	@Override
	public String toString() {
		return "StationMiseDTO [stationName=" + stationName + ", no2Value=" + no2Value + ", o3Value=" + o3Value
				+ ", pm10Value=" + pm10Value + ", pm25Value=" + pm25Value + ", dateTime=" + dateTime + "]";
	}

}