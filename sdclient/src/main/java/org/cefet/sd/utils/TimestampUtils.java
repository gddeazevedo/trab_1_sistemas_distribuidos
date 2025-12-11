package org.cefet.sd.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampUtils {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static String getTimestamp() {
        return LocalDateTime.now().format(FORMATTER);
    }

    public static void log(String message) {
        System.out.println("[" + getTimestamp() + "] " + message);
    }
}
