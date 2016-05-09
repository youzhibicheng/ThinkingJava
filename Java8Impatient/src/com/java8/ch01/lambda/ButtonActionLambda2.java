package com.java8.ch01.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonActionLambda2 {

	public static void main(String[] args) {
		ActionFrame3 frame = new ActionFrame3();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}

}

class ActionFrame3 extends JFrame{
	private JButton button;
	
	public ActionFrame3(){
        super();
        this.setSize(300,500);
        this.add( getButton() );
	}
	
    private JButton getButton(){
        if(button==null){
            button = new JButton();
            button.setBounds(103,110,71,27);
            button.setText("OK");
            button.setToolTipText("OK");
            button.addActionListener( event -> System.out.println(event) );
            //instance::instance_method	-> this demo
            //class::static_method
            //class::instance_method
            button.addActionListener( System.out::println );
        }
        return button;
    }

}
