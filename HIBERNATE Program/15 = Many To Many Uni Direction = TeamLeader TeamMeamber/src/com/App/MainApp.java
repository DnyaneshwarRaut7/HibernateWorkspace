package com.App;

import java.util.Scanner;

import com.Service.ServiceI;
import com.Service.Serviceimple;

public class MainApp {

	public static void main(String[] args) {

		ServiceI s = new Serviceimple();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("********** _____________________________ ****************");
			System.out.println("A. Add TeamLeadData With TeamMember Data.");
			System.out.println("B. Get Single TeamLeadData.");
			System.out.println("C. Show All Data.");
			System.out.println("D. Update TeamLeadData.");
			System.out.println("E. Update Perticular TeamMemberData.");
			System.out.println("F. Delete TeamLeaderData.");
			System.out.println("_________________________________________________________");
//jdk 1.5 start
			System.out.println("Enter your choice");
			String ch = sc.next();

			switch (ch) {

			case "A":
				s.addTeamLeadDataWithTeamMemberData();
				break;

			case "B":
				s.getSingleTeamLeadData();
				break;

			case "C":
				s.showAllData();
				break;

			case "D":
				s.updateTeamLeadData();
				break;

			case "E":
				s.updatePerticularTeamMemberData();
				break;

			case "F":
				s.deleteTeamLeaderData();
				break;

			default:
				break;

			}
		}

	}

}
