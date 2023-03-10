package com.simpli.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simpli.models.Class;
import com.simpli.models.Student;
import com.simpli.models.Subject;
import com.simpli.models.Teacher;

public class GetData {

	GetConnection connection = new GetConnection();

	public List<Class> getClasses() {

		String sql = "select * from classes";
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con= null;

		try {
			con= connection.getConnection();
			if(con!=null) {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				List<Class> list = new ArrayList<Class>();
				while(rs.next()) {
					Class cl = new Class();
					
					cl.setId(rs.getInt("id"));
					cl.setSection(rs.getString("section"));
					cl.setTime(rs.getString("time"));
					int subId=rs.getInt("subjectId");
					int teacherId=rs.getInt("teacherId");

					Teacher teacher = getClassTeacher(teacherId);
					Subject subject = getClassSubject(subId);

					cl.setSubjectName(subject.getName());
					cl.setTeacherName(teacher.getFname()+" "+teacher.getLname());

					list.add(cl);
				}			
				return list;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	private Subject getClassSubject(int subId) {

		String sql = "select * from subjects where id = "+subId;
		Subject subject=null;

		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con= null;

		try {
			con= connection.getConnection();
			if(con!=null) {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				while(rs.next()) {
					subject = new Subject();
					String name = rs.getString("name");
					subject.setName(name);
				}			
				return subject;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}



	private Teacher getClassTeacher(int teacherId) {
		String sql = "select * from teachers where id = "+teacherId;
		Teacher teacher=null;

		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con= null;

		try {
			con= connection.getConnection();
			if(con!=null) {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				while(rs.next()) {
					teacher = new Teacher();
					String fname = rs.getString("fname");
					String lname = rs.getString("lname");
					teacher.setFname(fname);
					teacher.setLname(lname);
				}			
				return teacher;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	public List<Student> getClassStudents(int classId) {
		String sql = "select * from students where classId = "+classId;
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con= null;		
		List<Student> list = new ArrayList<>();
		try {
			con= connection.getConnection();
			if(con!=null) {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {

					Student student = new Student();

					student.setFname(rs.getString("fName"));
					student.setLname(rs.getString("lName"));
					student.setAge(rs.getInt("age"));

					list.add(student);
				}			
				return list;
			}return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	public List<Subject> getSubjects() {
		String sql = "select * from subjects";
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con= null;		
		try {
			con= connection.getConnection();
			if(con!=null) {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				List<Subject> list = new ArrayList<>();
				while(rs.next()) {

					Subject subject = new Subject();
					subject.setName(rs.getString("name"));
					list.add(subject);
				}			
				return list;
			}return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Student> getStudents() {
		String sql = "select * from students";
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con= null;		
		try {
			con= connection.getConnection();
			if(con!=null) {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				List<Student> list = new ArrayList<>();
				while(rs.next()) {

					Student student = new Student();

					student.setFname(rs.getString("fName"));
					student.setLname(rs.getString("lName"));
					student.setAge(rs.getInt("age"));

					list.add(student);
				}			
				return list;
			}return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;	}


	public List<Teacher> getTeachers() {
		String sql = "select * from teachers";
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con= null;		
		try {
			con= connection.getConnection();
			if(con!=null) {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				List<Teacher> list = new ArrayList<>();
				while(rs.next()) {

					Teacher teacher = new Teacher();

					teacher.setAge(rs.getInt("age"));
					teacher.setFname(rs.getString("fName"));
					teacher.setLname(rs.getString("lName"));

					list.add(teacher);
				}			
				return list;
			}return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	}
	
	
