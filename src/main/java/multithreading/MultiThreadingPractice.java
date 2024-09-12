package multithreading;

import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class MultiThreadingPractice {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread - 01");
        Thread thread = new Thread();
        thread.start();
        thread.join();;
        System.out.println("First Way To Create Thread");

        Runnable run = () -> System.out.println("Second Way To Create Thread :- using defined Runnable Interface run()");
        Thread thread1 = new Thread(run);
        thread1.start();
        thread1.join();;

        Thread thread2 = new Thread(() -> System.out.println("Third Way To Create Thread :- define the run() using lambda a a Thread parameter while creating Thread"));
        thread2.start();
        thread2.join();

        // Different way to implement Runnable and Call Thread-
        // getThread();
        System.out.println(" -----------------unSynchronizedExample--------------------------");
        unSynchronizedExample();

        System.out.println(" -----------------synchronizedExample--------------------------");
        synchronizedExample();

        System.out.println(" -----------------Lock Example--------------------------");
        LockAndDeadLockExample lockAndDeadLockExample = new LockAndDeadLockExample();
        Runnable lockExampleRunnable = () -> {
            lockAndDeadLockExample.withdraw(5);
        };
        Thread lockExample1 = new Thread(lockExampleRunnable);
        lockExample1.setName("lockExample1");

        Thread lockExample2 = new Thread(lockExampleRunnable);
        lockExample2.setName("lockExample2");

        lockExample1.start();
        lockExample2.start();

        System.out.println(" -----------------Deadlock resolver--------------------------");
       // deadLockExample();
        deadLockExample2();

        // fairness
        System.out.println(" -----------------FairnessLock--------------------------");
        fairnessreentraintExample();

        // readWriteReentrantExample
        System.out.println("------------------ ReadWriteLock -----------------------");
        readWriteReentrantExample();

    }

    private static void deadLockExample2() throws InterruptedException {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread thread1 = new Thread(new Task1(pen, paper), "Thread-1");
        Thread thread2 = new Thread(new Task2(pen, paper), "Thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void deadLockExample() {
        try{
            ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
            Runnable reentrantLockRunnable = () -> reentrantLockExample.slider(5);

            Thread reentrantLockThread = new Thread(reentrantLockRunnable);
            Thread reentrantLockThread2 = new Thread(reentrantLockRunnable);

            reentrantLockThread.setName("ReentrantLockThread");
            reentrantLockThread2.setName("ReentrantLockThread2");

            reentrantLockThread.start();
            reentrantLockThread2.start();
        }catch (Exception e){
            System.out.println("Exception");
        }
    }


    public static void unSynchronizedExample() throws InterruptedException {
        Counter counter = new Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementUnSynchronized();
            }
        };
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        thread3.start();
        thread4.start();

        thread3.join();
        thread4.join();
        System.out.println("UnSynchronized Count value : " + counter.getCount());

    }

    public static void synchronizedExample() throws InterruptedException {
        Counter counter = new Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementSynchronized();
            }
        };
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        thread3.start();
        thread4.start();

        thread3.join();
        thread4.join();
        System.out.println("UnSynchronized Count value : " + counter.getCount());
    }

    public static void getThread() {
        HelloThread thread3 = new HelloThread();
        thread3.start();

        // When you implement Runnable Interface
        Thread thread4 = new Thread(new HelloThread1());
        thread4.start();

        //  Method Reference approach
        Runnable runnable = Hello::sayHello;
        Thread thread5 = new Thread(runnable);
        thread5.start();
    }

    public void differentThreadMethod() throws InterruptedException {
        Thread thread = new Thread();
        // Different method of Thread
        long id = thread.getId();                                             // return the thread Id
        String threadName = thread.getName();                                             // thread name
        ThreadGroup threadGroup = thread.getThreadGroup();                                    // ThreadGroup
        thread.join();                                             // it let main thread to keep in waiting until the custom thead complete
        thread.join(5000);                                   // specify teh time for wait
        int priority = thread.getPriority();                                       // retrun the priority
        boolean isAlive = thread.isAlive();                                           // retrun is Thread alive
        boolean isDeamn = thread.isDaemon();
        Thread.State state = thread.getState();
        thread.interrupt();
        boolean isInterrupted = thread.isInterrupted();

        Thread thread3 = Thread.currentThread();
        int normPriority = Thread.NORM_PRIORITY;
        int minPriority = Thread.MIN_PRIORITY;
        int maxPriority = Thread.MAX_PRIORITY;
        Map<Thread, StackTraceElement[]> stack
                = Thread.getAllStackTraces();

        Object o1 = new Object();
        Thread.activeCount();
        Thread.dumpStack();
        Thread.dumpStack();
        Thread.onSpinWait();
        Thread.yield();
        Thread.sleep(500);
        Thread.holdsLock(o1);

        thread.wait();                                          // if you hold thread execution until another thread get complete and it notify your thread to resume
        thread.wait(1000);
        thread.wait(1000, 1);
        thread.notify();                                        // this will send the notify to thread that are in wait
        thread.notifyAll();                                     // if more than one is in wait then use notifyAll()
    }


    public static void fairnessreentraintExample(){
        try {
            ReentrantLockExample fairnessLockExample = new ReentrantLockExample();
            Runnable fairnessLockRunnable = fairnessLockExample::accessResource;

            Thread fairnesslockThread1 = new Thread(fairnessLockRunnable, "fairnesslockThread-1");
            Thread fairnesslockThread2 = new Thread(fairnessLockRunnable, "fairnesslockThread-2");
            Thread fairnesslockThread3 = new Thread(fairnessLockRunnable, "fairnesslockThread-3");

            fairnesslockThread1.start();
            Thread.sleep(50);
            fairnesslockThread2.start();
            Thread.sleep(50);
            fairnesslockThread3.start();

            fairnesslockThread1.join();
            fairnesslockThread2.join();
            fairnesslockThread3.join();
        }catch (Exception ew){
            System.out.println("Exception");
        }
    }
    public static void readWriteReentrantExample() {
        try {
            System.out.println("------------------ ReadWriteLock -----------------------");
            ReentrantLockExample readWriteLockExample = new ReentrantLockExample();
            Runnable readRunnable = () -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read: " + readWriteLockExample.getCount());
                }
            };

            Runnable writeRunnable = () -> {
                for (int i = 0; i < 10; i++) {
                    readWriteLockExample.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented");
                }
            };

            Thread writerThread = new Thread(writeRunnable, "write-thread");
            Thread readerThread1 = new Thread(readRunnable, "read-thread-1");
            Thread readerThread2 = new Thread(readRunnable, "read-thread-1");

            writerThread.start();
            readerThread1.start();
            readerThread2.start();

            writerThread.join();
            readerThread1.join();
            readerThread2.join();

            System.out.println("Final count: " + readWriteLockExample.getCount());
        } catch (Exception e) {
            System.out.println("exception");
        }
    }
}
