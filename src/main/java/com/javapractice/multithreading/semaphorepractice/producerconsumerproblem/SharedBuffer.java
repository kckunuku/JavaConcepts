package com.javapractice.multithreading.semaphorepractice.producerconsumerproblem;

import java.util.concurrent.Semaphore;

// shared buffer that can only store one item at a time
public class SharedBuffer {
    int n;
    Semaphore producerPermit;
    Semaphore consumerPermit;

    SharedBuffer(Semaphore producerPermit, Semaphore consumerPermit) {
        this.producerPermit = producerPermit;
        this.consumerPermit = consumerPermit;
    }

    // put an item in the buffer
    public void put(int n) {
        System.out.println(Thread.currentThread().getName() + " Thread waiting to acquire producer permit");
        try {
            producerPermit.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " thread acquired producer permit");
        System.out.println("This means there are not permits left in the producer permit");
        this.n = n;
        System.out.println("Buffer Item : " + n);
        System.out.println("Attempting to fill consumer permit with 1 permit for the item producer put in the buffer");
        consumerPermit.release();
    }

    // Get an item from the buffer
    public void get() {
        System.out.println(Thread.currentThread().getName() + " Thread waiting to acquire consumer permit");
        try {
            consumerPermit.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " thread acquired consumer permit");
        System.out.println("This means there are no more consumer permits left to give out.");
        System.out.println(Thread.currentThread().getName() + " thread consumed item " + n + " in the buffer");
        System.out.println(Thread.currentThread().getName() + " is attempting to fill the producer permits with a permit");
        producerPermit.release();
    }
}
