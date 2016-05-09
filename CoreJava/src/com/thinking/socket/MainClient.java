package com.thinking.socket;

public class MainClient {

    public static void main(String[] args) {

        Client client = new Client();

        for (int i = 0; i < 5; i++) {
            
            client.send(new TestBean());

//            try {
//                client.send(new TestBean());
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
