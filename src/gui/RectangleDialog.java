package gui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;

public class RectangleDialog extends JDialog{
	
	JTextField fieldX;
	JTextField fieldY;
	JTextField fieldW;
	JTextField fieldH;
	
	public RectangleDialog(JTextField fieldX, JTextField fieldY, JTextField fieldW, JTextField fieldH) {
		this.fieldX=fieldX;
		this.fieldY=fieldY;
		this.fieldW=fieldW;
		this.fieldH=fieldH;
	}
	
	
	
	public JTextField getFieldX() {
		return fieldX;
	}

	public JTextField getFieldY() {
		return fieldY;
	}

	public JTextField getFieldW() {
		return fieldW;
	}

	public JTextField getFieldH() {
		return fieldH;
	}



	private Rectangle rectangle;
	
	public RectangleDialog(JFrame parent, Rectangle rectangle) {
		super(parent, true);
		setSize(300, 300);
         
        JPanel panel = new JPanel();
         
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
 
        panel.setLayout(boxlayout);
         
        //panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
        
        JPanel panelX = new JPanel();
        panelX.add(new JLabel("X"));
        fieldX = new JTextField();
        fieldX.setText(rectangle.getUpperLeft().getX() + "");
        fieldX.setPreferredSize(new Dimension(100, 20));
        //fieldX.setEnabled(false);
        panelX.add(fieldX);
        
        JPanel panelY = new JPanel();
        panelY.add(new JLabel("Y"));
        fieldY = new JTextField();
        fieldY.setText(rectangle.getUpperLeft().getY() + "");
        fieldY.setPreferredSize(new Dimension(100, 20));
        //fieldY.setEnabled(false);
        panelY.add(fieldY);
        
        JPanel panelWidth = new JPanel();
        panelWidth.add(new JLabel("Width "));
        fieldW = new JTextField();
        fieldW.setPreferredSize(new Dimension(100, 20));
        panelWidth.add(fieldW);
        
        JPanel panelH = new JPanel();
        panelH.add(new JLabel("Heigth "));
        fieldH = new JTextField();
        fieldH.setPreferredSize(new Dimension(100, 20));
        panelH.add(fieldH);
        
        JPanel paneldDugmad = new JPanel();
        JButton potvrdi = new JButton("Potvrdi");
        JButton odustani = new JButton("Odustani");
        paneldDugmad.add(potvrdi);
        paneldDugmad.add(odustani);
        
        potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rectangle.getUpperLeft().setX(Integer.parseInt(fieldX.getText()));
				rectangle.getUpperLeft().setY(Integer.parseInt(fieldY.getText()));
				rectangle.setWidth(Integer.parseInt(fieldW.getText()));
				rectangle.setHeight(Integer.parseInt(fieldH.getText()));
				dispose();
				
			}
		});
        
        odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        
        
         

         
        panel.add(panelX);
        panel.add(panelY);
        panel.add(panelWidth);
        panel.add(panelH);
        panel.add(paneldDugmad);
        
        this.setContentPane(panel);
         
	}
}
