package com.zc.mybatis;

public class Book {
	private int bookId;
	private String bookName;
	private int bookPrice;
	private boolean bookSell;
	
	private Explain explain; //图书类型 核和简介
	

	/*构造方法 有参构造*/	
	public Book(int bookId, String bookName, int bookPrice) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	/*构造方法 有参构造*/
	public Book(int bookId, String bookName, int bookPrice, boolean bookSell) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookSell = bookSell;
	}
	
	/*构造方法 无参构造*/
	public Book() {
		
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public boolean isBookSell() {
		return bookSell;
	}
	public void setBookSell(boolean bookSell) {
		this.bookSell = bookSell;
	}

	
	public Explain getExplain() {
		return explain;
	}
	public void setExplain(Explain explain) {
		this.explain = explain;
	}
	
	/**
	 * 重写
	 * 打印该书的Id 书名  价格
	 */

	@Override
	public String toString() {
		
		return this.bookId+"--"+this.bookName+"--"+this.bookPrice+"-是否出售："+this.bookSell;
	}
	
}
