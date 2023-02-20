package main.chap10;

public class Grade {
	String name;
	int score;
	
	public Grade(String name, int score) {
		this.name = name;
		this.score = score; 
	}
	
	protected String judge() {
		if(this.score >= 90) {
			return "AA";
		}else if(this.score >= 80) {
			return "A";
		}else if(this.score >= 70) {
			return "B";
		}else if(this.score >= 60) {
			return "C";
		}else {
			return "不可";
		}
	}

}
