package main.chap10;

public class Main {

	public static void main(String[] args) {
		//課題1
		Chip chip = new Chip(100);		
		System.out.println(chip.getNum());
		
		chip.change(10);
		System.out.println(chip.getNum());
		
		//課題2
		Grade grade1 = new Grade("伊藤", 60);
		Grade grade2 = new Grade("鈴木", 88);
		Grade grade3 = new Grade("佐藤", 40);
		Grade grade4 = new Grade("中山", 74);
		Grade grade5 = new Grade("池田", 95);
		Grade grade6 = new Grade("池山", 80);
		
		System.out.println(grade1.name + ":" + grade1.judge());
		System.out.println(grade2.name + ":" + grade2.judge());
		System.out.println(grade3.name + ":" + grade3.judge());
		System.out.println(grade4.name + ":" + grade4.judge());
		System.out.println(grade5.name + ":" + grade5.judge());
		System.out.println(grade6.name + ":" + grade6.judge());

	}

}
