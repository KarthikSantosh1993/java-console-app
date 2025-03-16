package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();

		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>();
		}

	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student is successfully enrolled to course name:" + course);
			} else {
				System.err.println("Student already enrolled to the course: " + course);
			}
		}

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void printStudentInfo() {
		System.out.println("============ Student Information ============");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Student Id: " + studentId);
		System.out.println("Enrolled course: " + courses);
		System.out.println("=============================================");

	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]"
				+ "\n" + "==============================================================================================="
				+ "\n";
	}

	// validation methods
	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid age: " + age + " !! Student age needs to be between 19 and 35");
			return false;
		}

	}

	public boolean validateName(String name) {

		String nameRegEx = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegEx);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name: " + name + " !! Please enter Alphabents and spaces only as name");
			return false;
		}

	}

	public boolean validateStudentId(String studentId) {
		String idRegEx = "^S-[0-9]+$"; // ^S-\\d+$
		Pattern idPattern = Pattern.compile(idRegEx);
		Matcher idMatcher = idPattern.matcher(studentId);
		if (idMatcher.matches()) {
			return true;
		} else {
			System.err.println("invalid Student id: " + studentId + " !! use format as S-1234");
			return false;
		}

	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("Testing")
				|| course.equalsIgnoreCase("Devops")) {
			return true;

		} else {
			System.err.println("invalid course name: " + course
					+ " !! please use courses from this list [Java, Selenium, Playwright");
			return false;
		}

	}

}
