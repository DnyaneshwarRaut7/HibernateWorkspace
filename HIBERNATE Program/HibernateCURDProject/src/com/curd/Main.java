package com.curd;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.service.ServiceImpl;
import com.service.StudentService;

public class Main {

	public static void main(String[] args) {
		StudentService sss = new ServiceImpl();

		Scanner sc = new Scanner(System.in);

		System.out.println("******* Application Started Successfully ********");

		while (true) {

			System.out.println("--------------------------------------");
			System.out.println("1: Add Student Details");
			System.out.println("2: Show All Student Details");
			System.out.println("3: Show Single StudentDetails");
			System.out.println("4: Update Student Details");
			System.out.println("5: Delete Student Details");
			System.out.println("--------------------------------------");

			System.out.println("ENTER YOUR ID:-");
			int id = sc.nextInt();

			switch (id) {
			case 1:
				sss.addStudentInformention();
				break;
			case 2:
				sss.fetchAllStudentDetails();
				break;
			case 3:
				sss.fetchSingleStudentDetails();
				break;
			case 4:
				sss.updateStudentDetails();
				break;
			case 5:
				sss.deleteStudentDetails();
				break;

			default:
				break;
			}

		}

	}

}
