package main.chap3;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//課題1
		System.out.println("----------");
		System.out.println("課題1（偶奇判定）開始");
		
		//サイコロの目の設定
		int dicePip;
		Random rand1 = new Random();
		dicePip = rand1.nextInt(6) + 1;
		System.out.println("サイコロの目は" + dicePip + "です。");
		
		//サイコロの目の偶奇判定
		if(dicePip % 2 == 0) {
			System.out.println("サイコロの目は偶数です。");
		}else {
			System.out.println("サイコロの目は奇数です。");
		}
		
		
		//課題2
		System.out.println("----------");
		System.out.println("課題2（じゃんけん）開始");
		
		//ユーザのじゃんけんの手
		//TODO: Scannerを閉じる（課題全て）
		int userHand;
		System.out.println("あなたの手を入力してください（0:グー、１：チョキ、２：パー）。");
		Scanner sc2 = new Scanner(System.in);
		userHand = sc2.nextInt();
		System.out.println("入力された数値は" + userHand + "です。");

		//コンピュータのじゃんけんの手
		Random rand2 = new Random();
		int conputerHand = rand2.nextInt(3);
		System.out.println("あなたの手：" + userHand);
		System.out.println("コンピュータの手：" + conputerHand);
		
		//じゃんけん結果判定
		switch(conputerHand) {
			case 0:
				switch(userHand) {
					case 0:
						System.out.println("結果：draw");
						break;
					case 1:
						System.out.println("結果：lose");
						break;
					case 2:
						System.out.println("結果：win");
						break;
				}
				break;
			case 1:
				switch(userHand) {
					case 0:
						System.out.println("結果：win!");
						break;
					case 1:
						System.out.println("結果：draw-");
						break;
					case 2:
						System.out.println("結果：lose.");
						break;
				}	
				break;
			case 2:
				switch(userHand) {
					case 0:
						System.out.println("結果：lose..");
						break;
					case 1:
						System.out.println("結果：win!!");
						break;
					case 2:
						System.out.println("結果：draw--");
						break;
				}	
				break;
		}
		
		
		//課題3
		System.out.println("----------");
		System.out.println("課題3（FizzBuzz）開始");
		
		//TODO: 表示回数の命名について検討
		int total;
		System.out.println("FizzBuzzの試行回数を指定してください。");
		Scanner sc3 = new Scanner(System.in);
		total = sc3.nextInt();
		
		//FizzBuzz判定
		for(int i = 1; i <= total; i++) {
			if(i % 15 == 0) {
				System.out.println("FizzBuzz");
			}else if (i % 3 == 0){
				System.out.println("Fizz");				
			}else if (i % 5 == 0){
				System.out.println("Buzz");								
			}else {
				System.out.println(i);												
			}
		}
		
		
		//課題4
		System.out.println("----------");
		System.out.println("課題4（コイントス）開始");
		
		//試行回数の入力
		//TODO; 試行回数の命名について検討
		int trialCount;
		System.out.println("コイントスの試行回数を指定してください。");
		Scanner sc4 = new Scanner(System.in);
		trialCount = sc4.nextInt();
		System.out.println("入力された数値は" + trialCount + "です。");
		
		//コインの表がでる回数の計測
		int coinHeadCount = 0;
		Random rand4 = new Random();
		for(int i = 1; i <= trialCount; i++) {
			//1:表、0:裏
			if(rand4.nextInt(2) == 1) {
				coinHeadCount = coinHeadCount + 1;
			}
		}
		System.out.println("コイントス" + trialCount + "回の結果");
		System.out.println("表が出た回数：" + coinHeadCount + "回、裏が出た回数" + (trialCount - coinHeadCount) + "回");
	}
}
