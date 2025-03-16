package com.studentapp;

public class Main {

	public static void main(String[] args) {
		System.out.println("*************************** Student Management System ***************************");
		System.out.println("************************************ Welcome ************************************");
		
		Student s1= new Student("Karthik", 25, "S-01");
		s1.enrollCourse("Java");
		s1.enrollCourse("Devops");
		s1.enrollCourse("Testing");
		System.out.println(s1); 
//		s1.printStudentInfo();
//		s1.enrollCourse("C#");
//		
//		System.out.println(s2); 
//		System.out.println(s3);

		
		Student s2= new Student("Satya", 22, "S-02");
		s2.enrollCourse("Java");
		//s2.printStudentInfo();
		System.out.println(s2); 
		
		Student s3= new Student("Santosh", 29, "S-03");
		s3.enrollCourse("Devops");
		//s3.printStudentInfo();
		System.out.println(s3);
	}

}
 