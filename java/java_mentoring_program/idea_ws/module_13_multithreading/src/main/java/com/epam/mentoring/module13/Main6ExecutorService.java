package com.epam.mentoring.module13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main6ExecutorService {
    public static void main(String[] args) {
        ExecutorService execService = Executors.newSingleThreadExecutor();

        Runnable task1 = () -> {
            System.out.println("Hello from task 1 " + Thread.currentThread().getName());
        };

        Runnable task2 = () -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from task 2 " + Thread.currentThread().getName());
        };

        execService.submit(task1);
        execService.submit(task2);

        try {
            execService.shutdown();
            execService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            execService.shutdownNow();
        }

        System.out.println("Hello from main " + Thread.currentThread().getName());
    }
}
