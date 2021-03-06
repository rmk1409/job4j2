package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Roman on 10.04.2020
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {

        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                boolean exitFlag = false;
                Socket socket = server.accept();
                System.out.println(socket.getPort());
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        if (str.contains("msg=Bye")) {
                            exitFlag = true;
                        }
                        System.out.println(str);
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
                if (exitFlag) {
                    break;
                }
            }
        }
    }
}
