package com.app;

import java.util.Base64;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.entity.LoginData;

public class TestPass {

	public static void main(String[] args) {

		System.out.println("---------- INCODING FROM -------------");

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Scanner sc = new Scanner(System.in);

		Session session = sf.openSession();
		LoginData ld = new LoginData();
		System.out.println("Enter your UserName");
		ld.setUserName(sc.next());

		System.out.println("Enter your Password");
		String pass = sc.next();

		String strpass = Base64.getUrlEncoder().encodeToString(pass.getBytes());
		ld.setPassward(strpass);

		session.save(ld);
		session.beginTransaction().commit();
		System.out.println("Done");

		System.out.println("------- Decoding Data ---------------");

//		Session session1 = sf.openSession();
//		System.out.println("Enter your UserName");
//		String uname = sc.next();
//		ld.setUserName(uname);
//
//		System.out.println("Enter your Password");
//		String pass1 = sc.next();
//		ld.setPassward(pass1);

		LoginData ll = session.get(LoginData.class, 1);
		System.out.println(ll.getPassward());
		byte[] pp = Base64.getDecoder().decode(ll.getPassward());
		System.out.println(pp);
		String s = new String(pp);
		System.out.println("decoder pass" + s);
//		ld.setUserName(uname);
//		ld.setPassward(pass1);
		session.save(ld);
		session.beginTransaction().commit();
		System.out.println("Done");

	}

}
