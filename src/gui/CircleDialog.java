package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import geometry.Rectangle;

public class CircleDialog extends JDialog {
	JTextField fieldX;
    JTextField fieldY;
    JTextField fieldR;
    
    public CircleDialog(JTextField fieldX, JTextField fieldY, JTextField fieldR) {
    	this.fieldX=fieldX;
    	this.fieldY=fieldY;
    	this.fieldR=fieldR;
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




	public CircleDialog(CircleDialogParameter parameterObject) {
		super(parameterObject.parent, true);
		
		
		 
		
		
		setSize(300, 300);
         
        JPanel panel = new JPanel();
        
        
	
        
        
         
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
 
        panel.setLayout(boxlayout);
        
       

    	
        
        
         
        //panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
        
        
        
        JPanel panelX = new JPanel();
        panelX.add(new JLabel("X"));
        fieldX = new JTextField();
        fieldX.setText(parameterObject.circle.getCenter().getX() + "");
        fieldX.setPreferredSize(new Dimension(100, 20));
        //fieldX.setEnabled(false);
        panelX.add(fieldX);
        
        JPanel panelY = new JPanel();
        panelY.add(new JLabel("Y"));
        fieldY = new JTextField();
        fieldY.setText(parameterObject.circle.getCenter().getY() + "");
        fieldY.setPreferredSize(new Dimension(100, 20));
        //fieldY.setEnabled(false);
        panelY.add(fieldY);
        
        JPanel panelRadius = new JPanel();
        panelRadius.add(new JLabel("radius: "));
        fieldR = new JTextField();
        fieldR.setPreferredSize(new Dimension(100, 20));
        panelRadius.add(fieldR);
        
        
        JPanel paneldDugmad = new JPanel();
        JButton potvrdi = new JButton("potvrdi");
        JButton odustani = new JButton("odustani");
        paneldDugmad.add(potvrdi);
        paneldDugmad.add(odustani);
        
        potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parameterObject.circle.getCenter().setX(Integer.parseInt(fieldX.getText()));
				parameterObject.circle.getCenter().setY(Integer.parseInt(fieldY.getText()));
				parameterObject.circle.setRadius(Integer.parseInt(fieldR.getText()));
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
        panel.add(paneldDugmad);
      
        
        this.setContentPane(panel);
        
        
        
        
	}
}
