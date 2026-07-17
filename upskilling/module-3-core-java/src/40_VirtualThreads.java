class VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            int id = i;
            Thread.startVirtualThread(() -> {
                if (id < 5) System.out.println("Virtual thread " + id);
            });
        }
        Thread.sleep(1000);
        System.out.println("Elapsed ms: " + (System.currentTimeMillis() - start));
    }
}

