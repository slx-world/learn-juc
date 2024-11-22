package com.slx9920.juc.completablefuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Song Laixiong
 * @Create: 2024-11-22
 * @Description:
 */

public class FutureAPIDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println("----- come in FutureTask");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task over";
        });

        Thread t1 = new Thread(futureTask, "t1");
        t1.start();
        System.out.println(Thread.currentThread().getName() + "\t ----- 忙其他任务了");
        // System.out.println(futureTask.get());
        // System.out.println(futureTask.get(3, TimeUnit.SECONDS));

        while (true) {
            if (futureTask.isDone()) {
                System.out.println(futureTask.get());
                break;
            } else {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
