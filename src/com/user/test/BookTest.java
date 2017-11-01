package com.user.test;

import java.util.Set;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.user.bean.Book;
import com.user.bean.Category;
import com.user.util.HibernateUtil;

public class BookTest {
	public static void main(String[] args) {
		query();
	}
	public static void query(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Category category=(Category) session.get(Category.class,"40283f815f2d5a59015f2d5a5aed0000");
		Set<Book> books = category.getBooks();
		for (Book book : books) {
			System.out.println(book.getBookname());
		}
		transaction.commit();
		session.close();
		HibernateUtil.close();
		
		
	}
	public static void delete(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Category category=(Category) session.get(Category.class,"40283f815f2d5c1e015f2d5c202b0000");
		session.delete(category);
		transaction.commit();
		session.close();
		HibernateUtil.close();
		
		
	}
	
	public static void insert(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Book book1=new Book();
		book1.setBookname("java编程思想");
		Book book2=new Book();
		book2.setBookname("java的实践运用");
		
		Category category=new Category();
		category.setCategoryname("java");
		
		category.getBooks().add(book1);
		category.getBooks().add(book2);
		book1.setCategory(category);
		book2.setCategory(category);
		
		session.save(category);
		//session.save(book1);
		//session.save(book2);
		
		
		transaction.commit();
		session.close();
		HibernateUtil.close();
	}

}
