package com.java8.ch01.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonActionLambda {

	public static void main(String[] args) {
		ActionFrame2 frame = new ActionFrame2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}

}

class ActionFrame2 extends JFrame{
	private JButton button;
	
	public ActionFrame2(){
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
            ActionListener listener = event -> System.out.println("Hello world!");
            button.addActionListener(listener);//添加监听器类，其主要的响应都由监听器类的方法实现

        }
        return button;
    }

}
