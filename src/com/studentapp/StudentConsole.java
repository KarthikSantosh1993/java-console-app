package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class StudentConsole {

	public static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("*************************** Student Management System ***************************");
		studentList = new ArrayList<Student>();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student Name: ");
		String name= scanner.next();
		System.out.println("you have entered name as: "+name);
		
		System.out.println("Enter Student Age: ");
		int age= scanner.nextInt();
		System.out.println("you have entered age as: "+age);
		
		
		
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
		
		Comparator<Student> studentNameComparator = (o1,o2)-> o1.getName().compareTo(o2.getName());  
//		Comparator<Student> studentNameComparator = new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		};
		Collections.sort(studentList, studentNameComparator);
		System.out.println(studentList);
	}

}
