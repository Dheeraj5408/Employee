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

@WebServlet("/ControllerServletAddProject")

// creating a class ControllerServletAddProject which extending HttpServlet
public class ControllerServletAddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// calling the doPost method
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// getting projectname and id from jsp page
			String projectname = request.getParameter("projectname");
			int id = Integer.parseInt(request.getParameter("id"));

			// creating object of Pojo class
			Emspojo ep = new Emspojo();

			// calling setProjectName and setEmp_id method of Pojo class
			ep.setProjectName(projectname);
			ep.setEmp_id(id);

			// creating the object of Dao Layer(Empdao)
			Empdao ed = new Empdao();

			// calling add project method of Empdao and storing the returning value in
			// variable s
			String s = ed.addProject();

			// if the returned value is "Project Added" Then it will enter inside if block
			if (s.equals("Project Added")) {
				// getting request dispatcher and redirecting page to "AddProjectMessage.jsp"
				RequestDispatcher rd = request.getRequestDispatcher("AddProjectMessage.jsp");
				rd.include(request, response);
			} else {
				// getting request dispatcher and redirecting page to "EmployeeNotExist.jsp"
				RequestDispatcher rd = request.getRequestDispatcher("EmployeeNotExist.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			// if try block does not executed successfully then it will lead us to Error
			// page named "Error.jsp"
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.include(request, response);

		}
	}

}
