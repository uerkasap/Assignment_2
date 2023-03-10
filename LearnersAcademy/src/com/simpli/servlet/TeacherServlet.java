package com.simpli.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simpli.database.GetData;
import com.simpli.database.postData;
import com.simpli.models.Teacher;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TeacherServlet() {
		super();
	}

	private GetData getData= new GetData();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Teacher> teachers = getData.getTeachers();
		
		request.setAttribute("teachers", teachers);
		
		RequestDispatcher rd = request.getRequestDispatcher("teachers.jsp");
		rd.forward(request, response);
	}
	
	private postData postData= new postData();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Teacher> teachers = postData.postTeachers();
		
		request.setAttribute("teachers", teachers);
		
		RequestDispatcher rd = request.getRequestDispatcher("teachers.jsp");
		rd.forward(request, response);
	}	

}
