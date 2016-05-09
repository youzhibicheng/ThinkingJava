package com.corejava7.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	private ServerSocket serverSocket;
	private Socket socket;

	public ServerTest() {
		try {
			serverSocket = new ServerSocket(31313);
			socket = null;
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void start() {

		try {

			System.out.println("Server start...");

			while (true) {

				socket = serverSocket.accept();

				if (socket != null) {

					ObjectInputStream ois = new ObjectInputStream(socket
							.getInputStream());

					Object obj = null;

					while ((obj = ois.readObject()) != null) {
						System.out.println("Context: " + obj.toString());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ServerTest serverTest = new ServerTest();
		serverTest.start();
	}

}
