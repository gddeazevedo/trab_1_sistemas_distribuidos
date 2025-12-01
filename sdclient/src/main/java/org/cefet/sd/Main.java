package org.cefet.sd;

import org.cefet.sd.tasks.ClientTask;

public class Main {
    static void main() {
        final var clientTask = new ClientTask();
        IO.print("Starting Client...");

        while (true) {
            clientTask.execute();
        }
    }
}
