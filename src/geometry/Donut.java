package geometry;

import java.awt.Graphics;

public class Donut extends Circle {
	
	private int innerRadius;
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		super(center, radius, selected);
		this.innerRadius = innerRadius;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public boolean contains(Point p) {
		return center.distance(p) <= radius && center.distance(p) >= innerRadius;
	}

	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(center.getX() - innerRadius, center.getY() - innerRadius, 2 * innerRadius, 2 * innerRadius);
		
		if(this.selected) {
			//tacke spoljasnjeg radiusa
			Point severD= new Point(this.center.getX(),this.center.getY()-this.radius,true);
			severD.draw(g);
			
			Point jugD= new Point(this.center.getX(), this.center.getY()+this.radius,true);
			jugD.draw(g);
			
			Point zapadD= new Point(this.center.getX()-this.radius, this.center.getY(),true);
			zapadD.draw(g);
			
			Point istokD= new Point(this.center.getX()+this.radius, this.center.getY(),true);
			istokD.draw(g);
			
			//tacke unutrasnjeg radiusa
			Point severU= new Point(this.center.getX(), this.center.getY()-this.innerRadius, true);
			severU.draw(g);
			
			Point jugU= new Point(this.center.getX(), this.center.getY()+this.innerRadius,true);
			jugU.draw(g);
			
			Point zapadU= new Point(this.center.getX()-this.innerRadius, this.center.getY(),true);
			zapadU.draw(g);
			
			Point istokU= new Point(this.center.getX()+this.innerRadius, this.center.getY(),true);
			istokU.draw(g);
			
		}
	}

	@Override
	public String toString() {
		return "Donut [innerRadius=" + innerRadius + ", center=" + center + ", radius=" + radius + "]";
	}
}