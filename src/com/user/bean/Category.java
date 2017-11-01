package com.user.bean;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private String cid;
	private String categoryname;
	private Set<Book> books = new HashSet<Book>();
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

}
