package main.chap16;

import java.util.Scanner;

public class BigOrSmall {
	Deck deck;
	private int playedTimesCounter;
	OwnedChip ownedChip;
	Card alreadyOpenedCard;//現在のカード（すでに場に出されているカード）
	private int currentBettedChipNumber;
	private boolean ChooseSmallFlg = false;//Smallを選択したかどうか
	Card nowOpenedCard;//これから開かれるカード
	private boolean winFlg = false;//ゲームに勝ったかどうか
	private boolean continueBetFlg = true;//BETを続けるかどうか
	private boolean continueBigOrSmallFlg = true;//ゲームをつづけるかどうか
	
	
	
	Scanner scanner = new Scanner(System.in);
	
	//ゲーム開始準備するコンストラクタ
	public BigOrSmall() {
		System.out.println("■事前処理");
		this.deck = new Deck();
		this.ownedChip = new OwnedChip();
		this.currentBettedChipNumber = 0;
		//this.nowOpenedCardは初期化されるべきか。
		this.playedTimesCounter = 0;
		System.out.println("");
	}
	
	//現在のチップとカードの状態表示
	public void showCurrentStatus() {		
		System.out.println("■現在のチップと場に出ているカードの状況");
		//TODO:以下2行の違いはなに？
//		System.out.println(this.ownedChip);
		System.out.println(this.ownedChip.toString());
		System.out.println("現在場に出ているカード:" + this.alreadyOpenedCard);
		System.out.println("");
	}
	
	//ゲーム実行関数
	public void playBigOrSmall() {

		//BigOrSmallを遊び続けるかどうか
		while(this.isContinueBigOrSmallFlg()) {
			
			this.alreadyOpenedCard = deck.draw();
			this.playedTimesCounter = this.playedTimesCounter + 1;
			this.showCurrentStatus();
			this.inputBettedChip();
			
			while(this.isContinueBetFlg()) {
				this.chooseBigOrSmall();
				this.judge();
				this.caliculataReturnChip();
				if(isWinFlg() == true) {
					this.setcurrentBettedChipNumber(this.getcurrentBettedChipNumber() * 2);//2倍をかける
					System.out.println("獲得した" + this.getcurrentBettedChipNumber() + "枚でBETを続けますか？");
					System.out.println("0:NO/ 1:YES");
					if(scanner.nextInt() == 0) {
						this.setContinueBetFlg(false);
						break;
					}else {
						continue;
					}
				}else {
					break;
				}
			}
			System.out.println("continue to play?");
			System.out.println("0:NO/ 1:YES");
			if(scanner.nextInt() == 0) {
				this.setContinueBigOrSmallFlg(false);
				break;
			}else {
				//初期化関数をここにいれる。
				
				continue;//このときの初期化
			}
		}
		System.out.println("END");
	}
	
	//初期化
	public void initializeDeck() {
		this.deck.reset();
		this.setPlayedTimesCounter(0);
		
	}
	
	
	
	//BET枚数入力
	public void inputBettedChip() {
		System.out.println("■BET枚数確認");
		System.out.println("BETする枚数を半角数字で入力してください。（最低1〜最大20）");
		//TODO：例外処理（半角数字以外が入力されたら。）
		this.setcurrentBettedChipNumber(scanner.nextInt());
		System.out.println(this.getcurrentBettedChipNumber() + "枚がBETされました。");
		System.out.println("");
	}
	
	//BigOeSmall選択
	public void chooseBigOrSmall() {
		System.out.println("■Big or Small選択");
		System.out.println("[Big or Small]0:Big/1:Small");
		if(scanner.nextInt() == 1) {
			System.out.println("Smallが選択されました。");			
			this.setChooseSmallFlg(true);
		}else{
			System.out.println("Bigが選択されました。");
			this.setChooseSmallFlg(false);
		}
		System.out.println("");
	}
	
	//結果の判定
	public void judge() {
		this.nowOpenedCard = deck.draw();
		System.out.println(nowOpenedCard.toString() + "が引かれました");
		if(nowOpenedCard.compareTo(alreadyOpenedCard) > 0) {
			System.out.println("BIGでした");
			if(this.isChooseSmallFlg() == true) {
				this.setWinFlg(false);
			}else {
				this.setWinFlg(true);
			}
		}else {
			System.out.println("SMALLでした");
			if(this.isChooseSmallFlg() == true) {
				this.setWinFlg(true);
			}else {
				this.setWinFlg(false);
			}
		}
		
		this.alreadyOpenedCard = this.nowOpenedCard;
		
		if(this.isWinFlg()) {
			System.out.println("you win");
		}else {
			System.out.println("you lose");			
		}
	}
	
	public void caliculataReturnChip() {
		if(this.isWinFlg()) {
			System.out.println("チップを" + this.getcurrentBettedChipNumber() * 2 + "枚獲得しました。");
			this.ownedChip.setOwnedChipNumber(this.ownedChip.getOwnedChipNumber() + this.getcurrentBettedChipNumber() * 2);
		}else {
			System.out.println("チップを" + this.getcurrentBettedChipNumber() + "枚失いました。");
			this.ownedChip.setOwnedChipNumber(this.ownedChip.getOwnedChipNumber() - this.getcurrentBettedChipNumber());			
		}
		System.out.println("");
		this.showCurrentStatus();
	}
	
	
	
	
	
	//getter and setter
	protected int getcurrentBettedChipNumber() {
		return currentBettedChipNumber;
	}
	protected void setcurrentBettedChipNumber(int currentBettedChipNumber) {
		this.currentBettedChipNumber = currentBettedChipNumber;
	}
	
	protected int getPlayedTimesCounter() {
		return playedTimesCounter;
	}
	protected void setPlayedTimesCounter(int playedTimesCounter) {
		this.playedTimesCounter = playedTimesCounter;
	}

	protected boolean isChooseSmallFlg() {
		return ChooseSmallFlg;
	}
	protected void setChooseSmallFlg(boolean chooseSmallFlg) {
		ChooseSmallFlg = chooseSmallFlg;
	}

	protected boolean isWinFlg() {
		return winFlg;
	}
	protected void setWinFlg(boolean winFlg) {
		this.winFlg = winFlg;
	}

	protected boolean isContinueBetFlg() {
		return continueBetFlg;
	}
	protected void setContinueBetFlg(boolean continueBetFlg) {
		this.continueBetFlg = continueBetFlg;
	}

	protected boolean isContinueBigOrSmallFlg() {
		return continueBigOrSmallFlg;
	}
	protected void setContinueBigOrSmallFlg(boolean continueBigOrSmallFlg) {
		this.continueBigOrSmallFlg = continueBigOrSmallFlg;
	}
	
	
}
