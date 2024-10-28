package com.javapractice.multithreading.countdownlatchpractice.stockmarketsimulation;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchStockMarketApplication {
    public static void main(String[] args) {
        // Let's say we have to fetch data from three different sources.
        CountDownLatch countDownLatch = new CountDownLatch(3);

        // Three threads representing three different services fetching data from three different sources
        MarketDataFetcher s3fetcher = new MarketDataFetcher("s3bucket", countDownLatch, "s3fetcher");
        MarketDataFetcher azurefetcher = new MarketDataFetcher("azure", countDownLatch, "azurefetcher");
        MarketDataFetcher onpremfetcher = new MarketDataFetcher("Onpremise", countDownLatch, "onpremfetcher");

        s3fetcher.t.start();
        azurefetcher.t.start();
        onpremfetcher.t.start();

        System.out.println("Main Service waiting for the data fetching services to finish execution");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Data fetching services finished execution. Aggregating the data");
    }
}
