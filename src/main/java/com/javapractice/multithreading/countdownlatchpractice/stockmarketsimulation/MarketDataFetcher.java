package com.javapractice.multithreading.countdownlatchpractice.stockmarketsimulation;

import java.util.concurrent.CountDownLatch;

public class MarketDataFetcher implements Runnable{
    // String to just simulate a datasource connection.
    String dataSource;
    CountDownLatch latch;
    Thread t;

    MarketDataFetcher(String dataSource, CountDownLatch latch, String name) {
        t = new Thread(this, name);
        this.dataSource = dataSource;
        this.latch = latch;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Fetching data..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ": Done fetching done..");
        latch.countDown();
    }
}
