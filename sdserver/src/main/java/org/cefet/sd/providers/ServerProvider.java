package org.cefet.sd.providers;

import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServerProvider {

    public String send(String message, String host, int port) throws IOException {
        boolean autoFlush = true;

        try (Socket socket = new Socket(host, port);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), autoFlush);
             InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            printWriter.println(message);

            String response = bufferedReader.readLine();
            return response != null ? response : "";
        }
    }
}
