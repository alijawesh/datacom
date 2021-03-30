package com.company;

import com.company.ConsoleReaderThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String argv[]) {

        try {

            Socket socketClient = new Socket("localhost", 5555);
            System.out.println("Client: " + "Connection Established");

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            String serverMsg;

            //writer.write("8\r\n");
            //writer.write("10\r\n");
            //writer.flush();

            ConsoleReaderThread thread = new ConsoleReaderThread(writer);
            thread.start();

            while ((serverMsg = reader.readLine()) != null) {
                System.out.println("Server: " + serverMsg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}