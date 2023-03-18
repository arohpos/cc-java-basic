package main.chap15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("整数値を1桁入力してください");
		Scanner sc = new Scanner(System.in);
		
		try {
			//InputMismatchExceptionはここで発生しうる。
			int num = sc.nextInt();
			
			//同じ例外クラスであるが、これらは同時には発生しないため生成されるインスタンスは異なる。
			//したがってcatchブロック内でe.getMessage()してもメッセージ内容はかき分けられる。
			if(num < 0) {
				throw new IllegalArgumentException("入力されたデータが下限値を超えています。");
			}else if(num >9){
				throw new IllegalArgumentException("入力されたデータが上限値を超えています。");				
			}else {
				System.out.println("ただしい数値データ" + num + "が入力されました。");				
			}
		} catch (InputMismatchException e) {
			System.out.println("半角数字1桁を入力してください");
		}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
