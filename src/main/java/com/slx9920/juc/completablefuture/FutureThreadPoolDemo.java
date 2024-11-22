package com.slx9920.juc.completablefuture;

import java.util.concurrent.*;

/**
 * @Author: Song Laixiong
 * @Create: 2024-11-22
 * @Description:
 */

public class FutureThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 3 个任务，目前开启多个异步任务线程来处理，请问耗时多少？
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        long start = System.currentTimeMillis();

        FutureTask<String> futureTask1 = new FutureTask<>(() -> {
            try {
                TimeUnit.SECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task1 over";
        });

        threadPool.submit(futureTask1);

        FutureTask<String> futureTask2 = new FutureTask<>(() -> {
            try {
                TimeUnit.SECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task2 over";
        });

        threadPool.submit(futureTask2);
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());

        try {
            TimeUnit.SECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        System.out.println(Thread.currentThread().getName() + "\t ----- end 主线程");
        threadPool.shutdown();
    }
}
