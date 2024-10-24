package com.javapractice.multithreading.semaphorepractice;

import java.util.concurrent.Semaphore;

/**
 * Main class to demonstrate the use of the synchronizer class Semaphore to access a shared resource by multiple
 * threads.
 *
 * The intention of this is for the increment counter thread to acquire the permit from the semaphore first
 * and increment the shared resource counter five times before releasing the permit.
 *
 * Then the decrement counter will acquire the permit and decrement the counter five times to bring it back to its
 * initial value.
 *
 * One key concept that this code is trying to demonstrate is that: when a permit is acquired by a thread
 * for a shared resource from a semaphore and is suspended the other thread will keep waiting until this thread
 * releases the permit after it finishes with the shared resource.
 */
public class SemaphorePracticeMain {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        IncrementCounterThread incThread = new IncrementCounterThread(semaphore, "A");
        DecrementCounterThread decThread = new DecrementCounterThread(semaphore, "B");
        incThread.t.start();
        try {
            // Added this to suspend the main thread so that it won't get to spawn the decrement thread before
            // the increment thread gets to acquire a permit from the semaphore.
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        decThread.t.start();
    }
}
