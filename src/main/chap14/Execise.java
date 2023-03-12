package main.chap14;

import java.util.Scanner;

public class Execise {

	public static void main(String[] args) {
		//課題1
		
		//本棚クラスをインスタンス化する
		BookShelf bookShelf = new BookShelf(5);
		//本棚の現在の状態の出力する
		System.out.println(bookShelf.toString());
		
		//配列の初期化する
		//TODO:配列の初期化はコンストラクタでするべき？
		for(int i = 0; i < bookShelf.books.length; i++) {
			bookShelf.books[i] = new Book(null, i, null);
		}
		
		//ユーザへの書籍の登録確認継続するべきかどうか
		boolean souldContinueToConfirm = true;
		
		Scanner sc = new Scanner(System.in);
		
		while(souldContinueToConfirm == true) {
			if(bookShelf.registeredBookCounter == 0) {
				System.out.println("新しい書籍を追加しますか？[はい：1/いいえ：0]");				
			}else {
				System.out.println("繰り返し、書籍を追加しますか？[はい：1/いいえ：0]");
			}
			
			//ユーザが書籍追加をしたい場合
			if (sc.nextInt() == 1) {
				
				//本棚に空きスペースがある場合、書籍の登録を行う
				if(bookShelf.registeredBookCounter < bookShelf.maxRegisterableBookNumber) {
					//書籍名の取得
					System.out.println("書籍名を入力してください。>");
					String tmpTitle = sc.next();
					
					//価格の取得
					System.out.println("価格を入力してください。>");
					int tmpPrice = sc.nextInt();
					
					//著者名の取得
					System.out.println("著者名を入力してください。>");
					String tmpAuthor = sc.next();
					
					//登録確認
					System.out.println("署名：" + tmpTitle + "/価格：" + tmpPrice + "/著者名：" + tmpAuthor + "を追加します。");
					
					//追加しようとしている書籍が過去に登録済みでないか重複チェックする
					boolean isDupulicating = false;
					for(int c = 0; c < bookShelf.registeredBookCounter; c++) {
						if(bookShelf.books[c].getTitle().equals(tmpTitle) && bookShelf.books[c].getAuthor().equals(tmpAuthor)) {
							isDupulicating = true;
							break;//1つでも重複があればbreakする（for文を抜ける）
						}
					}
					//重複していれば後続処理をスキップし、次のループステップに入る。
					if(isDupulicating == true) {
						System.out.println("同じ書籍があるので、追加されませんでした。");
						continue;
					}
					
					//登録処理
					bookShelf.books[bookShelf.registeredBookCounter].setTitle(tmpTitle);
					bookShelf.books[bookShelf.registeredBookCounter].setPrice(tmpPrice);
					bookShelf.books[bookShelf.registeredBookCounter].setAuthor(tmpAuthor);
					bookShelf.registeredBookCounter = bookShelf.registeredBookCounter + 1;
					System.out.println("登録に成功しました。");
					
				//本棚に空きスペースがない場合、書籍の登録を行わない。また登録処理の継続を確認しない
				}else {
					System.out.println("本棚に空きスペースがありません");
					souldContinueToConfirm = false;
				}
			//ユーザが書籍追加をしたくない場合
			}else if(sc.nextInt() == 0) {
				System.out.println("追加を行いません");
				//一度0が入力されたら登録処理の継続を確認しない
				souldContinueToConfirm = false;
			}
		}
		
		//登録完了後の本棚の情報を出力する。
		System.out.println(bookShelf.toString());
		sc.close();
	}
}
