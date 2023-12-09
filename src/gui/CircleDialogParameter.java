package gui;

import javax.swing.JFrame;

import geometry.Circle;

public class CircleDialogParameter {
	public JFrame parent;
	public Circle circle;

	public CircleDialogParameter(JFrame parent, Circle circle) {
		this.parent = parent;
		this.circle = circle;
	}
}