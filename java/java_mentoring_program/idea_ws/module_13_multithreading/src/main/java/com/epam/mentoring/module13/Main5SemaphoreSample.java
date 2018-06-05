package com.epam.mentoring.module13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main5SemaphoreSample {

    public static void main(String[] args) {
        Semaphore writingSemaphore = new Semaphore(1);
        Semaphore readingSemaphore = new Semaphore(10);

        List<Thread> threads = new ArrayList<>();
        List<Object> resource = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread writer = new Thread( () ->  {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting for writing permit.");
                    writingSemaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " has writing permit.");
                    resource.add(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writingSemaphore.release();
                    System.out.println("Good bye from " + Thread.currentThread().getName() + ".");
                }
            });

            writer.setName("Writer #" + i);
            threads.add(writer);
        }

        for (int i = 0; i < 100; i++) {
            Thread reader = new Thread( () -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting for reading permit.");
                    readingSemaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " has reading permit.");
                    System.out.println("Number of elements: " + resource.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readingSemaphore.release();
                    System.out.println("Good bye from " + Thread.currentThread().getName() + ".");
                }
            });

            reader.setName("Reader #" + i);
            threads.add(reader);
        }

        threads.forEach(Thread::start);
        threads.forEach((thread) -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Result: " + resource.size());
    }
}
