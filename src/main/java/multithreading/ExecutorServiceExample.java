package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {


    public static void main(String[] args) {
        executorCreationExample();
        differentExecutor();
        singleExecutor();
        fixedRateExecutor();
        //cachedExecutor();
        scheduledExecutor();
        futureSyntaxExample();
        countDownExample();
        cyclicBarrierExample();
    }

    private static void fixedRateExecutor() {
        try {
            Runnable currentAgeRunnable = () -> System.out.println("my current age is " + 30);
            Runnable futureAgeRunnable = () -> System.out.println("my current age is " + 31);
            List<Callable<Object>> list = new ArrayList<>();
            list.add(Executors.callable(currentAgeRunnable));
            list.add(Executors.callable(futureAgeRunnable));

            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
            List<Future<Object>> futures = newFixedThreadPool.invokeAll(list);
            System.out.println(futures.get(0));
            newFixedThreadPool.shutdown();
            System.out.println("newFixedThreadPool task is :- " + newFixedThreadPool.isShutdown());


            ExecutorService newFixedThreadPool2 = Executors.newFixedThreadPool(1);
            Object obj = newFixedThreadPool2.invokeAny(list); // Executes a collection of Callable tasks and returns the result of one that completes successfully
            newFixedThreadPool2.shutdown();

            ExecutorService newFixedThreadPool3 = Executors.newFixedThreadPool(1);
            Object obj2 = newFixedThreadPool3.invokeAny(list, 10, TimeUnit.SECONDS); //  Executes a collection of Callable tasks and returns the result of the first one that completes, with a timeout.
            newFixedThreadPool3.shutdown();

        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Task completed.");
    }

    private static void singleExecutor() {
        // Through executor -> Thread will run next task with the same thrad. Thrad will not terminate automatically need to do this explicitly
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(() -> {
            System.out.println("1st way to execute the  thread using submit lambda");
        });
        service.submit(() -> {
            System.out.println("1st way to execute the  thread using submit lambda");
        });
        service.shutdown();
        //  service.shutdownNow(); //shoutdown the thread immediatly will not wait for a thread to get execute

        System.out.println("isShutdown check weather executor thread is down or not :- " + service.isShutdown());
        //   service.awaitTermination(1000, TimeUnit.MILLISECONDS); // Waits for all tasks to finish for a specified timeout before terminating the executor.

        System.out.println("isTerminated Checks if all tasks have completed following shutdown." + service.isTerminated());

    }

    private static void executorCreationExample() {
        try {
            // old way to execute the thread
            Runnable currentAgeRunnable = () -> System.out.println("my current age is " + 30);
            Runnable futureAgeRunnable = () -> System.out.println("my current age is " + 31);
            Thread thread = new Thread(currentAgeRunnable);
            thread.start();
            thread.join();

            ExecutorService service = Executors.newSingleThreadExecutor();
            service.submit(() -> System.out.println("1st way to execute the  thread using submit lambda"));

            Runnable run = () -> System.out.println("3rd way to execute the  thread using submit runnable");
            service.submit(run);

            System.out.println("4th way to execute the  thread using Callable");
            Callable<Integer> callable = () -> 40;
            Future<Integer> callex = service.submit(callable);
        } catch (Exception e) {

        }
    }

    private static void differentExecutor() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();
    }


    public static void futureSyntaxExample() {

        ExecutorService futureExecutor = Executors.newFixedThreadPool(1);
        try {
            Future<Integer> future = futureExecutor.submit(() -> {
                System.out.println("futureSyntaxExample");
                Thread.sleep(1000);
                return 40;
            });

            System.out.println("Check weather future received the output or not :- " + future.isDone());
            System.out.println("Future.get() :- " + future.get());
            System.out.println("Future.get() with time limit: - " + future.get(1, TimeUnit.SECONDS)); // will wait oly for 1 sec to t=get teh thread completed and get teh output
            System.out.println("Check weather future received the output or not :- " + future.isDone());
            System.out.println("Future.cancelled()" + future.cancel(true)); // Even you call the canel future will be terminated will not have any output but threak will be executed sucessfully
            System.out.println("Future.isCancelled() :- " + future.isCancelled());
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            futureExecutor.shutdown();
        }
    }

    public static void scheduledExecutor() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService scheduledExecutorService3 = Executors.newScheduledThreadPool(1);
        try {
            scheduledExecutorService.schedule(() -> System.out.println("task executed  schedule() after 5 second !"), 5, TimeUnit.SECONDS);

            scheduledExecutorService2.scheduleAtFixedRate(() -> System.out.println("task executed  scheduleAtFixedRate() after every 5 second !"), 5, 5, TimeUnit.SECONDS);

            scheduledExecutorService3.scheduleWithFixedDelay(() -> System.out.println("task executed scheduleWithFixedDelay() every 5 second !"), 5, 5, TimeUnit.SECONDS);

            Thread.sleep(30000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            scheduledExecutorService.shutdown();
            scheduledExecutorService2.shutdown();
            scheduledExecutorService3.shutdown();
        }

    }

    public static void countDownExample() {
        int n = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        CountDownLatch latch = new CountDownLatch(n);
        try {
            executorService.submit(new DependentService(latch));
            executorService.submit(new DependentService(latch));
            executorService.submit(new DependentService(latch));

            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main");
        executorService.shutdown();
    }

    public static void cyclicBarrierExample() {
        int numberOfSubsystems = 4;
        CyclicBarrier barrier = new CyclicBarrier(numberOfSubsystems, new Runnable() {
            @Override
            public void run() {
                System.out.println("All subsystems are up and running. System startup complete.");
            }
        });

        Thread webServerThread = new Thread(new Subsystem("Web Server", 2000, barrier));
        Thread databaseThread = new Thread(new Subsystem("Database", 4000, barrier));
        Thread cacheThread = new Thread(new Subsystem("Cache", 3000, barrier));
        Thread messagingServiceThread = new Thread(new Subsystem("Messaging Service", 3500, barrier));

        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingServiceThread.start();
    }
}
