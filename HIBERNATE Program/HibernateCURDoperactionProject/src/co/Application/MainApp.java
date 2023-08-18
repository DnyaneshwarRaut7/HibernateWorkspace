package co.Application;

import java.util.Scanner;

import com.Service.ProductService;
import com.Service.ProductServiceImpl;

public class MainApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ProductService ps = new ProductServiceImpl();

		System.out.println("****************** Product Application Started **************");

		while (true) {
			System.out.println("----------------------------------");
			System.out.println(" 1. Add Product Details:-");
			System.out.println(" 2. Show All Product Details:-");
			System.out.println(" 3. Get Single Product Details:-");
			System.out.println(" 4. Update Product Data");
			System.out.println(" 5. Delete Product Data");
			System.out.println("--------------------------------------");

			int ch = sc.nextInt();

			switch (ch) {

			case 1:
				ps.addProduct();

				break;

			case 2:
				ps.sellectAll();
				break;

			case 3:
				ps.getSingleDetails();
				break;

			case 4:
				ps.updateProduct();
				break;

			case 5:
				ps.deleteProdct();
				break;
			default:
				break;
			}

		}

	}

}