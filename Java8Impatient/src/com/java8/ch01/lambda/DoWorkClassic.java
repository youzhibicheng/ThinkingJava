package com.java8.ch01.lambda;

public class DoWorkClassic {

	public static void main(String[] args) {
		Worker w = new Worker();
		new Thread(w).start();
	}

}

class Worker implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<100; i++){
			doWork();
		}
	}
	
	public void doWork(){
		System.out.println("Do Work Runnable");
	}
}