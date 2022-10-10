package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        Logger consoleLogger = new ConsoleLogger();


        Logger fileLogger = new FileLogger("logging.txt");
        Predicate<String> condition = message -> message.contains("simulation");
        Logger filteredLogger = new FilteredLogger(fileLogger, condition);
        Logger contextualLogger = new ContextualLogger(name, filteredLogger);

        Logger compositeLogger = new CompositeLogger(contextualLogger, consoleLogger);
        return compositeLogger;
    }
}
