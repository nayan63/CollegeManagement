package com.mindtree.college.VO;

import java.util.List;

import com.mindtree.college.entity.College;

public class ResponseTemplate {

	private College college;
	private List<Student> studentList;
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public ResponseTemplate(College college, List<Student> studentList) {
		super();
		this.college = college;
		this.studentList = studentList;
	}
	public ResponseTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
