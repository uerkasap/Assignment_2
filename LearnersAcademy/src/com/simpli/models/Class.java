package com.simpli.models;

public class Class {

	private static int id;
	private static String section;
	private static String time;
	private static String teacherName;
	private static String subjectName;

	public static int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public static String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public static String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public static String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
}