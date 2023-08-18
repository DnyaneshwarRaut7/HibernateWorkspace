package com.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.entity.UserDataRecord;

public class TestFileHandeling {

	public static void main(String[] args) throws IOException {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		UserDataRecord udr = new UserDataRecord();

		// File to Byte Array Conversion

		Path path = Paths.get("D:\\NewM.jpg");
		byte[] b = Files.readAllBytes(path);
//		System.out.println(Arrays.toString(b));

		// BYTE ARRAY YO FILE CONVERSION
//
		Path path1 = Paths.get("D:\\","mauli1.jpg");
		Files.write(path1, b);

		udr.setFdata(b);
		udr.setFname(path.toAbsolutePath().toString());

		session.save(udr);
		session.beginTransaction().commit();
		System.out.println("Sucessfully");

	}

}
