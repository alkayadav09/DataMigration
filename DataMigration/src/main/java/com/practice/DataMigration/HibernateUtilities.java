package com.practice.DataMigration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
	Here Source DataBase configuration is done by configuring the hibernateSource.xml file 
*/

public class HibernateUtilities {
	
	private static SessionFactory sessionFactory;
	private static Session session ;
	
	static{
		sessionFactory = new Configuration()
										.configure("hibernateSource.xml")
										.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public static Session getSession(){
		return session;
	}

}
