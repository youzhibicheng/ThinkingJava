package com.thinking.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SendThread extends Thread {

	private ObjectOutputStream oos;
	private Serializable message;

	public SendThread(ObjectOutputStream oos) {
		this.oos = oos;
	}

	public void setMessage(Serializable message) {
		this.message = message;
	}

	public void run() {

		while (true) {
			if (this.message != null) {
				synchronized (this.message) {
					try {
						oos.writeObject(this.message);
						oos.flush();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					} finally {
						this.message = null;
					}
				}
			}
		}
	}
}
