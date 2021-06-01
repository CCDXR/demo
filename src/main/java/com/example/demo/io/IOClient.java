package com.example.demo.io;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class IOClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1234);
            while (true) {
                socket.getOutputStream().write((new Date()+" io测试").getBytes());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
