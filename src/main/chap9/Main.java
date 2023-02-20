package main.chap9;

public class Main {

	public static void main(String[] args) {
		//課題1
		Card card1 = new Card("ハート", 5, false);
		Card card2 = new Card("クラブ", 2, false);
		System.out.println(card1.suit + "/" + card1.number + "/" + card1.visible);
		System.out.println(card2.suit + "/" + card2.number + "/" + card2.visible);
	}
}
