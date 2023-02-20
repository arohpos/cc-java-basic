package main.chap8;

public class Card {
	String suit;
	int number;
	boolean visible;
	
	public void reverse() {
		visible = !visible;
	}

}
