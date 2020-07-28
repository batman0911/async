package execute;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by linhnm20 on Jul, 2020
 */

public class CallableExecute {
    public static void main(String[] args) {
        List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<Integer> callable;
        Future<Integer> future;

        for (int i = 0; i < 10; i++) {
            callable = new CallableWorker(i);
            future = executorService.submit(callable);
            futureList.add(future);
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        int sum = 0;
        for (Future<Integer> integerFuture : futureList) {
            try {
                sum += integerFuture.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("finish all threads");
        System.out.println("sum all: " + sum);
    }
}
