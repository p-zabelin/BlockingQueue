package com.example;

public class Consumer implements Runnable {

    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 1; i < 10; i++) {
            int item = queue.dequeue();
            System.out.println("Consumer забрал: " + item);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
