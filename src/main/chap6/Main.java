package main.chap6;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		//課題1Cal
		String[] fruit = {"apple", "orange", "peach", "grape", "melon", "pineapple"};
		System.out.println(Arrays.toString(fruit));
		//昇順に並び替え
		Arrays.sort(fruit);
		System.out.println(Arrays.toString(fruit));
		Arrays.sort(fruit, Comparator.reverseOrder());
		System.out.println(Arrays.toString(fruit));
	}
}