package com.example.demo.repository.dto;

public class IssuesDto {
	private int iss_id;
	private String iss_nm;
	private int iss_cate_id;
	private int iss_subcate_id;
	private String iss_desc;
	private String iss_status;
	private String iss_priority;
	private String iss_assignee;
	private String user_code;
	private String iss_done;
	private String started_date;
	private String due_date;
	private String iss_yn;
	private String created_date;
	private String updated_date;
	private CategoryDto categoryDto;
	private SubCategoryDto subCategoryDto;
	private UsersDetailDto usersDetailDto;
	

   public IssuesDto() {
	// TODO Auto-generated constructor stub
   }


	public IssuesDto(int iss_id, String iss_nm, int iss_cate_id, int iss_subcate_id, String iss_desc, String iss_status,
		String iss_priority, String iss_assignee, String user_code, String iss_done, String started_date,
		String due_date, String iss_yn, String created_date, String updated_date, CategoryDto categoryDto, SubCategoryDto subCategoryDto, UsersDetailDto usersDetailDto) {
		super();
		this.iss_id = iss_id;
		this.iss_nm = iss_nm;
		this.iss_cate_id = iss_cate_id;
		this.iss_subcate_id = iss_subcate_id;
		this.iss_desc = iss_desc;
		this.iss_status = iss_status;
		this.iss_priority = iss_priority;
		this.iss_assignee = iss_assignee;
		this.user_code = user_code;
		this.iss_done = iss_done;
		this.started_date = started_date;
		this.due_date = due_date;
		this.iss_yn = iss_yn;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.categoryDto = categoryDto;
		this.subCategoryDto = subCategoryDto;
		this.usersDetailDto = usersDetailDto;
	}


	public CategoryDto getCategoryDto() {
		return categoryDto;
	}


	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}
	

	public SubCategoryDto getSubCategoryDto() {
		return subCategoryDto;
	}


	public void setSubCategoryDto(SubCategoryDto subCategoryDto) {
		this.subCategoryDto = subCategoryDto;
	}


	public UsersDetailDto getUsersDetailDto() {
		return usersDetailDto;
	}


	public void setUsersDetailDto(UsersDetailDto usersDetailDto) {
		this.usersDetailDto = usersDetailDto;
	}


	public int getIss_id() {
		return iss_id;
	}
	
	
	public void setIss_id(int iss_id) {
		this.iss_id = iss_id;
	}
	
	
	public String getIss_nm() {
		return iss_nm;
	}
	
	
	public void setIss_nm(String iss_nm) {
		this.iss_nm = iss_nm;
	}
	
	
	public int getIss_cate_id() {
		return iss_cate_id;
	}
	
	
	public void setIss_cate_id(int iss_cate_id) {
		this.iss_cate_id = iss_cate_id;
	}
	
	
	public int getIss_subcate_id() {
		return iss_subcate_id;
	}
	
	
	public void setIss_subcate_id(int iss_subcate_id) {
		this.iss_subcate_id = iss_subcate_id;
	}
	
	
	public String getIss_desc() {
		return iss_desc;
	}
	
	
	public void setIss_desc(String iss_desc) {
		this.iss_desc = iss_desc;
	}
	
	
	public String getIss_status() {
		return iss_status;
	}
	
	
	public void setIss_status(String iss_status) {
		this.iss_status = iss_status;
	}
	
	
	public String getIss_priority() {
		return iss_priority;
	}
	
	
	public void setIss_priority(String iss_priority) {
		this.iss_priority = iss_priority;
	}
	
	
	public String getIss_assignee() {
		return iss_assignee;
	}
	
	
	public void setIss_assignee(String iss_assignee) {
		this.iss_assignee = iss_assignee;
	}
	
	
	public String getUser_code() {
		return user_code;
	}
	
	
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	
	
	public String getIss_done() {
		return iss_done;
	}
	
	
	public void setIss_done(String iss_done) {
		this.iss_done = iss_done;
	}
	
	
	public String getStarted_date() {
		return started_date;
	}
	
	
	public void setStarted_date(String started_date) {
		this.started_date = started_date;
	}
	
	
	public String getDue_date() {
		return due_date;
	}
	
	
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	
	
	public String getIss_yn() {
		return iss_yn;
	}


	public void setIss_yn(String iss_yn) {
		this.iss_yn = iss_yn;
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
		return "IssuesDto [iss_id=" + iss_id + ", iss_nm=" + iss_nm + ", iss_cate_id=" + iss_cate_id
				+ ", iss_subcate_id=" + iss_subcate_id + ", iss_desc=" + iss_desc + ", iss_status=" + iss_status
				+ ", iss_priority=" + iss_priority + ", iss_assignee=" + iss_assignee + ", user_code=" + user_code
				+ ", iss_done=" + iss_done + ", started_date=" + started_date + ", due_date=" + due_date + ", iss_yn="
				+ iss_yn + ", created_date=" + created_date + ", updated_date=" + updated_date + ", categoryDto="
				+ categoryDto + ", subCategoryDto=" + subCategoryDto + ", usersDetailDto=" + usersDetailDto + "]";
	}


	


	

	

	   
   
}
