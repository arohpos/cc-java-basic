package main.chap5;

public class Main {

	public static void main(String[] args) {
		//課題1
		int[] arrays1 = {96, 45, 31, 29, 84, 77};
		display(arrays1, false);
		arraysSort(arrays1, true);
		display(arrays1, true);
		arraysSort(arrays1, false);
		display(arrays1, true);
		
		//プログラミング演習
		int x = 5;
		int y = 2;
		System.out.println("足し算の結果は" + sub(x, y));
	}
	
	//第1引数で与えられた配列のi番目とj番目を入れ替える。
	public static void change(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;		
	}
	
	//第1引数で与えられた配列の書く値で指定された順番にソートする。
	//orderType true:昇順、false:降順
	public static void arraysSort(int[] array, boolean orderType) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				if(orderType == true) {
					if(i < j & array[i] > array[j]) {
						change(array, i, j);
					}
				}else {
					if(i < j & array[i] < array[j]) {
						change(array, i, j);
					}
				}
			}
		}
	}
	
	//第1引数で与えられた配列を出力する。
	public static void display(int[] array, boolean isSorted) {
		if(isSorted == true) {
			System.out.println("***並び替え後***");
		}else {
			System.out.println("***並び替え前***");			
		}
		for(int a : array) {
			System.out.print(a + " ");
		}
		System.out.println("");
	}
	
	public static int sub(int x, int y) {
		int retValue = x + y;
		return retValue;
	}
}
