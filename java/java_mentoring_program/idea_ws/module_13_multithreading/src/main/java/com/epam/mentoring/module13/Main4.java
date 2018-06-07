package com.epam.mentoring.module13;

public class Main4 {
    public static void main(String[] args) throws InterruptedException {
        LightCruiser varyag = new LightCruiser();

        Runnable japanFleet = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println("ERROR in Japan Fleet.");
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                varyag.getShoot();

            }
        };
        Runnable vladivostok = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                if (varyag.getHealth() < 50) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Repairing " + varyag.getHealth());

                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            System.out.println("ERROR in Vladivostok.");
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }

                        varyag.repair();
                    }
                }
            }
        };

        Thread t1 = new Thread(japanFleet);
        Thread t2 = new Thread(vladivostok);

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();
        t2.interrupt();

        t1.join();
        t2.join();
    }
}
