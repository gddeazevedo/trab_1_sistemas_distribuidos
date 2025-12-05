package org.cefet.sd.tasks;

import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import org.cefet.sd.services.RequestHandlerService;

public class LoadBalancerTask {
    private final int port;
    private final RequestHandlerService requestHandlerService;

    public LoadBalancerTask(int port, HashMap<String, Integer> servers) {
        this.port = port;
        this.requestHandlerService = new RequestHandlerService(servers);
    }

    public void execute() throws IOException {
        var serverSocket = new ServerSocket(port);
        System.out.println("Load Balancer running at port " + port);
        while (true) {
            Socket request = serverSocket.accept();
            var inputStreamReader = new InputStreamReader(request.getInputStream());
            var bufferedReader = new BufferedReader(inputStreamReader);
            String message = bufferedReader.readLine();
            this.requestHandlerService.handle(message);
            request.close();
        }
    }
}
