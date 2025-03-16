package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class StudentRunner {

	private static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("*************************** Student Management System ***************************");
		studentList = new ArrayList<Student>();

		scanner = new Scanner(System.in);

		while (true) {
			System.out.println("*************************** WELCOME ***************************");
			System.out.println("SELECT AN OPTION......... ");

			System.out.println("1. Register a Student");
			System.out.println("2. find student with studentId");
			System.out.println("3. List all student information");
			System.out.println("4. List student info in sorted order");
			System.out.println("5. EXIT");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				enrollStudent(scanner);
				break;

			case 2:
				findStudentById(scanner);
				break;
			case 3:
				printAllStudentData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;

			default:
				System.out.println("invalid option selected ..... Please enter between 1 and 5");
			}
		}
	}

	private static void exit() {
		System.out.println("Good bye!!!");
		System.exit(0);
	}

	private static void printAllStudentData() {
		if (studentList.size() > 0) {
			System.out.println("*************************** PRINT ALL STUDENT DATA ***************************");
			for (Student student : studentList) {
				student.printStudentInfo();
			}
			System.out.println("******************************************************************************");
		} else {
			System.err.println("Student List is empty!!!. No Student records found");
		}

	}

	private static void findStudentById(Scanner scanner) {
		Student studentFound = null;
		System.out.println("Enter the student Id: ");
		String studentId = scanner.next();

		try {
			studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
					.findFirst().orElseThrow(() -> new RuntimeException("No Data found!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID: " + studentId + " not found!!");
		}

		studentFound.printStudentInfo();
	}

	private static void enrollStudent(Scanner scanner) {

		System.out.println("Enter student Name: ");
		String studentName = scanner.next();

		System.out.println("Enter student Age: ");
		int studentAge = scanner.nextInt();

		System.out.println("Enter student Id: ");
		String studentId = scanner.next();

		Student newStudent = new Student(studentName, studentAge, studentId);
		studentList.add(newStudent);

		while (true) {
			System.out.println("Enter the course to be enrolled .... Type Done to exit ");
			String courseName = scanner.next();
			if (courseName.equalsIgnoreCase("Done")) {
				break;
			}
			newStudent.enrollCourse(courseName);

		}
		newStudent.printStudentInfo();

	}

	public static Student findStudentById(String studentId) {
		Student result = null;
		try {
			result = studentList.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data found!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID: " + studentId + " not found!!");
		}

		return result;

	}

	public static void sortByName() {

		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(studentList, studentNameComparator);
		printAllStudentData();
	}

}
