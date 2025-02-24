package task.module_3.complex_task;

public class ComplexTask {
    private final int taskId;

    public ComplexTask(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public long execute() {
        System.out.println(Thread.currentThread().getName() + " is executing task " + taskId);
        // Вычисление суммы ряда чисел от 1 до N
        int N = (int) (Math.random() * 1000000) + 1;
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(Thread.currentThread().getName() + " completed task " + taskId + ". Sum from 1 to " + N + " is " + sum);
        return sum;
    }

}
