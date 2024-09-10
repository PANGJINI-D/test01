package com.domain;

public class DepartmentDTO {
//	테이블명		tbl_department
//	컬럼		department_id(pk)	department_name(unique)
	
	// 필드
	private int departmentId;
	private String departmentName;
	
	// 생성자
	public DepartmentDTO() {
		super();
	}

	// setter, getter
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	
	
}
