package com.epam.mentoring.module13;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main7Schedulers {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.schedule(() -> System.out.println("Ping google.com"), 2, TimeUnit.SECONDS);

        pool.scheduleAtFixedRate(() -> System.out.println("Ping yandex.ru"), 0, 2,
                TimeUnit.SECONDS);

        pool.scheduleWithFixedDelay(() -> System.out.println("Ping amazon.com"), 3, 2,
                TimeUnit.SECONDS);

        try {
            pool.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.shutdownNow();
        }
    }
}
