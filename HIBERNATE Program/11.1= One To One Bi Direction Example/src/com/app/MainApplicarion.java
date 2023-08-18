package com.app;

import java.util.Scanner;

import com.Service.ServiceI;
import com.Service.Serviceimpl;

public class MainApplicarion {

	public static void main(String[] args) {

		ServiceI s = new Serviceimpl();
		Scanner sc = new Scanner(System.in);

		System.out.println("======@*@ MOBILEAPPLICATON STARTED @*@=======");
		while (true) {

			System.out.println("1. Add Mobile Data With Battery Data:-");
			System.out.println("2. get Single Mobile Data With Battery Data Using Mobile Id:-");
			System.out.println("3. get Single Mobile Data With Battery Data Using Battery Id:-");
			System.out.println("4. get All Mobile Data With Battery Data Using Mobie Id:-");
			System.out.println("5. get All Mobile Data With Battery Data Using Battery Id:-");
			System.out.println("6. Update Mobile Data Using Mobile Id:- ");
			System.out.println("7. Update Battery Data Using Mobile Id:- ");
			System.out.println("8. Update Battery Data");
			System.out.println("9. Update Mobile using Battery Id:-");
			System.out.println("10. Delete Mobile Data :-");

			int ch = sc.nextInt();

			switch (ch) {

			case 1:
				s.addMobileAndBatteryDetails();
				break;
			case 2:
				s.getsingleMobiledataWithBatteryusingMobailid();
				break;
			case 3:
				s.getSingleMobiledataWithBatteryusingBatteryid();
				break;
			case 4:
				s.getAllMobiledatawithBattery();
				break;
			case 5:
				s.getAllMobileDatawithBatteryUsingBattery();
				break;
			case 6:
				s.updateMobileData();
				break;
			case 7:
				s.updateBatteryUsingMobileId();
				break;
			case 8:
				s.updateBatteryData();
				break;
			case 9:
				s.updateMobiledatausingBattery();
				break;
			case 10:
				s.deleteMobile();
				break;

			default:
				break;
			}

		}

	}

}
