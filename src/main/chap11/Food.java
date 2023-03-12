package main.chap11;

public class Food extends Product{
	String bestBefore;
	
	protected Food(String name, int price, String bestBefore) {
		super(name, price);
		this.bestBefore = bestBefore;
	}

	protected String getBestBefore() {
		return bestBefore;
	}

	protected void setBestBefore(String bestBefore) {
		this.bestBefore = bestBefore;
	}
	
	@Override
	public String toString() {
		return super.toString() + "、賞味期限は" + this.bestBefore + "です。";
	}
	
}
