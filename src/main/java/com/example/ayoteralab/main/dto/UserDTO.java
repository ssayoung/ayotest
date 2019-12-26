package com.example.ayoteralab.main.dto;

public class UserDTO {
	
	private String loginId;
	private String loginPass;
	private String fullName;
	private String email;
	private String loginPassEncrypt;

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getLoginPassEncrypt() {
		return loginPassEncrypt;
	}
	public void setLoginPassEncrypt(String loginPassEncrypt) {
		this.loginPassEncrypt = loginPassEncrypt;
	}

}
