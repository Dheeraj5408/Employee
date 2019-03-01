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
// creating a class ControllerServletSearchEmployee which is extending
// HttpServlet
public class ControllerServletSearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// calling the doPost method
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// getting parameter from the jsp page
			int id = Integer.parseInt(request.getParameter("id"));

			// Creating the object of Pojo class(Emspojo)
			Emspojo ep = new Emspojo();

			// calling the setEmp_id method of Pojo class
			ep.setEmp_id(id);

			// creating the object of Dao Layer(Empdao)
			Empdao ed = new Empdao();

			// creating a list of type Emspojo
			List<Emspojo> list = new ArrayList<Emspojo>();

			// calling the searchEmmployee method of Empdao and storing the returning list
			// in the list
			list = ed.searchEmployee(ep);

			// if the size of list is not zero then it will enter inside if block
			if (list.size() != 0) {
				// copying the data of list to employeedata
				request.setAttribute("employeedata", list);

				// now it will redirect to "SearchEmployeeResult.jsp"
				RequestDispatcher rd = request.getRequestDispatcher("SearchEmployeeResult.jsp");
				rd.include(request, response);
			}
			// if the size of list is zero then it will enter in else block
			else {
				// it will redirect us to "EmployeeNotExist.jsp page"
				RequestDispatcher rd = request.getRequestDispatcher("EmployeeNotExist.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			// if try block does not executed successfully then thjis block will lead us to
			// the page "Error.jsp"
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.include(request, response);
		}
	}

}
