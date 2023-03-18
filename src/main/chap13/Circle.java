package main.chap13;

public class Circle extends Shape {
	
	private Point center;
	private int radius;
	
	public Circle() {
		this.center = new Point();
		this.radius = 0;
	}
	
	public Circle(int x, int y, int r) {
		this.center = new Point(x, y);
		this.radius = r;
	}

	@Override
	public void draw() {
		System.out.println("[円を描画]中心" + this.center.toString() + "から半径" + this.radius);
	}

	@Override
	public double perimeter() {
		return Math.pow(this.radius, 2) * Math.PI;
	}

}
