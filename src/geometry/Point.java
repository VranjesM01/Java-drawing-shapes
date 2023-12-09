package geometry;

import java.awt.Graphics;

import javax.swing.JTextField;

public class Point extends Shape {

	private int x;
	private int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		super(selected);
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	

	public double distance(Point p) {
		int dx = this.x - p.x;
		int dy = this.y - p.y;		
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	public boolean contains(Point p) {
		return this.distance(p) < 5;
	}

	public void draw(Graphics g) {
		g.drawLine(x, y, x, y);
		
		if(this.selected) {
			g.drawRect(this.x-3, this.y-3, 6, 6);
		}
	}
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	
	
    
    

}
