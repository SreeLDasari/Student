package com.testannotation.studentservice.model;

public class Student {
    private String rollNo;
    private String name;
    private String branch;
    private String college;

    public Student(String rollNo, String name,String branch,String college) {
		this.rollNo = rollNo;
		this.name = name;
		this.branch = branch;
		this.college = college;
	}

	
	public String getRollNo() {
		return rollNo;
	}


	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getCollege() {
		return college;
	}


	public void setCollege(String college) {
		this.college = college;
	}


	public Student(){

    }


}
