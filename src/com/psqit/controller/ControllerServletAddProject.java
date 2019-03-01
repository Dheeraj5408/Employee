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

	//creating a class ControllerServletAddProject which extending HttpServlet
	public class ControllerServletAddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	System.out.println("hello servlet");
		
		String projectname=request.getParameter("projectname");
		int id=Integer.parseInt(request.getParameter("id"));
	
		Emspojo ep=new Emspojo();
		ep.setProjectName(projectname);
		ep.setEmp_id(id); 
	
		Empdao ed=new Empdao();
		String s=ed.addProject();
		if(s.equals("Project Added")) {
		RequestDispatcher rd =request.getRequestDispatcher("AddProjectMessage.jsp");
		rd.include(request, response);
		}
		else {
			RequestDispatcher rd =request.getRequestDispatcher("EmployeeNotExist.jsp");
			rd.include(request, response);	
		}
		}
		catch(Exception e) {
			RequestDispatcher rd =request.getRequestDispatcher("Error.jsp");
			rd.include(request, response);
				
		}
		}

}
