package com;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	// Static global variable declare
	// we use all class
	private static StandardServiceRegistry registey = null;

	// Static global variable declare
	// we use all class
	private static SessionFactory sf = null;

	// static Method use Other class call Direct class Name
	public static SessionFactory getsessonfactory() {

		// condition
		if (sf == null) {

			// map object
			Map<String, Object> map = new HashMap<String, Object>();

			// dataBase Properties
			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/HibernateJavabase2");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");

			// Hibernate properties
			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			map.put(Environment.HBM2DDL_AUTO, "update");
			map.put(Environment.SHOW_SQL, "true");

			registey = new StandardServiceRegistryBuilder().applySettings(map).build();

			MetadataSources mds = new MetadataSources(registey).addAnnotatedClass(Student.class);

			Metadata md = mds.getMetadataBuilder().build();

			sf = md.buildSessionFactory();

		}

		return sf;

	}

}
