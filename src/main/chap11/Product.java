package main.chap11;

public class Product {
	String name;
	int price;
	
	protected Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	protected String getName() {
		return this.name;
	}
	protected int getPrice() {
		return this.price;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.name + "の値段は" + this.price;
	}
	
}
