package com.Controller;

import java.util.Scanner;

import com.Service.EmployeeServiceI;
import com.Service.EmployeeServiceimpl;

public class MainApp {

	public static void main(String[] args) {

		EmployeeServiceI s = new EmployeeServiceimpl();
		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		while (flag) {

			System.out.println("*********** Application Started ******************");
			System.out.println("1. Insert Data");
			System.out.println("2. Get Single Data ");
			System.out.println("3. Show All Data");
			System.out.println("4. Update Data");
			System.out.println("5. Delete Data");
			System.out.println("=====================================================");

			System.out.println("Enter your Choice");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				s.insertData();
				break;

			case 2:
				s.getSinleDta();
				break;

			case 3:
				s.showAllData();
				break;

			case 4:
				s.updateData();
				break;

			case 5:
				s.deleteData();
				break;

			default:
				break;
			}

		}

	}

}
