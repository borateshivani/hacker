package com.demo.bean;

public class Book {
	private int id;
	private String name;
	private int price;
	private String authorName;
	private String cat;
	
	public Book(int id, String name, String auth,int price,String c) {
		this.id = id;
		this.name = name;
		this.authorName=auth;
		this.price = price;
		this.cat=c;
	}
	
	
	public String getCat() {
		return cat;
	}


	public void setCat(String cat) {
		this.cat = cat;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAuthorName(String auth) {
		this.authorName=auth;
	}
	public String getAuthorName() {
		return authorName;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", authorName=" + authorName + "]";
	}
	
	
}
