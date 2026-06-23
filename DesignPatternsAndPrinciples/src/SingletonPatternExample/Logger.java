package SingletonPatternExample;

public class Logger {

    // 1. Private static instance of itself (hidden from the outside)
    private static Logger instance;

    // 2. Private constructor (prevents anyone else from saying 'new Logger()')
    private Logger() {
        System.out.println("Logger initialized.");
    }

    // 3. Public static method to get the instance
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
