package execute;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by linhnm20 on Jul, 2020
 */

public class CompletableFutureExecute {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Date t1 = new Date();

        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("inside intenseCal");
                return intenseCal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });

        CompletableFuture<Long> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("inside add");
                return add(10, 11);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });

        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(() -> {
            try {
                intenseVoid();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(completableFuture, completableFuture1, completableFuture2);
//
        combinedFuture.get();

//        while (!completableFuture.isDone()) {
////            System.out.println("completableFuture is not done ...");
//        }

        System.out.println("main thread done");
//
//        long result = completableFuture.get();
//        long sum = completableFuture1.get();

        Date t2 = new Date();

//        System.out.println("result: " + result);
//        System.out.println("sum: " + sum);
//        completableFuture2.get();
        System.out.println("duration: " + (t2.getTime() - t1.getTime()));

    }

    private static Long intenseCal() throws InterruptedException {
//        Thread.sleep((new Random()).nextInt(10) * 1000);
        System.out.println("intenseCal calculating");
        Thread.sleep(4000);
        return (long) (new Random()).nextInt(100);
    }

    private static Long add(long a, long b) throws InterruptedException {
//        Thread.sleep((new Random()).nextInt(10) * 1000);
        System.out.println("add calculating");
        Thread.sleep(5000);
        return a + b;
    }

    private static void intenseVoid() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("inside intenseVoid");
    }
}
