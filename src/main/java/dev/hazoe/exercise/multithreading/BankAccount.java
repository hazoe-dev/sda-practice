package dev.hazoe.exercise.multithreading;

import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance = 1000;
    private final ReentrantLock lock = new ReentrantLock(true);


    public void withdraw(double amount) {
        if (balance >= amount) {
            // simulate processing time
            try { Thread.sleep(10); } catch (InterruptedException e) {}
            balance -= amount;
        }
    }

    public synchronized void withdrawSafely(double amount) {
        if (balance >= amount) {
            // simulate processing time
            try { Thread.sleep(10); } catch (InterruptedException e) {}
            balance -= amount;
        }
    }

    public void withdrawWithLock(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                // simulate processing time
                try { Thread.sleep(10); } catch (InterruptedException e) {}
                balance -= amount;
            }
        } finally {
            lock.unlock();
        }

    }

    public double getBalance() { return balance; }
}