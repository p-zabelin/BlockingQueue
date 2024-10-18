package com.example;

public class Producer implements Runnable {

    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }


    @Override
    public void run() {

        for (int i = 1; i < 10; i++) {
            System.out.println("Producer положил" + i);
            queue.enqueue(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
