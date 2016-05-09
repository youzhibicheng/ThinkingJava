package com.java8.ch01.lambda;

import javax.swing.JFrame;

public class LambdaSuperDemo {
	public static void main(String[] args) {
		for(int i=0; i<100; i++){
			ConcurrentGreeter c = new ConcurrentGreeter();
			c.greet();
		}
	}
}

class Greeter{
	public void greet(){
		System.out.println("Hello World!");
	}
}

class ConcurrentGreeter extends Greeter{
	public void greet(){
		Thread t = new Thread( super::greet );
		t.start();
	}
}