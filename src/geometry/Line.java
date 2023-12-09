package geometry;

import java.awt.Graphics;

public class Line extends Shape {
	
	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		super(selected);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public double length() {
		return startPoint.distance(endPoint);
	}


	public boolean contains(Point p) {
		return this.startPoint.distance(p) + this.endPoint.distance(p)-this.length() < 5;
	}
	
	public void draw(Graphics g) {		
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(), 
				this.endPoint.getX(), this.endPoint.getY());
		
		if(this.selected) {
			this.startPoint.setSelected(true);
			this.startPoint.draw(g);
			
			this.endPoint.setSelected(true);
			this.endPoint.draw(g);
		}
	}

	@Override
	public String toString() {
		return "Line [startPoint=" + startPoint + ", endPoint=" + endPoint + "]";
	}
	

}