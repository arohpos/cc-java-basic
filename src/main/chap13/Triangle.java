package main.chap13;

public class Triangle extends Polygon {
	private Point p1;
	private Point p2;
	private Point p3;
	
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		p1 = new Point(x1, y1);
		p2 = new Point(x2, y2);
		p3 = new Point(x3, y3);
		this.angle = 3;
	}

	@Override
	public void draw() {
		System.out.println("[三角形を描画]" + this.p1.toString() + "から、" + this.p2.toString() + "、" + this.p3.toString() + "の三角形");
	}

	@Override
	public double perimeter() {
		Line line1 = new Line(this.p1.getX(), this.p1.getY(), this.p2.getX(), this.p2.getY());
		Line line2 = new Line(this.p2.getX(), this.p2.getY(), this.p3.getX(), this.p3.getY());
		Line line3 = new Line(this.p3.getX(), this.p3.getY(), this.p1.getX(), this.p1.getY());
		return line1.perimeter() + line2.perimeter() + line3.perimeter();
	}

}
