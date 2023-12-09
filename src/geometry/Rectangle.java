package geometry;

import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeft;
	private int width;
	private int height;
	
	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;		
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		super(selected);
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;		
	}
	
	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int area() {
		return this.width * this.height;
	}
	
	public boolean contains(Point p) {
		return  p.getX() > this.upperLeft.getX() && p.getX()< this.upperLeft.getX()+width && p.getY() > this.upperLeft.getY() && p.getY()< this.upperLeft.getY()+height;
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(this.upperLeft.getX(), this.upperLeft.getY(), this.width, this.height);
		
		if(this.selected) {
			this.upperLeft.setSelected(true);
			
			this.upperLeft.draw(g);
			
			Point upperRight= new Point(this.upperLeft.getX()+this.width,this.upperLeft.getY(),true);
			upperRight.draw(g);
			
			Point lowerLeft= new Point(this.upperLeft.getX(), this.upperLeft.getY()+height,true);
			lowerLeft.draw(g);
			
			Point lowerRight= new Point(this.upperLeft.getX()+width, this.upperLeft.getY()+height,true);
			lowerRight.draw(g);
		}
	}
	

	@Override
	public String toString() {
		return "Rectangle [upperLeft=" + upperLeft + ", width=" + width + ", height=" + height + "]";
	}
	

}
