package main.chap16;

import java.util.Scanner;

public class BigOrSmall {
	Deck deck;										//BigOrSmallに使用されるカードデッキ
	private int playedTimesCounter;					//１回のBigOrSmall中にBETが繰り返された回数
	OwnedChip ownedChip;							//現在所有しているチップ
	Card alreadyOpenedCard;							//現在すでに場に出されているカード
	private int currentBettedChipNumber;			//現在BETされているチップ数
	private boolean ChooseSmallFlg;					//Smallを選択したかどうか
	Card nowOpenedCard;								//ゲーム中に場に出されるカード
	private boolean winFlg;							//ゲームに勝ったかどうか
	private boolean continueBetFlg = true;			//BETを続けるかどうか
	private boolean continueBigOrSmallFlg = true;	//BigOrSmallゲームをつづけるかどうか
	
	//コンソールからの入力を受け付ける
	Scanner scanner = new Scanner(System.in);
	
	//ゲーム開始準備するコンストラクタ
	public BigOrSmall() {
		//！：コンストラクタ内ではprivate変数にもアクセス可能。
		//TODO:事前に値の定まっていないフィールドは初期化されるべきか。（alreadyOpenedCard、ChooseSmallFlg、nowOpenedCard、winFlg）
		System.out.println("■事前処理");
		this.deck = new Deck();
		this.playedTimesCounter = 0;
		this.ownedChip = new OwnedChip();
		//this.alreadyOpenedCard
		this.currentBettedChipNumber = 0;
		//this.ChooseSmallFlg = false;
		//this.nowOpenedCard
		//this.winFlg = false;
		this.continueBetFlg = true;
		this.continueBigOrSmallFlg = true;
		System.out.println("");
	}
	
	//ゲーム実行メソッド
	public void playBigOrSmall() {

		//BigOrSmallを遊び続ける場合
		while(this.isContinueBigOrSmallFlg()) {
			
			this.alreadyOpenedCard = deck.draw();
			this.playedTimesCounter = this.playedTimesCounter + 1;
			this.showCurrentStatus();
			this.inputBettedChip();
			
			//BETを続ける場合
			while(this.isContinueBetFlg()) {
				this.chooseBigOrSmall();
				this.judge();
				this.caliculataReturnChip();
				//ゲームに勝った場合
				if(isWinFlg() == true) {
					this.setcurrentBettedChipNumber(this.getcurrentBettedChipNumber() * 2);//2倍をかける
					System.out.println("獲得した" + this.getcurrentBettedChipNumber() + "枚でBETを続けますか？");
					System.out.println("0:NO/ 1:YES");
					//TODO:例外処理
					//NOが入力された場合、ゲームを一度やめる
					if(scanner.nextInt() == 0) {
						this.setContinueBetFlg(false);
						break;
						
					//YESが入力された場合、獲得チップを元手にBETを継続する
					}else {
						continue;
					}
					
				//ゲームに負けた場合
				}else {	
					//ゲームを一度やめる
					break;
				}
			}
			
			//現在所有するチップ枚数確認。0件ならば、BigOraSmallを終了する。
			
			//BigOrSmallの継続確認
			System.out.println("現在所有しているチップで、BogOrSmallを遊び直しますか?");
			System.out.println("0:NO/ 1:YES");
			//TODO：例外処理
			if(scanner.nextInt() == 0) {
				this.setContinueBigOrSmallFlg(false);
				break;
			}else {
				//カードをシャッフルする
				this.initializeDeck();
				continue;
			}
		}
		System.out.println("END");
	}
	
	
	//---------------------------------------------------------------------------------------

	//現在所有しているチップと場に出されているカードの状態表示メソッド
	private void showCurrentStatus() {		
		System.out.println("■現在のチップと場に出ているカードの状況");
		//TODO:以下2行の違いはなに？
		//System.out.println(this.ownedChip);
		System.out.println(this.ownedChip.toString());
		System.out.println("現在場に出ているカード:" + this.alreadyOpenedCard);
		System.out.println("");
	}	
	
	//BETするチップ枚数入力受付メソッド
	private void inputBettedChip() {
		System.out.println("■BET枚数確認");
		System.out.println("BETする枚数を半角数字で入力してください。（最低1〜最大20）");
		//TODO：例外処理（半角数字以外が入力されたら。1から20以外が入力されたら、所有チップよりも多かったら）
		this.setcurrentBettedChipNumber(scanner.nextInt());
		System.out.println(this.getcurrentBettedChipNumber() + "枚がBETされました。");
		System.out.println("");
	}
	
	//BigOeSmall選択入力受付メソッド
	private void chooseBigOrSmall() {
		System.out.println("■Big or Small選択");
		System.out.println("[Big or Small]0:Big/1:Small");		
		//TODO：例外処理（半角数字以外が入力されたら0/1以外が入力されたら）
		if(scanner.nextInt() == 1) {
			System.out.println("Smallが選択されました。");			
			this.setChooseSmallFlg(true);
		}else{
			System.out.println("Bigが選択されました。");
			this.setChooseSmallFlg(false);
		}
		System.out.println("");
	}
	
	//結果の判定メソッド
	private void judge() {
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
		//今開かれたカードは次のゲームの比較対象として使用される。
		this.alreadyOpenedCard = this.nowOpenedCard;
		
		if(this.isWinFlg()) {
			System.out.println("You win!!");
		}else {
			System.out.println("You lose...");			
		}
	}
	
	//ゲームの結果に伴うチップの移動計算メソッド
	private void caliculataReturnChip() {
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
	
	//ゲームの初期化メソッド
	private void initializeDeck() {
		this.deck.reset();
		this.setPlayedTimesCounter(0);
	}
	
	//---------------------------------------------------------------------------------------
	
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
