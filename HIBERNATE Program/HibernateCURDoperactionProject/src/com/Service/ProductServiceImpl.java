package com.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;

import com.Model.Product;
import com.Util.HibernateUtil;

public class ProductServiceImpl implements ProductService {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	Session session = sf.openSession();

	Product p = new Product();

	@Override
	public void addProduct() {

		System.out.println("Enter Product Name");
		p.setPname(sc.next());

		productprice();
		System.out.println("Enter your Product Quantity");
		p.setQuentity(sc.nextInt());

		session.save(p);

		session.beginTransaction().commit();
		System.out.println("Product Addead......!");
	}

	public static void productprice() {
		Scanner sc = new Scanner(System.in);

		Product p = new Product();

		System.out.println("Enter your Product Price ");
		try {
			p.setPrice(sc.nextDouble());
		} catch (InputMismatchException e) {

			System.out.println("Char Not Allove Only Number Allove");
			productprice();

		}
	}

	@Override
	public void sellectAll() {

		Session session = sf.openSession();
		Query<Product> query = session.createQuery("from Product");
		List<Product> plist = query.getResultList();
		// System.out.println(plist);

		for (Product pp : plist) {

			System.out.println("------- Product Data ------");
			System.out.println("Product Id -: " + pp.getPid());
			System.out.println("Product Name -: " + pp.getPname());
			System.out.println("Product Price -: " + pp.getPrice());
			System.out.println("Product Categery -: " + pp.getQuentity());
			System.out.println("--------------------------------------------------------");

		}

	}

	@Override
	public void getSingleDetails() {

		Session session = sf.openSession();
		System.out.println("Enter Product Id:-");
		int id = sc.nextInt();
		Product p = session.get(Product.class, id);
		if (p != null) {

			//System.out.println(p);
			System.out.println("------- Product Data ------");
			System.out.println("Product Id -: " + p.getPid());
			System.out.println("Product Name -: " + p.getPname());
			System.out.println("Product Price -: " + p.getPrice());
			System.out.println("Product Categery -: " + p.getQuentity());
			System.out.println("--------------------------------------------------------");

		} else {
			System.out.println("Product not Present");

		}

	}

	@Override
	public void updateProduct() {

		System.out.println("....Updte Product Informention....");

		Session session = sf.openSession();
		System.out.println("Enter Product Id");
		int id = sc.nextInt();
		Product p = session.get(Product.class, id);

		boolean flag = true;
		while (flag) {

			System.out.println("*******************************");
			System.out.println(" 1. Product Update Name");
			System.out.println(" 2. Product Update Price");
			System.out.println(" 3. Product Update Quantity");
			System.out.println(" 4. Exit");
			System.out.println("******************************************");

			System.out.println("Enter your Choice");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Product name Updaterd");
				p.setPname(sc.next());
				session.update(p);
				session.beginTransaction().commit();

				break;

			case 2:
				System.out.println("Product Updated Price");
				p.setPrice(sc.nextDouble());
				session.update(p);
				session.beginTransaction().commit();
				break;

			case 3:
				System.out.println("Product Updated Quentity");
				p.setQuentity(sc.nextInt());
				session.update(p);
				session.beginTransaction().commit();
				break;
			case 4:
				flag = false;
				break;
			default:

				System.out.println("Wrong choice");
				sc.close();
			}

			System.out.println("Product Updated Sucessfully.....");
		}
	}

	@Override
	public void deleteProdct() {

		Session session = sf.openSession();
		System.out.println("Enter your Product Id ");
		int id = sc.nextInt();
		Product p = session.get(Product.class, id);

		session.delete(p);
		session.beginTransaction().commit();
		System.out.println("Product Delected Sucessfully.............!!");

	}

}
