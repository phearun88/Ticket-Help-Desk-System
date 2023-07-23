package com.example.demo.repository.dto;

public class ActivitiesLogDto {
	
	private int id;
	private String user_code;
	private String username;
	private String authentication;
	private String created_date;
	private String updated_date;
	
	
	public ActivitiesLogDto() {
		// TODO Auto-generated constructor stub
	}


	public ActivitiesLogDto(int id, String user_code, String username, String authentication, String created_date,
			String updated_date) {
		super();
		this.id = id;
		this.user_code = user_code;
		this.username = username;
		this.authentication = authentication;
		this.created_date = created_date;
		this.updated_date = updated_date;
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


	public String getAuthentication() {
		return authentication;
	}


	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}


	public String getCreated_date() {
		return created_date;
	}


	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}


	public String getUpdated_date() {
		return updated_date;
	}


	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}


	@Override
	public String toString() {
		return "ActivitiesLogDto [id=" + id + ", user_code=" + user_code + ", username=" + username
				+ ", authentication=" + authentication + ", created_date=" + created_date + ", updated_date="
				+ updated_date + "]";
	}
	
	

}
