package com.javapractice.multithreading.semaphorepractice.producerconsumerproblem;

import java.util.concurrent.Semaphore;

public class ProducerConsumerMain {
    public static void main(String[] args) {
        Semaphore producerPermit = new Semaphore(1, true);
        Semaphore consumerPermit = new Semaphore(0, true);
        SharedBuffer buffer = new SharedBuffer(producerPermit, consumerPermit);
        new Producer("producer", buffer).t.start();
        new Consumer("consumer", buffer).t.start();
    }
}
