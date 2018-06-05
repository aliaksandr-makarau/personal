package com.epam.mentoring.module13;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStartRule {
    public static void main(String[] args) throws InterruptedException {

        // PART I

        final Runnable lambda = () -> {
            System.out.println("Hi from lambda");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("How are you?");
        };

        Thread t = new Thread(lambda);
        System.out.println("Step 1");
        t.start();
        System.out.println("Step 2");
        Thread.sleep(ThreadLocalRandom.current().nextInt(100));
        System.out.println("Step 3");
        t.join();
        System.out.println("Step 4");

        // PART II

        Lock lock = new ReentrantLock();

        final Runnable lambdaSecond = () -> {
            lock.lock();
            System.out.println("Hi from the second lambda");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("How are you? from the second lambda");
            lock.unlock();
        };

        Thread t2 = new Thread(lambdaSecond);
        System.out.println("Step 2.1");
        t2.start();
        System.out.println("Step 2.2");
        Thread.sleep(ThreadLocalRandom.current().nextInt(100));
        System.out.println("Step 2.3");
        t2.join();
        System.out.println("Step 2.4");

        // PART III

        Lock lockIII = new ReentrantLock();

        final Runnable lambdaIII = () -> {
            lockIII.lock();
            System.out.println("Hi from the third lambda");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("How are you? from the third lambda");
            lockIII.unlock();
        };

        Thread tIII = new Thread(lambdaIII);
        System.out.println("Step 3.1");
        lockIII.lock();
        tIII.start();
        System.out.println("Step 3.2");
        Thread.sleep(ThreadLocalRandom.current().nextInt(100));
        System.out.println("Step 3.3");
        lockIII.unlock();
        tIII.join();
        // lockIII.unlock(); // Deadlock :(
        System.out.println("Step 3.4");

    }
}
