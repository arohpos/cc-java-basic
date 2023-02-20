package main.chap10;

public class Chip {
	int num;
	
	public Chip(int num) {
		this.num = num;
	}
	
	protected void change(int num) {
		this.num = this.num + num ;
	}
	
	protected int getNum() {
		return this.num;
	}
	
	protected void setNum(int num) {
		this.num = num;
	}
	
}
