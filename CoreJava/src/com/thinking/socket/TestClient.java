package com.thinking.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestClient {
	public static void main(String[] args) throws Exception{
		Socket so = new Socket("127.0.0.1",7456);
		InputStream is = so.getInputStream();
		OutputStream os = so.getOutputStream();
		BufferedReader br = //客户从server的输入流
		new BufferedReader(new InputStreamReader(is));
		PrintStream ps = new PrintStream(os);
		InputStreamReader isr = 
			new InputStreamReader(System.in);
		BufferedReader key = //从键盘的输入流
			new BufferedReader(isr);
		while(true){
		    String temp = key.readLine();
		    ps.println(temp);//因为server用的是readline,必须用println
		    System.out.println(br.readLine());
		    if(temp.equals("bye")){
		    	Thread.sleep(1000);//为了把bye更好的发送
		    	break;
		    }
		}
		key.close();//java 包名.类名
		ps.close();
		br.close();
		so.close();
	}

}
