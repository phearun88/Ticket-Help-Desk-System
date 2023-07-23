package com.example.demo.repository.dto;

public class UsersDto {
	
	private int id;
	private String user_code;
	private String username;
	private String password;
	private String authentication;
	
	public UsersDto() {
		// TODO Auto-generated constructor stub
	}

	public UsersDto(int id, String user_code, String username, String password, String authentication) {
		super();
		this.id = id;
		this.user_code = user_code;
		this.username = username;
		this.password = password;
		this.authentication = authentication;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		return "UsersDto [id=" + id + ", user_code=" + user_code + ", username=" + username + ", password=" + password
				+ ", authentication=" + authentication + "]";
	}
	

	
}
