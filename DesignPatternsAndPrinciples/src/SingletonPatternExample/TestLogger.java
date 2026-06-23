package SingletonPatternExample;

public class TestLogger {
    public static void main(String[] args) {

        System.out.println("Starting application...");

        // First logger instance
        Logger logger1 = Logger.getInstance();
        logger1.log("First log entry.");

        // Second logger instance
        Logger logger2 = Logger.getInstance();
        logger2.log("Second log entry.");

        // TEST: Let's verify that logger1 and logger2 are the EXACT same object in memory
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both variables point to the exact same Logger instance!");
        } else {
            System.out.println("FAIL: We have multiple instances.");
        }

    }
}
