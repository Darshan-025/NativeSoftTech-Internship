package javaProjects;

import java.util.HashMap;
import java.util.Scanner;

class Student{
	String name;
	int age;
	String grade;
	
	public Student(String name,int age,String grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Name: "+name+ ", Age :"+age+", Grade :"+grade;
	}	
}

public class StudentManagementSystem {
	private static HashMap<Integer, Student> studentRecords = new HashMap<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			 	System.out.println("\nStudent Management System");
			 	System.out.println("1. Add Student");
			 	System.out.println("2. Update Student");
			 	System.out.println("3. Remove Student");
			 	System.out.println("4. View Student details");
			 	System.out.println("5. Exit");
			 	System.out.println("Choose an option :");
			 	
			 	if(!sc.hasNextInt()) {
			 		System.out.println("Invalid input. Please enter a number");
			 		sc.nextLine();
			 		continue;
			 	}
			 	
			 	int choice = sc.nextInt();
			 	sc.nextLine();
			 	
			 	switch(choice) {
			 	case 1:
			 		 addStudent();
			 		 break;
			 	case 2:
			 		updateStudent();
			 		break;
			 	case 3:
			 		removeStudent();
			 		break;
			 	case 4:
			 		viewStudent();
			 		break;
			 	case 5:
			 		System.out.println("Exiting system.");
			 		System.out.println("Thank you for using our service..");
			 		return;
			 	default:
			 		System.out.println("Invalid option. Please try again");
			 	}
			}

		}
	
	private static void addStudent() {
		System.out.println("Enter student ID: ");
		if(! sc.hasNextInt()) {
			System.out.println("Invalid input.ID must be a number");
			sc.nextLine();
			return;
		}
		int id = sc.nextInt();
		sc.nextLine();
		
		if(studentRecords.containsKey(id)) {
			System.out.println("Student with ID "+id+" already exists.");
			return;
		}
		
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Age: ");
		if(!sc.hasNextInt()) {
			System.out.println("Invalid input.Age must be a number");
			sc.nextLine();
			return;
		}
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Grade: ");
		String grade = sc.nextLine();
		
		Student student = new Student(name,age,grade);
		studentRecords.put(id,student);
		System.out.println("Student added successfully");
	}
	
	private static void updateStudent() {
		System.out.println("Enter student ID to update: ");
		if(!sc.hasNextInt()) {
			System.out.println("Invalid input.ID must be a number");
			sc.nextLine();
			return;
		}
		int id = sc.nextInt();
		sc.nextLine();
		
		if(!studentRecords.containsKey(id)) {
			System.out.println("Student with ID "+id+" does not exist.");
			return;
		}
		
		Student student = studentRecords.get(id);
		System.out.println("Enter new Name (current: "+student.getName()+"): ");
		String name = sc.nextLine();
		System.out.println("Enter new Age (current: "+student.getAge()+"): ");
		if(!sc.hasNextInt()) {
			System.out.println("Invalid input.Age must be a number");
			sc.nextLine();
			return;
		}
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter new Grade (current: "+student.getGrade()+"): ");
		String grade = sc.nextLine();
		
		student.setName(name);
		student.setAge(age);
		student.setGrade(grade);
		System.out.println("Student updated successfully");
	}
	
	private static void removeStudent() {
		System.out.println("Enter student ID to remove: ");
		if(!sc.hasNextInt()) {
			System.out.println("Invalid input.ID must be a number");
			sc.nextLine();
			return;
		}
		int id = sc.nextInt();
		
		if(studentRecords.remove(id) != null) {
			System.out.println("Student removed successfully");
		}
		else {
			System.out.println("Student with ID "+id+" does not exist.");
		}
	}
	
	private static void viewStudent() {
		System.out.println("Enter student ID to view: ");
		if(!sc.hasNextInt()) {
			System.out.println("Invalid input.ID must be a number");
			sc.nextLine();
			return;
		}
		int id = sc.nextInt();
		
		if(studentRecords.containsKey(id)) {
			System.out.println(studentRecords.get(id));
		}
		else {
			System.out.println("Student with ID "+id+" does not exist.");
		}
	}
}
