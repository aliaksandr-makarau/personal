package com.epam.mentoring.module13;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LightCruiser {

    private int health = 100;
    private boolean isDamaged = false;
    final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void repair() {
        try {
            lock.readLock().lock();

            if (isDamaged) {
                lock.readLock().unlock();

                lock.writeLock().lock();
                if (isDamaged) {
                    ++health;
                    isDamaged = false;
                }
                lock.writeLock().unlock();
            } else {
                lock.readLock().unlock();
            }
        } finally {
            if (lock.writeLock().isHeldByCurrentThread())
                lock.writeLock().unlock();
            if (lock.getReadHoldCount() > 0)
                lock.readLock().unlock();
        }
    }

    public void getShoot() {
        try {
            lock.writeLock().lock();
            health -= 10;
            isDamaged = true;
        } finally {
            if (lock.writeLock().isHeldByCurrentThread())
                lock.writeLock().unlock();
        }
    }

    public int getHealth() {
        lock.readLock().lock();
        int result = health;
        lock.readLock().unlock();
        return result;
    }
}
