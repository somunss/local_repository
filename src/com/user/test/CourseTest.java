package com.user.test;

import java.util.Set;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.user.bean.Course;
import com.user.bean.Student;
import com.user.util.HibernateUtil;

public class CourseTest {

	public static void main(String[] args) {
		update();
	}
	public static void update(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
//		Course course = (Course) session.get(Course.class,"40283f815f346f3f015f346f417d0002");
//		
//		Set<Student> students = course.getStudents();
//		for (Student student : students) {
//			System.out.println(student.getSname());
//			
//		}
		
		Student student = (Student) session.get(Student.class,"40283f815f346f3f015f346f417d0003");
		Set<Course> courses = student.getCourses();
		for (Course course : courses) {
			course.setCname("english");
			course.setCname("chinese");
			
			
		}
		
		
		
		transaction.commit();
		session.close();
		HibernateUtil.close();
	}
	
	
	public static void query(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
//		Course course = (Course) session.get(Course.class,"40283f815f346f3f015f346f417d0002");
//		
//		Set<Student> students = course.getStudents();
//		for (Student student : students) {
//			System.out.println(student.getSname());
//			
//		}
		
		Student student = (Student) session.get(Student.class,"40283f815f346f3f015f346f417d0003");
		Set<Course> courses = student.getCourses();
		for (Course course : courses) {
			System.out.println(course.getCname());
			
		}
		
		
		
		transaction.commit();
		session.close();
		HibernateUtil.close();
	}
	
	public static void delete(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
	Course course=(Course)session.get(Course.class,"40283f815f2e4f9e015f2e4fa0b10000");
	session.delete(course);
		transaction.commit();
		session.close();
		HibernateUtil.close();
		
	}

	public static void insert(){
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Student stu1=new Student();
		stu1.setSname("莉莉");
		Student stu2=new Student();
		stu2.setSname("敏敏");
		Course cou1=new Course();
		cou1.setCname("css");
		Course cou2=new Course();
		cou2.setCname("html");
		stu1.getCourses().add(cou1);
		stu2.getCourses().add(cou1);
		stu1.getCourses().add(cou2);
		stu2.getCourses().add(cou2);
		cou1.getStudents().add(stu1);
		cou2.getStudents().add(stu2);
		session.save(cou2);
		session.save(cou1);
//		session.save(stu2);
//		session.save(stu1);
		
		
		
		transaction.commit();
		session.close();
		HibernateUtil.close();
		
	}

}
