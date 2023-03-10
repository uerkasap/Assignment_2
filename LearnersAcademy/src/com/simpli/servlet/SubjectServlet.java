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
import com.simpli.models.Class;
import com.simpli.models.Student;
import com.simpli.models.Subject;

@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubjectServlet() {
		super();
	}

	private GetData getData= new GetData();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subject> subjects = getData.getSubjects();
		request.setAttribute("subjects", subjects);
		RequestDispatcher rd = request.getRequestDispatcher("subjects.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subject> subjects = postData.postSubjects();
		request.setAttribute("subjects", subjects);
		RequestDispatcher rd = request.getRequestDispatcher("subjects.jsp");
		rd.forward(request, response);
	}
}
