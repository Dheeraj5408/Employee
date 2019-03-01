package com.psqit.ems.emspojo;

public class Emspojo {
	public Emspojo() {
		
	}
	protected static int Emp_id;
	protected static String Emp_name;
	protected static int salary;
	protected static String projectname;
	protected static int projectid;
	//	public emspojo(int id,String name) {
//		this.Emp_id=id;
//		this.Emp_name=name;
//	}
	public  void setEmp_id(int id ) {
		this.Emp_id=id;
	}
	
	public int getEmp_id() {
		return Emp_id;
	}
	
	public void setEmp_name(String name) {
		this.Emp_name=name;
	}
	
	public String getEmp_name() {
		return Emp_name;
	}
	
	public void setSalary(int salary) {
		this.salary=salary;
	}
	
	public int getSalary() {
		return salary;
	}

	public void setProjectName(String projectname) {
		this.projectname=projectname;
	}
	
	public String getProjectName() {
		return projectname;
	}
	
	public void setProjectId(int id) {
		this.projectid=id;
	}
	public int getProjectId(){
		return projectid;
	}
}
