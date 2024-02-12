package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
            String host = "127.0.0.1";
            int port = 8088;
            try (Socket clientSocket = new Socket(host, port);
                 PrintWriter out = new
                         PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new
                         InputStreamReader(clientSocket.getInputStream()))) {
                out.println("GET / HTTP/1.1\n" +
                        "Host: 127.0.0.1\n\n\n");
                String resp = in.readLine();
                System.out.println(resp);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
