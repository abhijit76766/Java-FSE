class MessageTask implements Runnable {
    private final String message;
    MessageTask(String message) { this.message = message; }
    public void run() {
        for (int i = 1; i <= 5; i++) System.out.println(message + " " + i);
    }
}

class ThreadCreation {
    public static void main(String[] args) {
        new Thread(new MessageTask("Thread A")).start();
        new Thread(new MessageTask("Thread B")).start();
    }
}

