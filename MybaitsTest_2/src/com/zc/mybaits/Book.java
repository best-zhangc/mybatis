package com.zc.mybaits;

public class Book {
	private int bookId;
	private String bookName;
	private int bookPrice;
	
	/*构造方法 有参构造*/
	public Book(int bookId, String bookName, int bookPrice) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
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
	/**
	 * 重写
	 * 打印该书的Id 书名  价格
	 */

	@Override
	public String toString() {
		
		return this.bookId+"--"+this.bookName+"--"+this.bookPrice+" ";
	}
	
}
