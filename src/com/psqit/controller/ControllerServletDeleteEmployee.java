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
 * Servlet implementation class ControllerServletDeleteEmployee
 */
@WebServlet("/ControllerServletDeleteEmployee")
public class ControllerServletDeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerServletDeleteEmployee() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int id=Integer.parseInt(request.getParameter("id"));
		Emspojo ep=new Emspojo();
		ep.setEmp_id(id);
		Empdao dao = new Empdao();
		String s=dao.deleteEmployee();
		
		if(s.equals("Employee deleted")) {
		RequestDispatcher rd=request.getRequestDispatcher("DeleteEmployeeMessage.jsp");
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
