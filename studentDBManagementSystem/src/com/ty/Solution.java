package com.ty;

import java.util.Scanner;

import exception.InvalidChoiceExecption;

public class Solution {

	public static void main(String[] args) {
		System.out.println("*****Welcome to the student database*****");
		System.out.println("-----------------------------------------");
		Scanner sc = new Scanner(System.in);
		StudentMangementSystem sms  = new StudentManagementSystemImplementation();
		while(true)
		{
			System.out.println("1:Add the student\n2:Display the student");
			System.out.println("3:Display all student\n4:Remove the student");
			System.out.println("5:Remove all the student\n6:Update the student");
			System.out.println("7:Count of the student\n8:Sort the student");
			System.out.println("9:Student with highest mark\n10:Student with lowest mark\n11:exit");
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();
			switch (ch) {
			case 1: 
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				sms.getStudentWithHighestMark();
				break;
			case 10:
				sms.getStudentWithLowestMark();
				break;
			case 11:
				System.out.println("Thank you!!!!");
				System.exit(0);
				break;
				
				default:
					String message = "Invalid choice,enter valid choice";
					try {
					throw new InvalidChoiceExecption(message);
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
			}	//end of the Switch statement 
				
		}//end of the while loop
		
	}//end of the main method
	
}// end of the class
