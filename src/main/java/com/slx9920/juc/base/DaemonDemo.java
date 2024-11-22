package com.slx9920.juc.base;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Song Laixiong
 * @Create: 2024-11-22
 * @Description:
 */

public class DaemonDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 开始运行," +
                    (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
            // while (true) {
            //
            // }
        }, "线程1");
        t1.setDaemon(true); // 设置守护线程，需要在 start() 方法之前进行
        t1.start();
        // t1.setDaemon(true);

        // 暂停线程几秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "\t ----- end 主线程");
    }

}
