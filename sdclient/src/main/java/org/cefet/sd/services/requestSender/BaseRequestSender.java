package org.cefet.sd.services.requestSender;

import org.cefet.sd.providers.LoadBalancerProvider;

public abstract class BaseRequestSender {
    protected final LoadBalancerProvider loadBalancerProvider;

    public BaseRequestSender() {
        this.loadBalancerProvider = new LoadBalancerProvider();
    }

    public abstract void send();
}
