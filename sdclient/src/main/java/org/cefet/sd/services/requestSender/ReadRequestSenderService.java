package org.cefet.sd.services.requestSender;

public class ReadRequestSenderService extends BaseRequestSender {
    @Override
    public void send() {
        try {
            String message = "LER";
            System.out.println("Sending request: " + message);
            this.loadBalancerProvider.sendRequest(message);
        } catch (Exception e) {
            System.out.println("Erro ao enviar leitura: " + e.getMessage());
        }
    }
}
