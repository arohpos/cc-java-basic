package main.chap16;

import java.util.Random;

//今回のカードデッキはスート4種、各13枚、ジョーカーなしの固定でOK（ここの拡張性は不要）
public class Deck {
	
	//Suit型（列挙）の配列
	Suit[] suits = Suit.values();
	
	//Remark：配列の枠をnewしているだけで、配列の要素はnewしていないため、コンストラクタないでnewが必要となる。
	Card[][] cards = new Card[4][13];
	boolean isNotUsed[][] = new boolean[4][13];
	
	//コンストラクタ
	public Deck() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				this.cards[i][j] = new Card(suits[i], j + 1);
				this.isNotUsed[i][j] = true;
			}
		}
		System.out.println("---カードデッキを準備しました。---");
	}
	
	//未使用カードの枚数をカウントする
	public int countNotUsedCard() {
		int notUsedCardCounter = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				if(this.isNotUsed[i][j] == true) {
					notUsedCardCounter = notUsedCardCounter + 1;
				}
			}
		}
		return notUsedCardCounter;
	}
	
	//カードデッキの使用状況を初期化する
	public void reset() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				this.isNotUsed[i][j] = true;
			}
		}
		System.out.println("---デッキをシャッフルし直しました。---");
	}
	
	//ランダムな未使用のカードを一枚引くまでループする
	public Card draw() {
		Random random = new Random();
		int rand;
		while(true) {
			rand = random.nextInt(52);
			if(isNotUsed[rand / 13][rand % 13] == true) {
				isNotUsed[rand / 13][rand % 13] = false;
				break;
			}
		}
		//System.out.println(this.cards[rand / 13][rand % 13]);
		System.out.println("---ランダムなカードを一枚引きました。---");
		return this.cards[rand / 13][rand % 13];
	}
}
