package com.company;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleReaderThread extends Thread{

    Scanner scanner = new Scanner(System.in);
    private BufferedWriter serverWriter;

    public ConsoleReaderThread(BufferedWriter serverWriter){
        this.serverWriter = serverWriter;
    }

    public void run()  {
        while (true) {
            try {
                String input = scanner.nextLine();
                serverWriter.write(input+ "\r\n");
                serverWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
