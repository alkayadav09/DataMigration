package com.practice.DataMigration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
  	Here Destination DataBase configuration is done by configuring the hibernateDestination.xml file 
*/

public class HibernateUtilsDestination {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static {
		sessionFactory = new Configuration()
										.configure("hibernateDestination.xml")
										.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	public static Session getSession(){
		return session;
	}
}
