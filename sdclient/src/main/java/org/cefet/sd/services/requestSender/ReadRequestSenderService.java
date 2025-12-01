package org.cefet.sd.services.requestSender;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ReadRequestSenderService extends BaseRequestSender {
    @Override
    public void send() {
        boolean mustAutoFlush = true;
        
        try {
            var socket            = new Socket(this.loadBalancerIp, this.loadBalancerPort);
            var printWriter       = new PrintWriter(socket.getOutputStream(), mustAutoFlush);
            var inputStreamReader = new InputStreamReader(socket.getInputStream());
            var bufferedReader    = new BufferedReader(inputStreamReader);

            printWriter.println("LEITURA");

            String response = bufferedReader.readLine();
            socket.close();

            IO.println("Leitura recebida: " + response);
        } catch (Exception e) {
            IO.println("Erro ao enviar leitura: " + e.getMessage());
        }
    }
}
