package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import geometry.Circle;
import geometry.Donut;

public class DonutDialog extends JDialog {
	JTextField fieldX;
	JTextField fieldY;
	JTextField fieldR;
	JTextField fieldIr;
	
	public DonutDialog(JTextField fieldX, JTextField fieldY, JTextField fieldR, JTextField fieldIr) {
		this.fieldX=fieldX;
		this.fieldY=fieldY;
		this.fieldR=fieldR;
		this.fieldIr=fieldIr;
	}
	
	
	
	
	public JTextField getFieldX() {
		return fieldX;
	}




	public JTextField getFieldY() {
		return fieldY;
	}




	public JTextField getFieldR() {
		return fieldR;
	}




	public JTextField getFieldIr() {
		return fieldIr;
	}




	public DonutDialog(JFrame parent, Donut donut) {
		super(parent, true);
		setSize(300, 300);
         
        JPanel panel = new JPanel();
         
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
 
        panel.setLayout(boxlayout);
         
        //panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
        
        JPanel panelX = new JPanel();
        panelX.add(new JLabel("X"));
        fieldX = new JTextField();
        fieldX.setText(donut.getCenter().getX() + "");
        fieldX.setPreferredSize(new Dimension(100, 20));
        //fieldX.setEnabled(false);
        panelX.add(fieldX);
        
        JPanel panelY = new JPanel();
        panelY.add(new JLabel("Y"));
        fieldY = new JTextField();
        fieldY.setText(donut.getCenter().getY() + "");
        fieldY.setPreferredSize(new Dimension(100, 20));
        //fieldY.setEnabled(false);
        panelY.add(fieldY);
        
        JPanel panelRadius = new JPanel();
        panelRadius.add(new JLabel("radius: "));
        fieldR = new JTextField();
        fieldR.setPreferredSize(new Dimension(100, 20));
        panelRadius.add(fieldR);
        
        JPanel panelInnerRadius = new JPanel();
        panelInnerRadius.add(new JLabel("inner radius: "));
        fieldIr = new JTextField();
        fieldIr.setPreferredSize(new Dimension(100, 20));
        panelInnerRadius.add(fieldIr);
        
        JPanel paneldDugmad = new JPanel();
        JButton potvrdi = new JButton("Potvrdi");
        JButton odustani = new JButton("Odustani");
        paneldDugmad.add(potvrdi);
        paneldDugmad.add(odustani);
        
        potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				donut.getCenter().setX(Integer.parseInt(fieldX.getText()));
				donut.getCenter().setY(Integer.parseInt(fieldY.getText()));
				donut.setRadius(Integer.parseInt(fieldR.getText()));
				donut.setInnerRadius(Integer.parseInt(fieldIr.getText()));
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
        panel.add(panelRadius);
        panel.add(panelInnerRadius);
        panel.add(paneldDugmad);
      
        
        this.setContentPane(panel);
	}

}
