package main.chap16;

import java.util.InputMismatchException;
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

		//BigOrSmallを遊び続ける場合の処理
		while(this.isContinueBigOrSmallFlg()) {			
			this.continueBetFlg = true;
			this.alreadyOpenedCard = deck.draw();
			this.playedTimesCounter = this.playedTimesCounter + 1;
			this.showCurrentStatus();
			this.inputBettedChip();
			
			//BETを続ける場合の処理
			while(this.isContinueBetFlg()) {
				this.chooseBigOrSmall();
				this.judge();
				this.caliculataReturnChip();
				
				//ゲームに勝った場合
				if(isWinFlg() == true) {
					this.setcurrentBettedChipNumber(this.getcurrentBettedChipNumber() * 2);//2倍をかける
					System.out.println("獲得した" + this.getcurrentBettedChipNumber() + "枚でBETを続けますか？");

					//入力チェック（半角数字であること、0か1であること）
					while(true) {			
						try {				
							System.out.println("0:NO/ 1:YES");
							int input = scanner.nextInt();
							
							//入力エラーがある場合
							if(input != 0 && input != 1) {
								throw new IllegalArgumentException("!！0/1以外の値が入力されています!！");	
							
							//入力エラーがない場合
							}else {
								//NOが入力された場合、ゲームを一度やめる
								if(input == 0) {
									this.setContinueBetFlg(false);		
									//YESが入力された場合、獲得チップを元手にBETを継続する
								}else {
									this.setContinueBetFlg(true);
								}
								break;//入力チェックを元に再入力を促すループから抜ける。
							}
							
						} catch (InputMismatchException e) {
							System.out.println("!！半角数字以外が入力されています!！");
							scanner.next();//入力バッファのクリア
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
					}
					
					//入力をもとにBETを継続するか分岐
					if(this.isContinueBetFlg() == false) {
						break;
					}else {
						continue;
					}
					
				//ゲームに負けた場合
				}else {	
					//ゲームを一度やめる
					this.setContinueBetFlg(false);
				}
				break;
			}
			
			//現在所有するチップ枚数確認。0件ならば、BigOraSmallを終了する。
			if(this.ownedChip.getOwnedChipNumber() == 0) {
				System.out.println("チップを所有していないため、BigOrSmallを終了します。");
				break;	
			}
			
			//BigOrSmallの継続確認
			System.out.println("現在所有しているチップで、BigOrSmallを遊び直しますか?");
			
			//入力チェック（半角数字であること、0か1であること）
			while(true) {			
				try {				
					System.out.println("0:NO/ 1:YES");
					int input = scanner.nextInt();
					
					//入力エラーがある場合
					if(input != 0 && input != 1) {
						throw new IllegalArgumentException("!！0/1以外の値が入力されています!！");			
						
					//入力エラーがない場合
					}else {
						if(input == 0) {
							this.setContinueBigOrSmallFlg(false);
						}else {
							this.setContinueBigOrSmallFlg(true);
						}
						break;//入力チェックを元に再入力を促すループから抜ける。
					}
					
				} catch (InputMismatchException e) {
					System.out.println("!！半角数字以外が入力されています!！");
					scanner.next();//入力バッファのクリア
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
			
			//0:NOが入力された場合、ゲームをやめる。
			if(this.isContinueBigOrSmallFlg() == false) {
				break;
			//1:YESが入力された場合、ゲームを初めからやり直す。
			}else {
				//カードをシャッフルする。
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
		System.out.println(this.ownedChip);
		System.out.println("現在場に出ているカード:" + this.alreadyOpenedCard);
		System.out.println("");
	}	
	
	//BETするチップ枚数入力受付メソッド
	private void inputBettedChip() {
		System.out.println("■BET枚数確認");
		//入力チェック（半角数字であること、1から20であること、所有するチップ数を超えないこと）
		while(true) {			
			try {				
				System.out.println("BETする枚数を半角数字で入力してください。（最低1〜最大20）");
				int input = scanner.nextInt();
				
				//入力エラーがある場合
				if(input < 1) {
					throw new IllegalArgumentException("!！BETされたチップ数がBET可能チップ数の下限値を下回っています!！");
				}else if(input > 20) {
					throw new IllegalArgumentException("!！BETされたチップ数がBET可能チップ数の上限値を上回っています!！");
				}else if(input > this.ownedChip.getOwnedChipNumber()){
					throw new IllegalArgumentException("!！BETされたチップ数が所有するチップ数を超えています!！");	
					
				//入力エラーがない場合
				}else {
					this.setcurrentBettedChipNumber(input);					
					break;//入力チェックを元に再入力を促すループから抜ける。
				}
				
			} catch (InputMismatchException e) {
				System.out.println("!！半角数字以外が入力されています!！");
				scanner.next();//入力バッファのクリア
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				//scanner.next();//TODO:なぜかこのエラーの場合入力バッファのクリアは不要。
			}
		}
		System.out.println(this.getcurrentBettedChipNumber() + "枚がBETされました。");
		System.out.println("");
	}
	
	//BigOeSmall選択入力受付メソッド
	private void chooseBigOrSmall() {
		System.out.println("■Big or Small選択");
		//入力チェック（半角数字であること、0か1であること）
		while(true) {			
			try {				
				System.out.println("[Big or Small]0:Big/1:Small");		
				int input = scanner.nextInt();
				
				//入力エラーがある場合
				if(input != 0 && input != 1) {
					throw new IllegalArgumentException("!！0/1以外の値が入力されています!！");		
					
				//入力エラーがない場合
				}else {
					if(input == 1) {
						System.out.println("Smallが選択されました。");			
						this.setChooseSmallFlg(true);
					}else{
						System.out.println("Bigが選択されました。");
						this.setChooseSmallFlg(false);
					}
					break;//入力チェックを元に再入力を促すループから抜ける。
				}
				
			} catch (InputMismatchException e) {
				System.out.println("!！半角数字以外が入力されています!！");
				scanner.next();//入力バッファのクリア
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
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
