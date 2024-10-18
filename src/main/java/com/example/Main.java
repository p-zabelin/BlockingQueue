package com.example;


public class Main {
    public static void main(String[] args) {

        BlockingQueue blockingQueue = new BlockingQueue(5);

        Thread producer = new Thread(new Producer(blockingQueue));
        Thread consumer = new Thread(new Consumer(blockingQueue));

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}