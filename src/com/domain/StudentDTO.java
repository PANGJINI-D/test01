package com.domain;

public class StudentDTO {
//	테이블명		tbl_student
//	컬럼		student_id(pk)	student_name	student_age
//			department_id(fk)	address_id(fk)
	
	// 필드
	private int studentId;
	private String studentName;
	private int studentAge;
	private int departmentId;
	private int addressId;
	
	// 기본생성자
	public StudentDTO() {
		super();
	}

	// setter, getter
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	
	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", departmentId=" + departmentId + ", addressId=" + addressId + "]";
	}
	
	
}
