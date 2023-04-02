package main.chap16;

public class Main {

	public static void main(String[] args) {
		//BigOrSmall bigOrSmall = new BigOrSmall();
		//bigOrSmall.playBigOrSmall();
		
		Deck deck = new Deck();
		for(int i = 0; i < 53; i++) {			
			deck.draw();
		}
		//System.out.println(deck.countNotUsedCard());
	}

}
