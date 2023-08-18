package com.Controller;

import java.util.Scanner;

import com.Service.ServiceI;
import com.Service.ServiceImple;

public class TestApp {

	public static void main(String[] args) {

		ServiceI s = new ServiceImple();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("================================================");
			System.out.println("1. Add AdhaarInfoOffice and AdhaarCard Data With PanCardData");
			System.out.println("2. Show All AdhaarInfoOfficeData");
			System.out.println("3. Get Single AdhaarInfoOfficeData");
			System.out.println("4. Update AdhaarInfoOfficeData");
			System.out.println("5. Update AdhaarCardData UsingAdhaarInfoOfficeId");
			System.out.println("=========================================================");

			System.out.println("Enter Your Choice");
			int ch = sc.nextInt();

			switch (ch) {

			case 1:
				s.addAdhaarInfoOfficeandAdhaarCardWithPanCardData();
				break;

			case 2:
				s.showAllAdhaarInfoOfficeData();
				break;

			case 3:
				s.getSingleAdhaarInfoOfficeData();
				break;

			case 4:
				s.updateAdhaarInfoOfficeData();
				break;

			case 5:
				s.updateAdhaarCardUsingAdhaarInfoOfficeId();
				break;

			default:
				break;
			}

		}

	}

}
