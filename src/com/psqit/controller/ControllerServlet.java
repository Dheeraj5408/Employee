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

@WebServlet("/ControllerServlet")
	
	//creating a class ControllerServlet which is extending HttpServlet 
	public class ControllerServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
    
   
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// calling the doPost method 
			doPost(request,response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			try {
				//getting the parameter from the jsp page using the getParameter Method
				String name=request.getParameter("Name");
				int salary=Integer.parseInt(request.getParameter("Salary"));
				
				//creating the object of Pojo class
				Emspojo ep=new Emspojo();
				
				//calling setEmp_name,setSalary Method Of Pojo class
				ep.setEmp_name(name);
				ep.setSalary(salary);
				
				//creating the object of Dao Layer
				Empdao ed=new Empdao();
				
				//calling the addEmployee method of Dao Layer
				ed.addEmployee();
				
				//calling the AddEmployeeMessage.jsp page using RequestDispatcher
				RequestDispatcher rd=request.getRequestDispatcher("AddEmployeeMessage.jsp");
				rd.include(request, response);
			}
			//if anything gone wrong it will enter inside the catch block
			catch(Exception e){
				//calling the Error.jsp page using RequestDispatcher
				RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
				rd.include(request, response);
				
			}
		}

}
