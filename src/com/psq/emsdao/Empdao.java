package com.psq.emsdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.servlet.RequestDispatcher;

import java.sql.*;

import com.psqit.ems.emspojo.Emspojo;

//creating a class Empdao which will work as Dao Layer
public class Empdao {

	// creating a method addEmployee
	public String addEmployee() {
		try {

			// System.out.println("Connect");
			// System.out.println("Empdao");

			// creating object of Pojo(emspojo) class
			Emspojo epojo = new Emspojo();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");
			// String query1="insert into employees(name) VALUES(?)";
			PreparedStatement pst = con.prepareStatement("insert into employees(name) VALUES(?)");
			// System.out.println("get value from pojo "+ epojo.getEmp_id() + " "+
			// epojo.getEmp_name() );

			// pst.setInt(1, epojo.getEmp_id());
			pst.setString(1, epojo.getEmp_name());
			pst.executeUpdate();

			String query1 = "set @last_id_in_employees=LAST_INSERT_ID()";
			PreparedStatement s = con.prepareStatement(query1);
			s.executeQuery();

			String query2 = "insert into salary(id,salary) VALUES(@last_id_in_employees,?)";
			PreparedStatement ps = con.prepareStatement(query2);
			ps.setInt(1, epojo.getSalary());
			ps.executeUpdate();

			con.close();
			return "Detail Added";
		} catch (Exception e) {
			System.out.println(e);
			return "Failure";
		}
	}// end of addEmployee method

	// creating method deleteEmployee
	public String deleteEmployee() {
		try {

			Emspojo epojo = new Emspojo();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");

			PreparedStatement p = con.prepareStatement("select * from employees where id=" + epojo.getEmp_id());
			ResultSet rs = p.executeQuery();
			int count = 0;
			while (rs.next()) {
				count++;
			}
			if (count != 0) {
				PreparedStatement pst = con.prepareStatement("delete from salary where id=" + epojo.getEmp_id());
				pst.execute();

				PreparedStatement pstmnt = con.prepareStatement("delete from projects where id=" + epojo.getEmp_id());
				pstmnt.executeUpdate();

				PreparedStatement st = con.prepareStatement("delete from employees where id=" + epojo.getEmp_id());
				st.executeUpdate();

				return "Employee deleted";
			} else {
				return "Something Went Wrong";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "Some Thing Went Wrong";
		}

	}// end of method deleteEmployee

	// creating method updateEmployee
	public String updateEmployee() {
		try {
			Emspojo ep = new Emspojo();
			System.out.println("hello");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");

			PreparedStatement p = con.prepareStatement("select * from employees where id=" + ep.getEmp_id());
			ResultSet rs = p.executeQuery();
			int count = 0;
			while (rs.next()) {
				count++;
			}
			// System.out.println(count);

			if (count != 0) {
				String query1 = "UPDATE employees SET name=? WHERE id=?";
				PreparedStatement st = con.prepareStatement(query1);
				st.setString(1, ep.getEmp_name());
				st.setInt(2, ep.getEmp_id());
				st.executeUpdate();

				String query2 = "Update salary SET salary=? WHERE id=?";
				PreparedStatement pst = con.prepareStatement(query2);
				pst.setInt(1, ep.getSalary());
				pst.setInt(2, ep.getEmp_id());
				pst.executeUpdate();
			} else {

				return "EmployeeNotExist";
			}
			return "Updated Successfully";
		} catch (Exception e) {
			System.out.println(e);
			return "Something Went Wrong";
		}

	}// end of updateEmployeemethod

	// creating method addProject
	public String addProject() {
		try {
			System.out.println("hello add project");
			Emspojo ep = new Emspojo();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");

			PreparedStatement ps = con.prepareStatement("select * from employees where id=" + ep.getEmp_id());
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				count++;
			}
			if (count != 0) {
				String query = "insert into projects(p_name,id) VALUES(?,?)";
				PreparedStatement ment = con.prepareStatement(query);
				ment.setString(1, ep.getProjectName());
				ment.setInt(2, ep.getEmp_id());
				ment.executeUpdate();
				return "Project Added";
			} else {
				return "EmployeeNotExist";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "SomeThing Went Wrong";
		}
	}// end of addProject method

	// creating method searchEmployee which will return a list of Emspojo type
	public List<Emspojo> searchEmployee(Emspojo p) {
		List<Emspojo> list = new ArrayList<Emspojo>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");
			String q1 = "select employees.id , employees.name , salary.salary from employees INNER JOIN salary ON employees.id = salary.id WHERE employees.id="
					+ p.getEmp_id();
			PreparedStatement pst = con.prepareStatement(q1);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				p.setEmp_id(rs.getInt("id"));
				p.setEmp_name(rs.getString("name"));
				p.setSalary(rs.getInt("salary"));
				list.add(p);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}// end of searchEmployee method

	// creating a method searchEmployeeProject which will return a list of Emspojo
	// type
	public List<Emspojo> searchEmployeeProject(Emspojo p) {
		List<Emspojo> list = new ArrayList<Emspojo>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");
			String q1 = "select * from projects where id=" + p.getEmp_id();
			PreparedStatement pst = con.prepareStatement(q1);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				p.setProjectId((rs.getInt("p_id")));
				p.setProjectName((rs.getString("p_name")));
				list.add(p);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}// end of searchEmployeProject

// end Of class