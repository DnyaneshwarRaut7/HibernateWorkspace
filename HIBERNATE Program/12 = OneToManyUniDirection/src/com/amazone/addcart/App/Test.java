package com.amazone.addcart.App;

import java.util.Scanner;

import com.amazone.addcart.Service.ServiceI;
import com.amazone.addcart.Service.Serviceimpl;

public class Test { 

	public static void main(String[] args) {

		ServiceI s = new Serviceimpl();
		Scanner sc = new Scanner(System.in);

		System.out.println("------ AMAZONE APPLICATION STARTED -------");

		while (true) {

			System.out.println("1.Add To Cart Items Data .");
			System.out.println("2.Show All Cart Data .");
			System.out.println("3.Get Single Cart Data .");
			System.out.println("4.Update Cart Dta");
			System.out.println("5.Update Perticular Items Using Cart Id");
			System.out.println("6.Delete Perticular Items Deleting Cart Id");
			System.out.println("7.Delete Cart Data .");

			int ch = sc.nextInt();
			switch (ch) {

			case 1:
				s.addCartAndWithItemData();
				break;

			case 2:
				s.showAllCatData();
				break;
			case 3:
				s.getSingleCartData();
				break;
			case 4:
				s.updateCartData();
				break;
			case 5:
				s.UpdataPerticularItemsUsingCratId();
				break;
			case 6:
				s.deletePertiularItemsDataFromCartusingCartId();
				break;
			case 7:
				s.deleteCartData();
				break;

			default:
				break;
			}

		}

	}

}
