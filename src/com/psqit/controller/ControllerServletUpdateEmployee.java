package com.psqit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psq.emsdao.Empdao;
import com.psqit.ems.emspojo.Emspojo;

@WebServlet("/ControllerServletUpdateEmployee")
// creating a class ControllerServletUpdateEmployee which is extending
// HttpServlet
public class ControllerServletUpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// calling the doPost method
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// getting id,name,salary from jsp page
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int salary = Integer.parseInt(request.getParameter("salary"));

			// creating the object of Pojo class(Emspojo)
			Emspojo ep = new Emspojo();

			// calling the setEmp_id,setEmp_name,setSalary Method of Pojo class(Emspojo)
			ep.setEmp_id(id);
			ep.setEmp_name(name);
			ep.setSalary(salary);

			// creating the object of dao Layer(Empdao)
			Empdao e = new Empdao();

			// calling updateEmployee method of Dao Layer(Empdao) and storing the returning
			// value in s
			String s = e.updateEmployee();

			// if the value in variable s is"Updated Successfully" then it will enter inside
			// the if block
			if (s.equals("Updated Successfully")) {
				// the following line of code will redirect us to UpdateEmployeeMessage.jsp page
				RequestDispatcher rd = request.getRequestDispatcher("UpdateEmployeeMessage.jsp");
				rd.include(request, response);
			}
			// if the value in variable s is not "Updated Successfully" then it will enter
			// inside the else block
			else {
				// the following line of code will redirect us to "EmployeeNotExist.jsp" page
				RequestDispatcher rd = request.getRequestDispatcher("EmployeeNotExist.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			// if the try block does not executed successfully then it will redirect us to
			// Error.jsp page
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.include(request, response);
		}
	}

}
