package com.slx9920.juc.base;

/**
 * @Author: Song Laixiong
 * @Create: 2024-11-22
 * @Description:
 */

public class ThreadBaseDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 开始运行");
        }, "线程1");

        t1.start();
    }
}
