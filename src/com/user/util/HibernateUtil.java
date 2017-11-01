package com.user.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtil {
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	static{
		configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	public static Session CurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public static void close(){
		sessionFactory.close();
	}
}
