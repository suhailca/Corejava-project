package com.ty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import exception.InvalidChoiceExecption;
import exception.StudentNotFoundException;
import sorting.SortStudentByAge;
import sorting.SortStudentById;
import sorting.SortStudentByMarks;
import sorting.SortStudentByName;

public class StudentManagementSystemImplementation implements StudentMangementSystem {
	Scanner sc = new Scanner(System.in);
	Map<String, Student> db = new LinkedHashMap<String, Student>();

	//Adding the student data into the map
	@Override
	public void addStudent() {
		System.out.println("Enter the name of the student:");
		String name = sc.next();  
		System.out.println("Enter the age of the student:");
		int age = sc.nextInt();
		System.out.println("Enter the marks of the student:");
		int marks = sc.nextInt();
		Student std = new Student(name, age, marks);
		db.put(std.getId(),std );
		System.out.println("Student record inserted sucessfully");
		System.out.println("Student id : " +std.getId() );
		System.out.println("--------------------------------------------------------");

	}

	//display the student details by using the student id from the map
	@Override
	public void displayStudent() {
		System.out.println("Enter the id of the student:");
		String id = sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Student student = db.get(id);
			System.out.println("ID is "+student.getId() );
			System.out.println("Name is "+student.getName() );
			System.out.println("Age is "+student.getAge() );
			System.out.println("Marks is "+student.getMarks() );
			System.out.println("---------------------------------------------------------------");
		}
		else
		{
			String message = "student with the id "+id+"is not found";
			try {
			throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
	}

	//display the details of all the students in the map
	@Override
	public void displayAllStudent() {
		if(db.size()!=0)
		{
			System.out.println("Student details as follows:");
			System.out.println("---------------------------");
			Set<String> key=db.keySet();
			for(String std : key)
			{
				Student stds = db.get(std);
				System.out.println(stds);//or we can use like this: "System.out.println(db.get(std));"
			}
			System.out.println("----------------------------------------------------------------------");
		}
		else
		{
			String message = "Student database is empty,nothing to display";
			try {
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeStudent() {

		System.out.println("Enter the id want to delete:");
		String id = sc.next().toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("student id found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("student data deleted sucessfully");
			System.out.println("------------------------------------------------------------------");
		}
		else
		{
			String message = "student with the id "+id+"is not found";
			try {
			throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void removeAllStudent() {
		
		if(db.size()!=0)
		{
			System.out.println("students data is present:"+db.size());
			System.out.println("-----------------------------------");
			db.clear();
			System.out.println("All record deleted sucessfully");
			System.out.println("students data is present:"+db.size());
			System.out.println("--------------------------------------------------------------------");

		}
		else
		{
			String message = "Student database is empty,nothing to delete";
			try {
			throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void updateStudent() {

		System.out.println("enter the id of the student");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id))
		{
			Student std = db.get(id);
			System.out.println("1:Update the name\n2:Update the age\n3:Update the marks");
			System.out.println("Enter the choice:");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("enter the name");
				String name = sc.next();
				std.setName(name);
				System.out.println("-------------------------------------------------------");
				break;
			
			case 2:
				System.out.println("enter the age");
				int age = sc.nextInt();
				std.setAge(age);
				System.out.println("-------------------------------------------------------");

				break;
			
			case 3:
				System.out.println("enter the mark");
				int mark = sc.nextInt();
				std.setMarks(mark);
				System.out.println("-------------------------------------------------------");

				break;
			
				default :
					String message = "Invalid choice,enter valid choice";
					try {
					throw new InvalidChoiceExecption(message);
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
			}
			System.out.println("data updated");
			System.out.println("-------------------------------------------------------");

		}
		else
		{
			String message = "student with the id "+id+"is not found";
			try {
			throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudent() {
		System.out.println("Total no of   student records are :"+db.size());
		System.out.println("-------------------------------------------------------");

		
	}

	@Override
	public void sortStudent() {
		Set<String> keys = db.keySet();
		List<Student> list = new ArrayList<Student>();
		for(String key : keys)
		{
			list.add(db.get(key));
		}
		System.out.println("1:Sort by id\n2:Sort by name\n3:Sort by age\n4:Sort by marks");
		System.out.println("enter your choice:");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			Collections.sort(list, new SortStudentById());
			display(list);
			System.out.println("-------------------------------------------------------");
			break;
		
		case 2:
			Collections.sort(list, new SortStudentByName());
			display(list);
			System.out.println("-------------------------------------------------------");
			break;
			
		case 3:
			Collections.sort(list, new SortStudentByAge());
			display(list);
			System.out.println("-------------------------------------------------------");
			break;
			
		case 4:
			Collections.sort(list, new SortStudentByMarks());
			display(list);
			System.out.println("-------------------------------------------------------");
			break;
			
		default:
			String message = "Invalid choice,enter valid choice";
			try {
			throw new InvalidChoiceExecption(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
	} 		
	}
	
	public static void display(List<Student> list) {
		for(Student s:list)
		{
			System.out.println(s);
	}
	}
	

	@Override
	public void getStudentWithHighestMark() {

		Set<String> keys = db.keySet();
		List<Student> list = new ArrayList<Student>();
		for(String key : keys)
		{
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(list.get(list.size()-1));
		System.out.println("-------------------------------------------------------");

	}

	@Override
	public void getStudentWithLowestMark() {
		Set<String> keys = db.keySet();
		List<Student> list = new ArrayList<Student>();
		for(String key : keys)
		{
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println(list.get(0));
		System.out.println("-------------------------------------------------------");

	}

} 
