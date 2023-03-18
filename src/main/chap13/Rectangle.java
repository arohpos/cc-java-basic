package main.chap13;

public class Rectangle extends Polygon {
	protected Point p;
	protected int width;
	protected int height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.p = new Point(x, y);
		this.width = width;
		this.height = height;
		this.angle = 4;
	}

	@Override
	public void draw() {
		System.out.println("[長方形を描画]" + this.p.toString() + "を基準として、幅" + this.width + "、高さ" + this.height + "の長方形");
	}

	@Override
	public double perimeter() {
		return (this.width + this.height) * 2;
	}

}
