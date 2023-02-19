package main.chap4;

public class Main {

	public static void main(String[] args) {
		//課題
		int[][] scores = {{59, 39, 100, 2, 15, 40, 84, 97}, {63, 18, 64, 97, 50, 98}};
		int sum = 0;
		int count = 0;
		for(int[] score : scores) {
			for(int s : score) {
				sum = sum + s;
				if(s != 0) {
					count = count + 1;
				}
			}
		}
		System.out.println("scores内の要素数の平均値は、" + sum / count);
		
		//プログラミング演習
		int[][] week_sales = new int[3][7];
		week_sales[0][0] = 1000;
		week_sales[0][1] = 1500;
		week_sales[0][2] = 1300;
		week_sales[0][3] = 1700;
		week_sales[0][4] = 1800;
		week_sales[0][5] = 1900;
		week_sales[0][6] = 2000;
		System.out.println(week_sales[0][4]);
	}

}

