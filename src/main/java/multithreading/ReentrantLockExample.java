package multithreading;

/*
A Reentrant Lock in Java is a type of lock that allows a thread to acquire the same lock multiple times without causing a deadlock.
If a thread already holds the lock, it can re-enter the lock without being blocked.
This is useful when a thread needs to repeatedly enter synchronized blocks or methods within the same execution flow.
The ReentrantLock class from the java.util.concurrent.locks package provides this functionality, offering more flexibility
than the synchronized keyword, including try-locking, timed locking, and multiple condition variables for advanced thread coordination.
*/

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class ReentrantLockExample {

    private final Lock lock = new ReentrantLock();
    public static int counter = 0;


    public void slider(int roundCount) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " - Slider() Execution Start");
            Thread.sleep(3000);
            innerSlider();                // here by calling inner and inner is also having a lock can create the deadlock but ReentrantLock resolve this issue.
            System.out.println(Thread.currentThread().getName() + " - Slider() Execution End");
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " Exception Occur:- " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " - Slider() lock release");
            lock.unlock();
        }

    }

    private void innerSlider() {
        try {
            lock.lock();     // here you are again putting lock on thread that is coming from it's caller
            System.out.println(Thread.currentThread().getName() + " - InnerSlider() Execution Start");
            System.out.println(Thread.currentThread().getName() + " - InnerSlider() Execution End");
        } finally {
            System.out.println(Thread.currentThread().getName() + " - InnerSlider() lock release");
            lock.unlock(); //  here also you the relesing lock. but this will not release a lock  from slider() instead it will release only from innderSlider()
        }

    }

    // --------------Faireness Example -----------------
    Lock fairnessLock = new ReentrantLock(true);

    public void accessResource() {
        fairnessLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            fairnessLock.unlock();
        }
    }

    // ------------------ ReadWriteLock -----------------------

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public void increment() {
        writeLock.lock();
        try {
            counter++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount(){
        readLock.lock();
        try {
            return counter;
        } finally {
            readLock.unlock();
        }
    }


}
