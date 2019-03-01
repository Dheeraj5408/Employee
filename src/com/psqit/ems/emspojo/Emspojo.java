package com.psqit.ems.emspojo;

//creating a Pojo class named Emspojo
public class Emspojo {

	// creating some variables for the class
	protected static int Emp_id;
	protected static String Emp_name;
	protected static int salary;
	protected static String projectname;
	protected static int projectid;

	// creating method setEmp_id
	public void setEmp_id(int id) {

		this.Emp_id = id;
	}

	// creating method getEmp_id
	public int getEmp_id() {

		return Emp_id;
	}

	// creating method setEmp_name
	public void setEmp_name(String name) {

		this.Emp_name = name;
	}

	// creating method getEmp_name
	public String getEmp_name() {

		return Emp_name;
	}

	// creating method setSalary
	public void setSalary(int salary) {

		this.salary = salary;
	}

	// creating method getSalary
	public int getSalary() {

		return salary;
	}

	// creating method setProjectName
	public void setProjectName(String projectname) {

		this.projectname = projectname;
	}

	// creating a method getProjectName
	public String getProjectName() {

		return projectname;
	}

	// creating method setProjectId
	public void setProjectId(int id) {

		this.projectid = id;
	}

	// creating method getProjectId
	public int getProjectId() {

		return projectid;
	}
}
