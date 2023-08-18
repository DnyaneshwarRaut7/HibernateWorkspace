package com.App;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.Service.ServiceI;
import com.Service.Serviceimpl;

public class MainApplicaion {
	public static int input() {
		Scanner sc = new Scanner(System.in);
		int  out = 0;
		try {
			 out = sc.nextInt();

		} catch (InputMismatchException e) {
		
			System.out.println("Invilied input");
		}
		return out;
	}

	public static void main(String[] args) {

		ServiceI s = new Serviceimpl();
		Scanner sc = new Scanner(System.in);

		System.out.println("*****:-MAIN APPLICATION -:*****");
		while (true) {

			System.out.println("1. Add Car Data With Engine Data:-");
			System.out.println("2. get Single Car Data With Engine Data Using Car Id:-");
			System.out.println("3. get Single Car Data With Engine Data Using Engine Id:-");
			System.out.println("4. get All Car Data With Engine Data Using Car :-");
			System.out.println("5. get All Car Data With Engine Data Using Engine :-");
			System.out.println("6. Update Car Data Using Car Id:- ");
			System.out.println("7. Update Engine Data Using Car Id:- ");
			System.out.println("8. Update Engine Data");
			System.out.println("9. Update Car using Engine Id:-");
			System.out.println("10. Delete Car Data :-");

			int ch =  input();
			switch (ch) {

			case 1:
				s.addCarAndEngineDetails();

				break;
			case 2:

				s.getSingleCarDataWithEngineUsingCarId();
				break;
			case 3:
				s.getSingleCarDataUsingEngineId();
				break;
			case 4:
				s.getAllCarDataWithEngine();
				break;
			case 5:
				s.getAllCarDatawithEngineUsingEngine();
				break;
			case 6:
				s.updateCarData();
				break;
			case 7:
				s.updateEngineUsingCarId();
				break;
			case 8:
				s.updateEngine();
				break;
			case 9:
				s.updateCarDataUsingEngine();
				break;
			case 10:
				s.deleteCar();
				break;

			default:
				break;

			}

		}

	}

}
