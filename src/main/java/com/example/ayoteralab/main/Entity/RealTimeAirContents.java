package com.example.ayoteralab.main.Entity;

public class RealTimeAirContents {

	private String dataTime;
	private String khaiGrade;
	private String khaiValue;
	private String mangName;
	private String no2Grade;
	private String no2Value;
	
	public String getDataTime() {
		return dataTime;
	}
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	public String getKhaiGrade() {
		return khaiGrade;
	}
	public void setKhaiGrade(String khaiGrade) {
		this.khaiGrade = khaiGrade;
	}
	public String getKhaiValue() {
		return khaiValue;
	}
	public void setKhaiValue(String khaiValue) {
		this.khaiValue = khaiValue;
	}
	public String getMangName() {
		return mangName;
	}
	public void setMangName(String mangName) {
		this.mangName = mangName;
	}
	public String getNo2Grade() {
		return no2Grade;
	}
	public void setNo2Grade(String no2Grade) {
		this.no2Grade = no2Grade;
	}
	public String getNo2Value() {
		return no2Value;
	}
	public void setNo2Value(String no2Value) {
		this.no2Value = no2Value;
	}
	
	@Override
	public String toString() {
		return "RealTimeAirContents [dataTime=" + dataTime + ", khaiGrade=" + khaiGrade + ", khaiValue=" + khaiValue
				+ ", mangName=" + mangName + ", no2Grade=" + no2Grade + ", no2Value=" + no2Value + "]";
	}
	
}