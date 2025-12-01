package org.cefet.sd.services.requestSender;

public class ReadRequestSenderService extends BaseRequestSender {
    @Override
    public void send() {
        try {
            String response = this.loadBalancerProvider.sendRequest("LEITURA");
            IO.println("Leitura recebida: " + response);
        } catch (Exception e) {
            IO.println("Erro ao enviar leitura: " + e.getMessage());
        }
    }
}
