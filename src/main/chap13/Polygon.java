package main.chap13;

public abstract class Polygon extends Shape {
	
	protected int angle;
	
	@Override
	public abstract void draw();

	@Override
	public abstract double perimeter();
	
	public int getInternalAngle() {
		return (this.angle - 2) * 180;
	}

}
