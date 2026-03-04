package dev.hazoe.exercise.multithreading;

public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== WITHOUT SYNC (Race Condition) ===");
        runDemo(account -> account.withdraw(300));

        System.out.println("=== WITH SYNCHRONIZED ===");
        runDemo(account -> account.withdrawSafely(300));

        System.out.println("=== WITH REENTRANT LOCK ===");
        runDemo(account -> account.withdrawWithLock(300));
    }

    static void runDemo(java.util.function.Consumer<BankAccount> action)
            throws InterruptedException {
        BankAccount account = new BankAccount();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> action.accept(account));
            threads[i].start();
        }
        for (int i = 0; i < 5; i++) threads[i].join();

        System.out.println("Final balance: " + account.getBalance());
        // Đúng: 100.0 (1000 - 3*300, vì rút 300*5=1500 > 1000)
        // Race condition: có thể âm hoặc sai
    }
}
