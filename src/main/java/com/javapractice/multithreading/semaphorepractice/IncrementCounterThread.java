package com.javapractice.multithreading.semaphorepractice;

import java.util.concurrent.Semaphore;

public class IncrementCounterThread implements Runnable{
    Semaphore semaphore;
    String name;
    Thread t;
    public IncrementCounterThread(Semaphore sem, String name) {
        this.semaphore = sem;
        this.name = name;
        t = new Thread(this, name);
    }
    @Override
    public void run() {
        System.out.println("Thread Name : " + this.name + " Acquiring a permit from semaphore to access a shared resource.");
        try {
            semaphore.acquire(); // acquiring a permit
            for(int i=0; i<5; i++) {
                System.out.println("Thread : "+ this.name +" Incrementing count.");
                SharedResource.count++;
                System.out.println("Count : " + SharedResource.count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Thread : " + this.name + " Releasing the permit back to the Semaphore.");
            semaphore.release();
        }
    }
}
