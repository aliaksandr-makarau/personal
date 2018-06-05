package com.epam.mentoring.module13;

import java.util.concurrent.atomic.AtomicInteger;

public class Main8Atomic {
    static AtomicInteger counter = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread( () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incrementAndGet();
            }
        });

        Thread t2 = new Thread( () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.decrementAndGet();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter " + counter);
    }
}
