package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class DrawingFrame extends JFrame {
	private JPanel contentPane;
	private JToggleButton tglSelect;
	private JToggleButton tglPoint;
	private JToggleButton tglLine;
	private JToggleButton tglRectangle;
	private JToggleButton tglCircle;
	private JToggleButton tglDonut;
	private JButton btnDelete;
	DrawingPanel drawingPanel;

	private Line newLine;
	private Rectangle newRectangle;
	private Circle newCircle;
	private Donut newDonut;
	private Shape selectedShape;
	private JButton btnModify;
	private Shape selected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrame frame = new DrawingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.newLine = null;
		this.newRectangle = null;

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		drawingPanel = new DrawingPanel();

		drawingPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				onDrawingPanelClicked(e);
			}
		});
		contentPane.add(drawingPanel, BorderLayout.CENTER);

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		tglSelect = new JToggleButton("Select");
		toolBar.add(tglSelect);

		tglPoint = new JToggleButton("Point");
		toolBar.add(tglPoint);

		tglLine = new JToggleButton("Line");
		toolBar.add(tglLine);

		tglRectangle = new JToggleButton("Rectangle");
		toolBar.add(tglRectangle);

		tglCircle = new JToggleButton("Circle");
		toolBar.add(tglCircle);

		tglDonut = new JToggleButton("Donut");
		toolBar.add(tglDonut);
		
		btnDelete = new JButton("delete");
		toolBar.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.shapes.remove(selectedShape);
				selectedShape = null;
				drawingPanel.repaint();
			}
		});

		ButtonGroup group = new ButtonGroup();
		group.add(tglSelect);
		group.add(tglPoint);
		group.add(tglLine);
		group.add(tglRectangle);
		group.add(tglCircle);
		group.add(tglDonut);
		
		btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnModifyAcionPerformed();
			}
		});
		toolBar.add(btnModify);
		
	}
		
		

	protected void btnModifyAcionPerformed() {
		// TODO Auto-generated method stub
		Iterator<Shape> it= this.drawingPanel.getShapes().iterator();
		while(it.hasNext()) {
			Shape shape= it.next();
			if(shape.isSelect()) {
				if(shape instanceof Point) {
					
					
				}else if(shape instanceof Line) {
					
				}else if(shape instanceof Rectangle) {
					Rectangle rectangle= (Rectangle) shape;
					
					RectangleDialog dialog= new RectangleDialog(this, rectangle);
					
					int ULX= rectangle.getUpperLeft().getX();
					String strULX= String.valueOf(ULX);
					dialog.getFieldX().setText(strULX);
					
					int ULY= rectangle.getUpperLeft().getY();
					String strULY= String.valueOf(ULY);
					dialog.getFieldY().setText(strULY);
					
					int width= rectangle.getWidth();
					String strWidth= String.valueOf(width);
					dialog.getFieldW().setText(strWidth);
					
					int heigth= rectangle.getHeight();
					String strHeight=String.valueOf(heigth);
					dialog.getFieldH().setText(strHeight);
					
					dialog.setVisible(true);
					
					
					
					
				}else if(shape instanceof Donut) {
					Donut donut= (Donut) shape;
					
					DonutDialog dialog= new DonutDialog(this, donut);
					
					int centerX= donut.getCenter().getX();
					String strCenterX= String.valueOf(centerX);
					dialog.getFieldX().setText(strCenterX);
					
					int centerY= donut.getCenter().getY();
					String strCenterY= String.valueOf(centerY);
					dialog.getFieldY().setText(strCenterY);
					
					int radius= donut.getRadius();
					String strRadius= String.valueOf(radius);
					dialog.getFieldR().setText(strRadius);
					
					int innerRadius= donut.getInnerRadius();
					String strInnerRadius= String.valueOf(innerRadius);
					dialog.getFieldIr().setText(strInnerRadius);
					
					dialog.setVisible(true);
					
				}else if(shape instanceof Circle) {
					Circle circle= (Circle)shape;
					
					CircleDialog dialog= new CircleDialog(new CircleDialogParameter(this, circle));
					
					int centerX= circle.getCenter().getX();
					String strCenterX= String.valueOf(centerX);
					dialog.getFieldX().setText(strCenterX);
					
					int centerY= circle.getCenter().getY();
					String strCenterY= String.valueOf(centerY);
					dialog.getFieldY().setText(strCenterY);
					
					int radius= circle.getRadius();
					String strRadius=String.valueOf(radius);
					dialog.getFieldR().setText(strRadius);
					
					dialog.setVisible(true);
					
					
					
				    
					
					
				}
					
				}
			}
		repaint();
		}
		
	

	protected void onDrawingPanelClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Point clickedPoint = new Point(e.getX(), e.getY());

		if (this.tglSelect.isSelected()) {
			Iterator<Shape> it = this.drawingPanel.getShapes().iterator();
			while (it.hasNext()) {
				Shape shapes = it.next();
				if (shapes.contains(clickedPoint)) {
					shapes.setSelected(true);
					selectedShape = shapes;
					System.out.println("selektovano");
				} else {
					shapes.setSelected(false);
				}
			}
		} else if (this.tglPoint.isSelected()) {
			drawingPanel.shapes.add(clickedPoint);
		} else if (this.tglLine.isSelected()) {
			if (newLine == null) {
				newLine = new Line(clickedPoint, null);
			} else {
				newLine.setEndPoint(clickedPoint);
				drawingPanel.shapes.add(newLine);
				newLine = null;
			}
		} else if (this.tglRectangle.isSelected()) {
			if (newRectangle == null) {
				newRectangle = new Rectangle(clickedPoint, -1, -1);
				RectangleDialog dialog = new RectangleDialog(this, newRectangle);
				dialog.setVisible(true);
				if (newRectangle.getWidth() != -1) {
					drawingPanel.shapes.add(newRectangle);
				}
				newRectangle = null;

			}
		} else if (this.tglCircle.isSelected()) {
			if (newCircle == null) {
				newCircle = new Circle(clickedPoint, -1);
				CircleDialog dialog = new CircleDialog(new CircleDialogParameter(this, newCircle));
				dialog.setVisible(true);
				if (newCircle.getRadius() != -1) {
					drawingPanel.shapes.add(newCircle);
				}
				newCircle = null;
			}
		} 
		else if (this.tglDonut.isSelected()) {
			if (newDonut == null) {
				newDonut = new Donut(clickedPoint, -1, -1);
				DonutDialog dialog = new DonutDialog(this, newDonut);
				dialog.setVisible(true);
				if (newDonut.getRadius() != -1) {
					drawingPanel.shapes.add(newDonut);
				}
				newDonut = null;
			}
		}

		drawingPanel.repaint();

	}

}
