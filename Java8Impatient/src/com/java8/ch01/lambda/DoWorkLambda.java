package com.java8.ch01.lambda;

public class DoWorkLambda {

	public static void main(String[] args) {
		Runnable run = () -> {
			for(int i=0; i<100; i++){
				System.out.println("Do Work Runnable Lambda");
			}
		};
		new Thread(run).start();
	}

}