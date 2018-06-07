package com.epam.mentoring.module13;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class VariableHolder {
    private int variable = 0;

    private static Object obj = new Object();

    public synchronized int getVariable() {
            System.out.println("VariableHolder::getVariable() START");
            System.out.println("VariableHolder::getVariable() END");
            return variable;
    }

    public void setVariable(int variable) {
        synchronized (this) {

            System.out.println("VariableHolder::setVariable() START");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("VariableHolder::setVariable() END");

            this.variable = variable;
        }
    }
}

class VariableReader implements Runnable {

    private VariableHolder holder;

    VariableReader(VariableHolder h) {
        holder = h;
    }

    @Override
    public void run() {
        System.out.println(holder.getVariable());
    }
}

class VariableWriter implements Runnable {
    private VariableHolder holder;

    VariableWriter(VariableHolder h) {
        holder = h;
    }

    @Override
    public void run() {
        holder.setVariable(13);
    }
}

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

        // PART IV
        VariableHolder holder = new VariableHolder();

        Thread t1IV = new Thread(new VariableReader(holder));
        Thread t2IV = new Thread(new VariableWriter(holder));

        t2IV.start();
        t1IV.start();

        t2IV.join();
        t1IV.join();
    }
}
