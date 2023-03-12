package main.chap14;

public class BookShelf {
	
	int maxRegisterableBookNumber;//書籍の最大登録可能数
	Book[] books;//本の情報の配列
	int registeredBookCounter;//登録された本の数のカウンタ
	
	//指定された数だけ書籍が登録可能な書棚の作成（コンストラクタ）
	public BookShelf(int maxRegisterableBookNumber) {
		this.maxRegisterableBookNumber = maxRegisterableBookNumber;
		this.books = new Book[maxRegisterableBookNumber];
		this.registeredBookCounter = 0;
	}
	
	@Override
	public String toString() {
		String msg = "現在所有している本一覧\n----------------------------------------\n";
		if(this.registeredBookCounter == 0) {
			msg = msg + "所有している本はありません。\n";
		}else {
			//書棚に登録されている本の数だけループ
			for(int i = 0; i < registeredBookCounter; i++) {
				msg = msg + books[i] + "\n";
			}
		}		
		msg = msg + "----------------------------------------\n";
		return msg;
	}
}
