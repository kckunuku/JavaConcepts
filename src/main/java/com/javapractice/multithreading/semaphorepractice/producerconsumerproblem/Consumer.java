package com.javapractice.multithreading.semaphorepractice.producerconsumerproblem;

public class Consumer implements Runnable{
    Thread t;
    String name;
    SharedBuffer sharedBuffer;
    Consumer(String name, SharedBuffer buffer) {
        t = new Thread(this, name);
        this.name = name;
        this.sharedBuffer = buffer;
    }
    @Override
    public void run() {
        for(int i=0; i<20; i++) {
            sharedBuffer.get();
        }
    }
}
