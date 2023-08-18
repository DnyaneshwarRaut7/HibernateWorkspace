package com.App;

import java.util.Scanner;

import com.Service.ServiceI;
import com.Service.Serviceimpl;

public class MainApp {

	public static void main(String[] args) {

		ServiceI s = new Serviceimpl();

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("------- PF ACCOUNT APPLICATION STARTED --------");
			System.out.println("1. Add EPFAccount With Multiple PFAccount Data.");
			System.out.println("2. Show All EPFAccount With PFAccount Data.");
			System.out.println("3. Get Single EPFAccount With PFAccount Data.");
			System.out.println("4. Update EPFAccount");
			System.out.println("5. Update Perticular PFAccount Using EPFAccoint Id.");
			System.out.println("6. Delete Perticular PFAccount Using EPFAccoint Id.");
			System.out.println("7. Get Single PFAccount With EPFAccount Data.");
			System.out.println("8. Show All PFAccount With EPFAccount Data.");
			System.out.println("9. Update PFAccount");
			System.out.println("10.Update EPFAccount Using PFAccountId");
			System.out.println("11.Delete Perticular PFAccount Using PFAccount");
			System.out.println("======================================================");
			
			System.out.println("Enter your Choice");
			int ch = sc.nextInt();
			
			switch(ch) {
			
			case 1:
				s.addEPFAccountWithMultiplePFAccount();
				break;
				
			case 2:
				s.showAllEPFAccountWithPFAccount();
				break;
			case 3:
				s.getSingleEPFAccountWithPFAccount();
				break;
			case 4:
				s.updateEPFAccount();
				break;
			case 5:
				s.updatePerticularPFAccountUsingEPFAccointId();
				break;
			case 6:
				s.deletePerticularPFAccountUsingEPFAccointId();
				break;
			case 7:
				s.getSinglePFAccountWithEPFAccount();
				break;
			case 8:
				s.showAllPFAccountWithEPFAccount();
				break;
			case 9:
				s.updatePFAccount();
				break;
				
			case 10:
				s.updateEPFAccountUsingPFAccountId();
				break;
				
			case 11:
				s.deletePerticularPFAccountUsingPFAccount();
				break;
				
				default:
					break;
			}
			
		}

	}

}
