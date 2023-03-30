package main.chap16;

public class OwnedChip {
	private int ownedChipNumber;

	public OwnedChip() {
		this.ownedChipNumber = 100;
	}
	

	protected int getOwnedChipNumber() {
		return ownedChipNumber;
	}

	protected void setOwnedChipNumber(int ownedChipNumber) {
		this.ownedChipNumber = ownedChipNumber;
	}
	
	@Override
	public String toString() {		
		return "保有チップ：" + this.ownedChipNumber + "点（[10点チップ]" + this.ownedChipNumber / 10 + "枚、[1点チップ]" + this.ownedChipNumber % 10 + "枚）";
	}

}
