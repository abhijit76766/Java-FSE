public class Main {
    public static void main(String[] args) {
        Logger firstLogger = Logger.getInstance();
        Logger secondLogger = Logger.getInstance();

        firstLogger.log("Application started");
        secondLogger.log("Application running");

        if (firstLogger == secondLogger) {
            System.out.println("Both references point to the same Logger instance.");
        } else {
            System.out.println("Different Logger instances were created.");
        }
    }
}

