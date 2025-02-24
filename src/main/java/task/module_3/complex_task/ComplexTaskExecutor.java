package task.module_3.complex_task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexTaskExecutor {
    private final int numberOfTasks;
    private final CyclicBarrier barrier;
    private final Map<Integer, Long> results;

    public ComplexTaskExecutor(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
        this.barrier = new CyclicBarrier(numberOfTasks, this::mergeResults);
        this.results = new ConcurrentHashMap<>();
    }

    public void executeTasks(int numberOfTasks) {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfTasks);

        for (int i = 0; i < numberOfTasks; i++) {
            ComplexTask task = new ComplexTask(i);
            executorService.submit(() -> {
                long result = task.execute();
                results.put(task.getTaskId(), result);
                try {
                    barrier.await();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executorService.shutdown();
    }

    private void mergeResults() {
        System.out.println("All tasks are completed. Merging results...");

        long totalSum = 0;
        for (long result : results.values()) {
            totalSum += result;
        }
        System.out.println("Total sum of all tasks: " + totalSum);
    }
}