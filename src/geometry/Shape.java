package geometry;

import java.awt.Graphics;

public abstract class Shape {

	protected boolean selected;

	public abstract void draw(Graphics g);

	public Shape() {
		super();
	}

	public Shape(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelect() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean contains(Point clickPoint) {
		return true;
	}

}
