package com.user.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.user.bean.Book;
import com.user.bean.Category;
import com.user.bean.Course;
import com.user.bean.Student;
import com.user.bean.User;
import com.user.util.HibernateUtil;

public class HqlTest {
public static void main(String[] args) {
	Session session = HibernateUtil.getSession();
	Transaction transaction = session.beginTransaction();
//	String hql="from Student u where u.sid=?";
//	Query query = session.createQuery(hql);
//	query.setParameter(0,"40283f815f2e48b9015f2e48bca50002");
//	Student student= (Student) query.uniqueResult();
//	System.out.println(student.getSname());
	
//	String hql="select count(*) from User";
//	Query query = session.createQuery(hql);
//	long count = (Long) query.uniqueResult();
//	System.out.println("数量共："+count+"条");
	
	String hql="from Book b where b.category=:xxx";
	Query query = session.createQuery(hql);
	Category category=(Category)session.get(Category.class,"40283f815f2d5c1e015f2d5c202b0000");
	query.setParameter("xxx",category);
	List<Book> books = query.list();
	for (Book book : books) {
		System.out.println(book.getBookname());
		
	}
	transaction.commit();
	session.close();
	HibernateUtil.close();
	
	
}
}
