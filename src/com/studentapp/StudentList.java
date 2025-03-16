package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class StudentList {

	public static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("*************************** Student Management System ***************************");
		

		Student s1 = new Student("Karthik", 20, "S-01");
		s1.enrollCourse("Testing");

		Student s2 = new Student("Anjum", 22, "S-02");
		s2.enrollCourse("Java");

		Student s3 = new Student("zebra", 29, "S-03");
		s3.enrollCourse("Devops");

		Student s4 = new Student("satya", 35, "S-04");
		s4.enrollCourse("Testing");

		studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);

		System.out.println("*************************** Student with ID ***************************");
		System.out.println("     " + findStudentById("S-03"));
		System.out.println("***********************************************************************");
		System.out.println();
		System.out.println("*************************** Sorted Student List ***************************");
		sortByName();
		System.out.println("***************************************************************************");
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
		
		Comparator<Student> studentNameComparator = (o1,o2)-> o1.getName().compareTo(o2.getName());   //comparision happens lexographically 
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
