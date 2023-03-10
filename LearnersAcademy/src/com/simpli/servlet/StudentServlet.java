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
import com.simpli.models.Student;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentServlet() {
		super();
	}

	private GetData getData= new GetData();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> student = getData.getStudents();
		
		request.setAttribute("students", student);
		
		RequestDispatcher rd = request.getRequestDispatcher("students.jsp");
		rd.forward(request, response);
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Student> student = postData.postStudents();
			
			request.setAttribute("students", student);
			
			RequestDispatcher rd = request.getRequestDispatcher("students.jsp");
			rd.forward(request, response);
	}
}
