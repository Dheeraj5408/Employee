package com.psqit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psq.emsdao.Empdao;
import com.psqit.ems.emspojo.Emspojo;

@WebServlet("/ControllerServletSearchEmployee")
public class ControllerServletSearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
	int id=Integer.parseInt(request.getParameter("id"));
	Emspojo ep=new Emspojo();
	ep.setEmp_id(id);
	
	Empdao ed=new Empdao();
	List<Emspojo> list=new ArrayList<Emspojo>();
	list=ed.searchEmployee(ep);
	if(list.size()!=0) {
	request.setAttribute("employeedata", list);
	RequestDispatcher rd=request.getRequestDispatcher("SearchEmployeeResult.jsp");
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
