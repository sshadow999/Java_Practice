package com.app_web_project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app_web_project.model.DAOService;


@WebServlet("/addStudent")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOService service = new DAOService();
		service.ConnectDB();
		service.addStudent(name, email, mobile);
		
		//form blank page to student_registration.jsp
		request.setAttribute("msg","Student is now added..");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/student_registration.jsp");
		rd.forward(request, response);
	}

}
