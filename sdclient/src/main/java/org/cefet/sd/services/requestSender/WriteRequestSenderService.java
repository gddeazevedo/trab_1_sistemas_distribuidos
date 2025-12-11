package org.cefet.sd.services.requestSender;

import java.util.Random;
import org.cefet.sd.services.LoggerService;
import org.cefet.sd.utils.TimestampUtils;

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
        String message = "ESCREVER|" + firstNumber + "|" + secondNumber;

        TimestampUtils.log("Sending request: " + message);

        loggerService.registerLog(firstNumber, secondNumber);

        try {
            this.loadBalancerProvider.sendRequest(message);
            TimestampUtils.log("Cliente enviou escrita " + firstNumber + ", " + secondNumber);
        } catch (Exception e) {
            TimestampUtils.log("Erro ao enviar escrita: " + e.getMessage());
        }
    }
}
