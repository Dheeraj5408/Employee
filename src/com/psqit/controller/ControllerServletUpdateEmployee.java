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

/**
 * Servlet implementation class ControllerServletUpdateEmployee
 */
@WebServlet("/ControllerServletUpdateEmployee")
public class ControllerServletUpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		doPost(request,response);
    	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			int salary=Integer.parseInt(request.getParameter("salary"));
	
			Emspojo ep=new Emspojo();
			ep.setEmp_id(id);
			ep.setEmp_name(name);
			ep.setSalary(salary);
	
			Empdao e=new Empdao();
	
	
			String s=	e.updateEmployee();
		
			if(s.equals("Updated Successfully")) {
			RequestDispatcher rd=request.getRequestDispatcher("UpdateEmployeeMessage.jsp");
			rd.include(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("EmployeeNotExist.jsp");
				rd.include(request, response);
			}
			}
		catch(Exception e) {
			RequestDispatcher rd =request.getRequestDispatcher("Error.jsp");
			rd.include(request, response);
	}
	}

}
