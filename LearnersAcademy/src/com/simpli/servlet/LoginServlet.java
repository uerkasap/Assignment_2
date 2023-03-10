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
import com.simpli.models.Class;
import com.simpli.models.Student;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}
	
	private GetData getData= new GetData();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("user");
		String password=request.getParameter("pwd");

		if (username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {
			request.setAttribute("user", username);
			RequestDispatcher rd = request.getRequestDispatcher("navbar.jsp");
			rd.forward(request, response);

		}else {
			request.setAttribute("error", "Wrong Username or Password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
}
