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

@WebServlet("/ControllerServletDeleteEmployee")
// creating a class ControllerServletDeleteEmployee which is extending
// HttpServlet
public class ControllerServletDeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// calling the doPost method
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// getting id from the jsp page
			int id = Integer.parseInt(request.getParameter("id"));

			// creating the object of Pojo class(EmsPojo)
			Emspojo ep = new Emspojo();

			// calling the setEmp_id method of pojo class
			ep.setEmp_id(id);

			// creating the object of Dao Layer(EmpDao)
			Empdao dao = new Empdao();

			// calling the deleteEmployee method of Dao layer and storing the returning
			// value in s
			String s = dao.deleteEmployee();

			// if the returning value in s is "Employee deleted" then it will enter in if
			// block
			if (s.equals("Employee deleted")) {
				// getting request dispatcher and redirecting on the page
				// "DeleteEmployeeMessage.jsp"
				RequestDispatcher rd = request.getRequestDispatcher("DeleteEmployeeMessage.jsp");
				rd.include(request, response);
			} else {
				// if the returning value in s is not "Employee deleted" then it will enter in
				// else block
				RequestDispatcher rd = request.getRequestDispatcher("EmployeeNotExist.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			// if the try block does not executed successfully then we will redirect to
			// Error page "Error.jsp"
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.include(request, response);
		}
	}

}
