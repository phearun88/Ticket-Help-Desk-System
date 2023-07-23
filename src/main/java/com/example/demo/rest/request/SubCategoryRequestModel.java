package com.example.demo.rest.request;

public class SubCategoryRequestModel {
	
	private int sub_cate_id;
	private String sub_category_nm;
	private String sub_category_st;
	private int cate_id;
	private String user_id;
	private String created_date;
	private String updated_date;
	
	public SubCategoryRequestModel() {
		// TODO Auto-generated constructor stub
	}

	public SubCategoryRequestModel(int sub_cate_id, String sub_category_nm, String sub_category_st, int cate_id,
			String user_id, String created_date, String updated_date) {
		super();
		this.sub_cate_id = sub_cate_id;
		this.sub_category_nm = sub_category_nm;
		this.sub_category_st = sub_category_st;
		this.cate_id = cate_id;
		this.user_id = user_id;
		this.created_date = created_date;
		this.updated_date = updated_date;
	}

	public int getSub_cate_id() {
		return sub_cate_id;
	}

	public void setSub_cate_id(int sub_cate_id) {
		this.sub_cate_id = sub_cate_id;
	}

	public String getSub_category_nm() {
		return sub_category_nm;
	}

	public void setSub_category_nm(String sub_category_nm) {
		this.sub_category_nm = sub_category_nm;
	}

	public String getSub_category_st() {
		return sub_category_st;
	}

	public void setSub_category_st(String sub_category_st) {
		this.sub_category_st = sub_category_st;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
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
		return "SubCategoryRequestModel [sub_cate_id=" + sub_cate_id + ", sub_category_nm=" + sub_category_nm
				+ ", sub_category_st=" + sub_category_st + ", cate_id=" + cate_id + ", user_id=" + user_id
				+ ", created_date=" + created_date + ", updated_date=" + updated_date + "]";
	}

	
	
	

}
