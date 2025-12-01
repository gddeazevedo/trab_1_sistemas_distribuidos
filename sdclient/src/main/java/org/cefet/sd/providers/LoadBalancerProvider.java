package org.cefet.sd.providers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LoadBalancerProvider {
    protected final int loadBalancerPort;
    protected final String loadBalancerIp;

    public LoadBalancerProvider() {
        this.loadBalancerPort = 5000;
        this.loadBalancerIp   = "0.0.0.0";
    }

    public String sendRequest(String message) throws IOException {
        boolean mustAutoFlush = true;
        var socket            = new Socket(this.loadBalancerIp, this.loadBalancerPort);
        var printWriter       = new PrintWriter(socket.getOutputStream(), mustAutoFlush);
        var inputStreamReader = new InputStreamReader(socket.getInputStream());
        var bufferedReader    = new BufferedReader(inputStreamReader);

        printWriter.println(message); // sends message to the server

        String response = bufferedReader.readLine(); // client is blocked until the server answers (can be just ack)
        socket.close();

        return response;
    }
}

