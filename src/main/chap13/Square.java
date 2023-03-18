package main.chap13;

public class Square extends Rectangle {
	
	public Square(int x, int y, int width) {
		super(x, y, width, width);
	}
	
	@Override
	public void draw() {
		System.out.println("[正方形を描画]" + this.p.toString() + "を基準として、幅" + this.width + "の正方形");
	}

}
