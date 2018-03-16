package com.zhong.MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainTask {
    private static ExecutorService executorService = Executors.newFixedThreadPool(7);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> futureRsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futureRsList.add(executorService.submit(new SubTask(i)));
        }
        System.out.println("should not waiting here");
        for (Future<String> futureStr: futureRsList) {
            System.out.println(futureStr.get());
            System.out.println("Finished some work");
        }
        executorService.shutdown();
    }
}
