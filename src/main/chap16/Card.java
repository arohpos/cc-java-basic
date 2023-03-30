package main.chap16;

public class Card implements Comparable<Card>{

	private Suit suit;
	private int number;
	
	
	public Card(Suit suit, int number) {
		this.suit = suit;
		this.number = number;
	}

	protected Suit getSuit() {
		return suit;
	}

	protected void setSuit(Suit suit) {
		this.suit = suit;
	}

	protected int getNumber() {
		return number;
	}

	protected void setNumber(int number) {
		this.number = number;
	}

	@Override
	//オーバーライドするときはアクセス制限を狭めることはできない。
	public String toString() {
		return this.suit.getSuitName() + this.number;
	}
	
	//等価の比較（Stringとintでの等価比較方法の差に注意）
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Card) {
			Card compareeCard = (Card)obj;
			if(this.suit.equals(compareeCard.suit) && this.number == compareeCard.number) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	@Override
	//comparer＞compareeの場合、正の数が出力される。
	public int compareTo(Card compareeCard) {
		if(this.number > compareeCard.number) {
			return 1;
		}else if(this.number < compareeCard.number) {
			return -1;
		}else{
			return this.suit.compareTo(compareeCard.suit);
		}
	}
	

	
}
