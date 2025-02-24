package task.module_3;

public class BlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new BlockingQueue(2);
        // Потоки для извлечения
        Thread consumer1 = new Thread(() -> {
            try {
                queue.dequeue();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer 1 was interrupted!");
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                queue.dequeue();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer 2 was interrupted!");
            }
        });
        // Потоки для добавления
        Thread producer1 = new Thread(() -> {
            try {
                queue.enqueue(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer 1 was interrupted!");
            }
        });

        Thread producer2 = new Thread(() -> {
            try {
                queue.enqueue(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer 2 was interrupted!");
            }
        });

        Thread producer3 = new Thread(() -> {
            try {
                queue.enqueue(8);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer 3 was interrupted!");
            }
        });

        consumer1.start();
        consumer2.start();
        producer1.start();
        producer2.start();
        producer3.start();

        try {
            consumer1.join();
            consumer2.join();
            producer1.join();
            producer2.join();
            producer3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}