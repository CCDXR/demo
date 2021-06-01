package com.example.demo.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    int len;
                    byte[] data = new byte[1024];
                    try {
                        InputStream inputStream = socket.getInputStream();
                        while((len = inputStream.read(data)) != -1) {
                            System.out.println(new String (data, 0, len));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
