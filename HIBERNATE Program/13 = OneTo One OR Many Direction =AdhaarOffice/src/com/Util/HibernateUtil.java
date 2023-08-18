package com.Util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.entity.AdhaarCard;
import com.entity.AdhaarInfoOffice;
import com.entity.PanCard;

public class HibernateUtil {

	private static StandardServiceRegistry registry = null;
	private static SessionFactory sf = null;

	public static SessionFactory getSessionFactory() {

		if (sf == null) {

			Map<String, Object> map = new HashMap<String, Object>();

			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/ONE_OR_MANYDirection");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");

			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			map.put(Environment.HBM2DDL_AUTO, "update");
			map.put(Environment.SHOW_SQL, true);

			registry = new StandardServiceRegistryBuilder().applySettings(map).build();
			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(AdhaarInfoOffice.class)
					.addAnnotatedClass(AdhaarCard.class).addAnnotatedClass(PanCard.class);

			Metadata md = mds.getMetadataBuilder().build();
			sf = md.buildSessionFactory();
		}
		return sf;
	}

}
