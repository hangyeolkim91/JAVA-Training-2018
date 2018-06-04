package com.library2;

public class BookVO implements Comparable<BookVO> {

	private String title,author,lender, lendDate, returnDate,publisher;
	private boolean isRental;
	private String[] rentalMsg = {"대여중","대여가능"};
	
	
	@Override
	public String toString() {
		String str;
		if(isRental){
			str = String.format("%6s %6s %6s %4s %6s %18s %6s", title, author,publisher,rentalMsg[0], lender, lendDate, returnDate);
		}else{
			str = String.format("%6s %6s %6s %4s %6s %18s %6s", title, author,publisher,rentalMsg[1], lender, lendDate, returnDate);
		}
		
		return str;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLender() {
		return lender;
	}
	public void setLender(String lender) {
		this.lender = lender;
	}
	public String getLendDate() {
		return lendDate;
	}
	public void setLendDate(String lendDate) {
		this.lendDate = lendDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public boolean isRental() {
		return isRental;
	}
	public void setRental(boolean isRental) {
		this.isRental = isRental;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	@Override
	public int compareTo(BookVO o) {
		return this.title.compareToIgnoreCase(o.getTitle());
	}
	
}
