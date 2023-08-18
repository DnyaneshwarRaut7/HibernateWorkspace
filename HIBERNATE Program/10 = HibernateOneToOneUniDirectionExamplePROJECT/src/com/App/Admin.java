package com.App;

import java.util.Scanner;

import com.Service.Service;
import com.Service.ServiceIMPL;

public class Admin {

	public static void main(String[] args) {

		Service s = new ServiceIMPL();

		Scanner sc = new Scanner(System.in);

		System.out.println("***************@@@ = Start Application = @@@*************");

		while (true) {

			System.out.println("1.Add Student With Address");
			System.out.println("2.Sellect All Student Data ");
			System.out.println("3.Get Single Student With thier Address");
			System.out.println("4.Update Onely Student ");
			System.out.println("5.Update Addtess Using Student ");
			System.out.println("6.Delete Student  ");

			int ch = sc.nextInt();

			switch (ch) {

			case 1:
				s.addStudentwithAddress();
				break;

			case 2:
				s.getAllStudentwiththeirAddress();
				break;

			case 3:
				s.getSingleStudentwithAddeess();
				break;

			case 4:
				s.updateSingleStudent();
				break;

			case 5:
				s.updateAddressUsingStudent();
				break;

			case 6:
				s.deleteSingleStudent();
				break;
			case 7:
			default:
				break;
			}

		}

	}

}
