package com.Admin;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.model.EmployeeMaster;

public class Test {

	public static long getmobailno() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Mobail Number");

		try {
			long mob = sc.nextLong();

			return mob;

		} catch (InputMismatchException e) {
			System.out.println("char not allove only number allove");
			return getmobailno();
		}
	}

	public static double getSallary() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee Sallary");
		try {
			double sallary = sc.nextDouble();

			return sallary;

		} catch (Exception e) {
			System.out.println(" char not allove only number allove:");
			return getSallary();

		}

	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Scanner sc = new Scanner(System.in);
		System.out.println("how many Employee you want to add");

		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {

			EmployeeMaster em = new EmployeeMaster();

			System.out.println("Enter your Employee Name");
			String name = sc.next();
			em.setEname(name);

			System.out.println("Enter your Post");
			String post = sc.next();
			em.setDesigntion(post);

			em.setMobno(getmobailno());

			System.out.println("Enter your Email Id:-");
			String mail = sc.next();
			em.setEmailid(mail);

			em.setSallary(getSallary());

			session.save(em);

		}
		session.beginTransaction().commit();

		System.out.println("Done......");

	}

}
