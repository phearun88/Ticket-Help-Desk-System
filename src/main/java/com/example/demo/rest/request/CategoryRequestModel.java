package com.example.demo.rest.request;

public class CategoryRequestModel {
	private int cate_id;
	private String category_nm;
	private String category_st;
	private String user_id;
	private String created_date;
	private String updated_date;
	
	public CategoryRequestModel() {
		// TODO Auto-generated constructor stub
	}

	public CategoryRequestModel(int cate_id, String category_nm, String category_st, String user_id,
			String created_date, String updated_date) {
		super();
		this.cate_id = cate_id;
		this.category_nm = category_nm;
		this.category_st = category_st;
		this.user_id = user_id;
		this.created_date = created_date;
		this.updated_date = updated_date;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public String getCategory_nm() {
		return category_nm;
	}

	public void setCategory_nm(String category_nm) {
		this.category_nm = category_nm;
	}

	public String getCategory_st() {
		return category_st;
	}

	public void setCategory_st(String category_st) {
		this.category_st = category_st;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
		return "CategoryRequestModel [cate_id=" + cate_id + ", category_nm=" + category_nm + ", category_st="
				+ category_st + ", user_id=" + user_id + ", created_date=" + created_date + ", updated_date="
				+ updated_date + "]";
	}

	
	
	
}
