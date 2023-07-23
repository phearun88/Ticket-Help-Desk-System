package com.example.demo.rest.request;

public class UsersDetailRequestModel {

	private int id;
	private String user_code;
	private String user_nm_kh;
	private String user_nm_en;
	private String user_gender;
	private String user_dob;
	private String user_id_cd;
	private String user_position;
	private String dept_nm;
	private String usr_old_add;
	private String usr_new_add;
	private String usr_tel;
	private String usr_email;
	private String created_date;
	private String updated_date;
	
	public UsersDetailRequestModel() {
		// TODO Auto-generated constructor stub
	}

	public UsersDetailRequestModel(int id, String user_code, String user_nm_kh, String user_nm_en, String user_gender,
			String user_dob, String user_id_cd, String user_position, String dept_nm, String usr_old_add,
			String usr_new_add, String usr_tel, String usr_email, String created_date, String updated_date) {
		super();
		this.id = id;
		this.user_code = user_code;
		this.user_nm_kh = user_nm_kh;
		this.user_nm_en = user_nm_en;
		this.user_gender = user_gender;
		this.user_dob = user_dob;
		this.user_id_cd = user_id_cd;
		this.user_position = user_position;
		this.dept_nm = dept_nm;
		this.usr_old_add = usr_old_add;
		this.usr_new_add = usr_new_add;
		this.usr_tel = usr_tel;
		this.usr_email = usr_email;
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

	public String getUser_nm_kh() {
		return user_nm_kh;
	}

	public void setUser_nm_kh(String user_nm_kh) {
		this.user_nm_kh = user_nm_kh;
	}

	public String getUser_nm_en() {
		return user_nm_en;
	}

	public void setUser_nm_en(String user_nm_en) {
		this.user_nm_en = user_nm_en;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_dob() {
		return user_dob;
	}

	public void setUser_dob(String user_dob) {
		this.user_dob = user_dob;
	}

	public String getUser_id_cd() {
		return user_id_cd;
	}

	public void setUser_id_cd(String user_id_cd) {
		this.user_id_cd = user_id_cd;
	}

	public String getUser_position() {
		return user_position;
	}

	public void setUser_position(String user_position) {
		this.user_position = user_position;
	}

	public String getDept_nm() {
		return dept_nm;
	}

	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}

	public String getUsr_old_add() {
		return usr_old_add;
	}

	public void setUsr_old_add(String usr_old_add) {
		this.usr_old_add = usr_old_add;
	}

	public String getUsr_new_add() {
		return usr_new_add;
	}

	public void setUsr_new_add(String usr_new_add) {
		this.usr_new_add = usr_new_add;
	}

	public String getUsr_tel() {
		return usr_tel;
	}

	public void setUsr_tel(String usr_tel) {
		this.usr_tel = usr_tel;
	}

	public String getUsr_email() {
		return usr_email;
	}

	public void setUsr_email(String usr_email) {
		this.usr_email = usr_email;
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
		return "UsersDetailRequestModel [id=" + id + ", user_code=" + user_code + ", user_nm_kh=" + user_nm_kh
				+ ", user_nm_en=" + user_nm_en + ", user_gender=" + user_gender + ", user_dob=" + user_dob
				+ ", user_id_cd=" + user_id_cd + ", user_position=" + user_position + ", dept_nm=" + dept_nm
				+ ", usr_old_add=" + usr_old_add + ", usr_new_add=" + usr_new_add + ", usr_tel=" + usr_tel
				+ ", usr_email=" + usr_email + ", created_date=" + created_date + ", updated_date=" + updated_date
				+ "]";
	}
	
}
