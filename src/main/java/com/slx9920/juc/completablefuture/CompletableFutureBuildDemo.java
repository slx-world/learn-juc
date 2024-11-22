package com.slx9920.juc.completablefuture;

import java.util.concurrent.*;

/**
 * @Author: Song Laixiong
 * @Create: 2024-11-22
 * @Description:
 */

public class CompletableFutureBuildDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
        //     System.out.println(Thread.currentThread().getName());
        //
        //     // 暂停线程几秒钟
        //     try {
        //         TimeUnit.SECONDS.sleep(3);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }, threadPool);
        //
        // System.out.println(completableFuture.get());

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());

            // 暂停线程几秒钟
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "hello supplyAsync";

        }, threadPool);

        System.out.println(completableFuture.get());
        threadPool.shutdown();
    }

}
