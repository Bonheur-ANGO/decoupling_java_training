package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        FileLogger logger = new FileLogger("logging.txt");
        Logger contextualLogger = new ContextualLogger(name, logger);
        Logger consoleLogger = new ConsoleLogger();
        CompositeLogger compositeLogger = new CompositeLogger(contextualLogger, consoleLogger);
        return compositeLogger;
    }
}
