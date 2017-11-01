package com.user.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.user.bean.User;
import com.user.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
	}
	public static void hql2(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		User user=new User();
		user.setUsername("莺歌");
		user.setPassword("214");
		session.saveOrUpdate(user);
	transaction.commit();
		session.close();
		HibernateUtil.close();
		
		
	}
	
	public static void hql1(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		//criteria.add(Restrictions.eq("username","威少"));
		criteria.add(Restrictions.idEq(5));
		List<User> list = criteria.list();
		
//		String hql="from User where password = 1997";
//		List<User> list = session.createQuery(hql).list();
		for (int i = 0; i <list.size(); i++) {
		System.out.println(list.get(i).getUsername());
	}
		transaction.commit();
		session.close();
		HibernateUtil.close();
		
		
	}
	
	public static void querys(){
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//String hql="from User";
		//Query query = session.createQuery(hql).setMaxResults(2).setFirstResult(3);
		
		String sql="select * from user";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		  List<User> list = sqlQuery.addEntity(User.class).list();
		
		
		for (int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i).getUsername());
			
			
		}
		
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		
	}
	public static void query(){
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user=(User)session.get(User.class,2);
		User user2=(User)session.load(User.class,2);
		System.out.println(user.getUsername());
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	public static void delete(){
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//得到指定对象然后删除
	//	User user=(User)session.get(User.class,3);
		//通过ID删除对象
		User user=new User();
		user.setId(2);
		session.delete(user);
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	public static void update(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		User user=(User)session.get(User.class,3);
		
		user.setUsername("克拉克森");
		//session.update(user);
		
		
		transaction.commit();
		session.close();
		HibernateUtil.close();
	}
	public static void insert(){
		Configuration configuration = new Configuration().configure();
		
		SessionFactory SessionFactory = configuration.buildSessionFactory();
		
		Session session = SessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		User user=new User();
		user.setUsername("宋祖儿");
		user.setPassword("1997");
		session.save(user);

		transaction.commit();
		session.close();
		SessionFactory.close();
	}

}
