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
import com.simpli.models.Teacher;

@WebServlet("/ClassServlet")
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClassServlet() {
		super();
	}

	private GetData getData= new GetData();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String view = request.getParameter("getClassStudents");

		if(view==null) {
			List<Class> classes = getData.getClasses();
			request.setAttribute("classes", classes);

			RequestDispatcher rd = request.getRequestDispatcher("classes.jsp");
			rd.forward(request, response);
		}		
		else {
			int classId=Integer.parseInt(request.getParameter("classId"));
			String section=request.getParameter("section");

			List<Student> students = getData.getClassStudents(classId);

			request.setAttribute("students", students);
			request.setAttribute("section", section);

			RequestDispatcher rd = request.getRequestDispatcher("classStudents.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String view = request.getParameter("getClassStudents");

		if(view==null) {
			List<Class> classes = postData.postClasses();
			request.setAttribute("classes", classes);

			RequestDispatcher rd = request.getRequestDispatcher("classes.jsp");
			rd.forward(request, response);
		}		
		else {
			int classId=Integer.parseInt(request.getParameter("classId"));
			String section=request.getParameter("section");

			List<Student> students = postData.postClassStudents(classId);

			request.setAttribute("students", students);
			request.setAttribute("section", section);

			RequestDispatcher rd = request.getRequestDispatcher("classStudents.jsp");
			rd.forward(request, response);
		}
	}

}
