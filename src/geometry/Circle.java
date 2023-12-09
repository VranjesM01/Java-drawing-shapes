package geometry;

import java.awt.Graphics;

public class Circle extends Shape {

	protected Point center;	
	protected int radius;
	
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		super();
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		super(selected);
		this.center = center;
		this.radius = radius;
	}
	
	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public boolean contains(Point p) {
		return this.center.distance(p) < this.radius;
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(this.center.getX() - this.radius, this.center.getY() - this.radius, 2 * this.radius, 2 * this.radius);
		
		if(this.selected) {
			Point sever= new Point(this.center.getX(),this.center.getY()-this.radius,true);
			sever.draw(g);
			
			Point jug= new Point(this.center.getX(), this.center.getY()+this.radius,true);
			jug.draw(g);
			
			Point zapad= new Point(this.center.getX()-this.radius, this.center.getY(),true);
			zapad.draw(g);
			
			Point istok= new Point(this.center.getX()+this.radius, this.center.getY(),true);
			istok.draw(g);
			
		}
		
	}
	

	@Override
	public String toString() {
		return "Circle [center=" + center + ", radius=" + radius + "]";
	}
}
