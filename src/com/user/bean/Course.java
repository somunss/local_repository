package com.user.bean;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private String cid;
	private String cname;
	Set<Student> students=new HashSet<Student>();
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
