package com.thinking.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private Socket socket;
    private SendThread sendThread;
    private ObjectOutputStream oos;

    public Client() {

        try {

            InetAddress inetAddress = InetAddress.getLocalHost();
            socket = new Socket("127.0.0.1", 31313, inetAddress, 51515);
            oos = new ObjectOutputStream(socket.getOutputStream());
            sendThread = new SendThread(oos);
            sendThread.start();

        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void send(Serializable message) {
        System.out.println("send message...");
        this.sendThread.setMessage(message);
    }
}
