package org.cefet.sd.services.requestSender;


public abstract class BaseRequestSender {
    protected final int loadBalancerPort;
    protected final String loadBalancerIp;

    public BaseRequestSender() {
        this.loadBalancerPort = 5000;
        this.loadBalancerIp   = "0.0.0.0";
    }

    abstract void send();
}
