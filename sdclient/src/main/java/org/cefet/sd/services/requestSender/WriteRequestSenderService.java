package org.cefet.sd.services.requestSender;

import java.util.Random;
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

        loggerService.registerLog(firstNumber, secondNumber);

        try {
            this.loadBalancerProvider.sendRequest("ESCRITA|" + firstNumber + "|" + secondNumber);
            IO.println("Cliente enviou escrita " + firstNumber + ", " + secondNumber);
        } catch (Exception e) {
            IO.println("Erro ao enviar escrita: " + e.getMessage());
        }
    }
}
