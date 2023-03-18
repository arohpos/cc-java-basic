package main.chap13;

public class Line implements Figure{
	Point p1;
	Point p2;
	
	public Line() {
		this.p1 = new Point();
		this.p2 = new Point();
	}
	
	public Line(int x1, int y1, int x2, int y2) {
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);		
	}
	
	@Override
	public void draw() {
		System.out.println("[線を描画]始" + this.p1.toString() + "から終" + this.p2.toString() + "まで");
	}
	
	@Override
	public double perimeter() {
		double lenX = this.p1.getX() - this.p2.getX();
		double lenY = this.p1.getY() - this.p2.getY();
		double answer = Math.sqrt(Math.pow(lenX, 2) + Math.pow(lenY, 2));
		return answer;
	}
	
	

}
