package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        ConsoleLogger consoleLogger = new ConsoleLogger();
        return consoleLogger;
    }
}
