package main.chap16;

import java.util.Random;

//今回のカードデッキはスート4種、各13枚、ジョーカーなしの固定でOK（ここの拡張性は不要）
public class Deck {
	
	//Suit型（列挙）の配列
	private Suit[] suits = Suit.values();
	
	//Remark：配列の枠をnewしているだけで、配列の要素はnewしていないため、コンストラクタないでnewが必要となる。
	Card[][] cards = new Card[4][13];
	private boolean isUsed[][] = new boolean[4][13];
	
	//コンストラクタ
	public Deck() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				this.cards[i][j] = new Card(suits[i], j + 1);
				this.isUsed[i][j] = false;
			}
		}
		System.out.println("---カードデッキを準備しました。---");
	}
	
	//カードデッキのシャッフルメソッド
	public void reset() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				this.isUsed[i][j] = false;
			}
		}
		System.out.println("---デッキをシャッフルしました。---");
	}
	
	//ランダムな未使用のカードを一枚引くメソッド
	public Card draw() {
		Random random = new Random();
		int rand;
		//未使用カードが0枚の場合、カードデッキをシャッフルする。
		//！：これをしないと、whileがいつまでもbreakできなくなる。
		if(this.countNotUsedCard() == 0) {
			System.out.println("---カードがないためデッキをシャッフルします。---");
			this.reset();
		}
		
		while(true) {
			rand = random.nextInt(52);
			if(isUsed[rand / 13][rand % 13] == false) {
				isUsed[rand / 13][rand % 13] = true;
				break;
			}
		}
		System.out.println("---ランダムなカードを一枚引きました。---");
		System.out.println(this.cards[rand / 13][rand % 13]);
		return this.cards[rand / 13][rand % 13];
	}
	
	//未使用カード枚数のカウントメソッド
	private int countNotUsedCard() {
		int notUsedCardCounter = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				if(this.isUsed[i][j] == false) {
					notUsedCardCounter = notUsedCardCounter + 1;
				}
			}
		}
		return notUsedCardCounter;
	}
}
