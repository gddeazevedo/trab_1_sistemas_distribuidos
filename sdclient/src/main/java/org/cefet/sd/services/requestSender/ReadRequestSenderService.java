package org.cefet.sd.services.requestSender;

import org.cefet.sd.utils.TimestampUtils;

public class ReadRequestSenderService extends BaseRequestSender {
    @Override
    public void send() {
        try {
            String message = "LER";
            TimestampUtils.log("Sending request: " + message);
            this.loadBalancerProvider.sendRequest(message);
        } catch (Exception e) {
            TimestampUtils.log("Erro ao enviar leitura: " + e.getMessage());
        }
    }
}
