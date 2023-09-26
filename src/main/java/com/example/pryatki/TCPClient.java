package com.example.pryatki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient  extends Thread {
    private static final String SERVER_HOST = "192.168.1.14";
    private static final int SERVER_PORT = 19888;

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    private Controller controller;

    public TCPClient(Controller controller) {
        this.controller = controller;
    }


    public void run() {
        try {
            // Создание сокета и установление соединения с сервером
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);

            // Получение потоков ввода/вывода
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Отправка сообщений
            sendMessage("Hello, Server!");

            // Чтение ответов от сервера
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("Server Response: " + response);

                // Обработка ответа от сервера и отправка на большой дисплей
                // ...
                controller.sendtobigdisplay(response);
                // Сброс выходного потока, чтобы убедиться, что данные отправляются
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Закрытие потоков и сокета
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void sendMessage(String message) {
        out.println(message);
    }



}