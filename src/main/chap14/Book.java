package main.chap14;

public class Book {
	String title;
	int price;
	String author;
	
	//コンストラクタ
	public Book(String title, int price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
	}

	//toString
	@Override
	public String toString() {
		return "署名：" + this.title + "/価格：" + this.price + "/著者名：" + this.author;
	}
	
	//getter&setter 
	protected String getTitle() {
		return title;
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	protected int getPrice() {
		return price;
	}

	protected void setPrice(int price) {
		this.price = price;
	}

	protected String getAuthor() {
		return author;
	}

	protected void setAuthor(String author) {
		this.author = author;
	}
	
	

}
