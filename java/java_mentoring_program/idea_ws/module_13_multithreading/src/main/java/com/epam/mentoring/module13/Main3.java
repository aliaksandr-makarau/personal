package com.epam.mentoring.module13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main3 {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                lock1.lock();
                ++counter;
                lock1.unlock();
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                lock2.lock();
                --counter;
                lock2.unlock();
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("Counter is " + counter);

        Lock lock = new ReentrantLock();

        counter = 0;

        threadOne = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                lock.lock();
                ++counter;
                lock.unlock();
            }
        });

        threadTwo = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                lock.lock();
                --counter;
                lock.unlock();
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("Counter is " + counter);

    }
}
