import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ExecutorServiceCallable {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> tasks = List.of(() -> 10, () -> 20, () -> 30);
        List<Future<Integer>> futures = new ArrayList<>();
        for (Callable<Integer> task : tasks) futures.add(service.submit(task));
        for (Future<Integer> future : futures) System.out.println(future.get());
        service.shutdown();
    }
}

