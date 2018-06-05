package com.epam.mentoring.module13;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Java Mentoring Program - Multithreading");
        System.out.println("\nPart I - Thread API\n");

        Thread thread = new Thread() {
            @Override
            public void run() {
                Thread myThread = new MyThread();
                myThread.start();
                // myThread.run();

                Thread myThreadRunnable = new MyThread(new MyRunnable());
                myThreadRunnable.start();

                Thread myRunnableThread = new MyRunnableThread(new MyRunnable());
                myRunnableThread.start();

                Thread myThreadLambda = new MyRunnableThread(
                        () -> System.out.println("Lambda Thread is running in "
                                + Thread.currentThread().getName() + " "
                                + Thread.currentThread().getState()));
                myThreadLambda.start();

                System.out.println("Thread is running in " + getName() + " "
                        + Thread.currentThread().getState());
            }
        };

        System.out.println("Thread state is " + thread.getState());
        System.out.println("Current main thread is "
                + Thread.currentThread().getName() + " "
                + Thread.currentThread().getState());
        System.out.println("Before a thread start");
        thread.start();
        // thread.start(); // IllegalThreadStateException in case to start one thread twice
//        Thread.sleep(1000);
        System.out.println("After the thread start");

        for (int i = 0; i < 100; i++) {
            Thread threadI = new Thread(" " + i) {
                public void run() {
                    System.out.println("Thread " + getName() + " is running");
                }
            };
            // threadI.setPriority(ThreadLocalRandom.current().nextInt(10));
            threadI.start();
        }

        Thread.sleep(1000);

        // Thread states:
        // New - after an object of Thread class creation
        // Runnable - ready to execute after calling method start
        // Running - after a scheduler gets processor time to a thread
        // Sleeping - after calling the method Thread.sleep()
        // Waiting - after calling the method lock.wait()
        // Blocking - if a monitor for further execution is not available
        // Dead - when the method run() completes

        System.out.println("\nPart II - Race condition\n");

        Main mainObj = new Main();

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                ++(mainObj.counter);
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                --(mainObj.counter);
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("Counter is " + mainObj.counter);
        System.out.println();

        Main mainObjTwo = new Main();

        threadOne = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (mainObjTwo) {
                    ++(mainObjTwo.counter);
                }
            }
        });

        threadTwo = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (mainObjTwo) {
                    --(mainObjTwo.counter);
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("Counter is " + mainObjTwo.counter);

        System.out.println("\nPart III - Deadlock\n");

        String resourceOne = "Resource One";
        String resourceTwo = "Resource Two";

        threadOne = new Thread(() -> {
            synchronized (resourceOne) {
                System.out.println("Resource One is locked in " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);

                    synchronized (resourceTwo) {
                        System.out.println("Resource Two is locked in " + Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadTwo = new Thread(() -> {
            synchronized (resourceTwo) {
                System.out.println("Resource Two is locked in " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);

                    synchronized (resourceOne) {
                        System.out.println("Resource One is locked in " + Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadOne.start();
        // threadTwo.start(); // Deadlock

        threadOne.join();
        // threadTwo.join();
    }
}

class MyThread extends Thread {

    public MyThread() {

    }

    public MyThread(Runnable r) {
        super(r);
    }

    @Override
    public void run() {
        System.out.println("MyThread is running in " + getName() + " "
                + Thread.currentThread().getState());
    }
}

class MyRunnableThread extends Thread {
    public MyRunnableThread(Runnable r) {
        super(r);
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable is running in "
                + Thread.currentThread().getName() + " "
                + Thread.currentThread().getState());
    }
}