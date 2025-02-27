package task.concurrency.blocking_queue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private final Queue<Integer> queue;
    private final int limit;

    public BlockingQueue(int limit) {
        this.limit = limit;
        this.queue = new LinkedList<>();
    }

    public synchronized void enqueue(int item) throws InterruptedException {
        while (queue.size() == limit) {
            wait();
        }
        queue.add(item);
        System.out.println("Item " + item + " has successfully added to queue!");
        notifyAll();
    }

    public synchronized int dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int item = queue.remove();
        notifyAll();
        System.out.println("Item " + item + " has successfully extracting from queue!");
        return item;
    }

    public synchronized int size() {
        return queue.size();
    }
}
