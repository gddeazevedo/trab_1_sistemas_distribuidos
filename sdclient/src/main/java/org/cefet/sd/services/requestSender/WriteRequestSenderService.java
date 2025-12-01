package org.cefet.sd.services.requestSender;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.net.Socket;
import org.cefet.sd.services.LoggerService;

public class WriteRequestSenderService extends BaseRequestSender {
    private static final int LOWER_BOUND = 2;
    private static final int UPPER_BOUND = 1_000_000;

    private final Random random;
    private final LoggerService loggerService;

    public WriteRequestSenderService() {
        super();
        this.random = new Random();
        this.loggerService = new LoggerService();
    }

    @Override
    public void send() {
        int firstNumber  = random.nextInt(LOWER_BOUND, UPPER_BOUND);
        int secondNumber = random.nextInt(LOWER_BOUND, UPPER_BOUND);

        boolean mustAutoFlush = true;

        loggerService.registerLog(firstNumber, secondNumber);

        try {
            var socket            = new Socket(this.loadBalancerIp, this.loadBalancerPort);
            var printWriter       = new PrintWriter(socket.getOutputStream(), mustAutoFlush);
            var inputStreamReader = new InputStreamReader(socket.getInputStream());
            var bufferedReader    = new BufferedReader(inputStreamReader);

            printWriter.println("ESCRITA|" + firstNumber + "|" + secondNumber); // sends to the server "ESCRITA|firstNumber|secondNumber"

            bufferedReader.readLine(); // client is blocked until the server answers (can be just ack)
            socket.close();

            IO.println("Cliente enviou escrita " + firstNumber + ", " + secondNumber);
        } catch (Exception e) {
            IO.println("Erro ao enviar escrita: " + e.getMessage());
        }
    }
}
