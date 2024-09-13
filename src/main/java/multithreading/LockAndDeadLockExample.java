package multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*

Locks
The synchronized keyword in Java provides basic thread-safety but has limitations:
 - it locks the entire method or block, leading to potential performance issues.
 - It lacks a try-lock mechanism causing threads to block indefinitely, increasing the risk of deadlocks.
 - Additionally, synchronized doesn't support multiple condition variables,
 offering only a single monitor per object with basic wait/notify mechanisms.
  In contrast, explicit locks (Lock interface) offer finer-grained control,
  try-lock capabilities to avoid blocking, and more sophisticated thread coordination
   through multiple condition variables, making them more flexible and
    powerful for complex concurrency scenarios. */
public class LockAndDeadLockExample {

    int balance = 1000000;
    Lock lock = new ReentrantLock();

    public void withdraw(int amount) {

        try {
            // if(lock.tryLock()) {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        Thread.sleep(5000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }
            }
        } catch (Exception e) {
            System.out.println("Thread waited for specified time but didn't get the lock so marking it interruped ");
            Thread.currentThread().interrupt();
        }
    }
}
