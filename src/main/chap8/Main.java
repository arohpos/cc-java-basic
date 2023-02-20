package main.chap8;

public class Main {

	public static void main(String[] args) {
		//課題1
		Card card = new Card();
		card.suit = "スペード";
		card.number = 3;
		card.visible = true;
		card.reverse();
		
		System.out.println(card.suit + "/" + card.number + "/" + card.visible);

	}

}
