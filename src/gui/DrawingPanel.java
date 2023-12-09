package gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;



public class DrawingPanel extends JPanel {
	ArrayList<Shape> shapes= new ArrayList<>();

	/**
	 * Create the panel.
	 */
	public DrawingPanel() {
		shapes.add(new Point(100, 100));
		shapes.add(new Line(new Point(200, 200), new Point(400, 400)));
		shapes.add(new Circle(new Point(100, 300), 70));
		shapes.add(new Rectangle(new Point(500,500), 100, 50, true));
		shapes.add(new Donut(new Point(300,100), 80, 40));

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape shape : shapes ) {
			shape.draw(g);
		}
		

	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test");
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawingPanel panel = new DrawingPanel();
		frame.getContentPane().add(panel);
		
		frame.setVisible(true);
	}
	public ArrayList<Shape> getShapes(){
		return shapes;
		
	}
	
	

}