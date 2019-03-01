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

@WebServlet("/ControllerServletSearchEmployeeProject")
//creating a class ControllerServletSearchEmployeeProject which is extending HttpServlet
public class ControllerServletSearchEmployeeProject extends HttpServlet {
		private static final long serialVersionUID = 1L;
        
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//calling doPost Method
			doPost(request,response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try {
				//getting value from jsp page using getParameter Method
				int id=Integer.parseInt(request.getParameter("id"));
				
				//creating object of Pojo class
				Emspojo ep=new Emspojo();
				
				//calling setEmp_id method of Pojo class And and setting the id
				ep.setEmp_id(id);
				
				//creating object of Dao Layer
				Empdao ed=new Empdao();
				
				//creating a new arraylist of Pojo class type
				List<Emspojo> employeeprojectlist=new ArrayList<Emspojo>();
				
				//calling the searchEmployeeProject Method Of Dao Layer and getting the returning list into employeeprojectlist
				employeeprojectlist=ed.searchEmployeeProject(ep);
				
				//if size of employeeprojectlist is not zero then it will enter inside if block
				if(employeeprojectlist.size()!=0) {
					request.setAttribute("employeeprojectdata", employeeprojectlist);
					
					//calling the page SearchEmployeeProjectResult.jsp using RequestDispatcher
					RequestDispatcher rd=request.getRequestDispatcher("SearchEmployeeProjectResult.jsp");
					rd.include(request, response);
				}
				//if size of employeeprojectlist is zero then it will enter inside else block
				else {
					//calling the page EmployeeNotExist.jsp using RequestDispatcher
					RequestDispatcher rd=request.getRequestDispatcher("EmployeeNotExist.jsp");
					rd.include(request, response);	
				}
			}
			catch(Exception e) {
				//If anything gone wrong our web application redirect on to the error.jsp page
				RequestDispatcher rd =request.getRequestDispatcher("Error.jsp");
				rd.include(request, response);
			}
	}

}
