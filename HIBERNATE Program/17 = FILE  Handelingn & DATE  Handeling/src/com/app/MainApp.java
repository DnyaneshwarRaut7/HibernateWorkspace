package com.app;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.entity.UserDataRecord;

public class MainApp {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		UserDataRecord udr = new UserDataRecord();
		// data set
		udr.setName("avi");
		udr.setAddress("pune");

		// Date Handling
		// Date Object & current time ,date
		// date util . package
		// system = java class
		// currentTimeMillis = method live time date show
		Date date = new Date(System.currentTimeMillis());

		// simple date formate object
		SimpleDateFormat formate = new SimpleDateFormat("dd-MMM-yyyy hh:mm:sss");
// uploaded date String formate
		String uploadedDate = formate.format(date);
		// set uploded date
		udr.setUoloadeddate(uploadedDate);

		// jdk 1.8
		// imp use jada
		LocalDateTime date1 = LocalDateTime.now();
		System.out.println("Check Date" + date1);
		udr.setModifydate(date1);

		session.save(udr);
		session.beginTransaction().commit();
		System.out.println("Date Handeling Sucessfully");

	}

}
