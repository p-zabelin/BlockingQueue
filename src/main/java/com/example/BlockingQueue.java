package com.example;

import java.util.ArrayDeque;

public class BlockingQueue {

    private final int maxSize;

    private ArrayDeque<Integer> deque;

    public BlockingQueue(int maxSize) {
        this.maxSize = maxSize;
        deque = new ArrayDeque(maxSize);
    }

    synchronized void enqueue(Integer item) {
        if (deque.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        deque.add(item);
        notifyAll();
    }

    synchronized Integer dequeue(){
        if (deque.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Integer item = deque.poll();
        notifyAll();
        return item;
    }

    synchronized int size(){
        return deque.size();
    }

}
