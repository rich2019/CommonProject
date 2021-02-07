package com.cxycd.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 陈东东
 * @date 2021/2/6 13:42
 * @description CountDownLatch 减法计数器,数值为0时唤醒await()方法
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch waitOut = new CountDownLatch(4);
        for (int i = 0; i < 8; i++) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " --  out");
                waitOut.countDown();
                System.out.println(Thread.currentThread().getName() + " -- 计数减一");
            }, String.valueOf(i)).start();
        }

        // 主线程被阻塞
        waitOut.await();
        System.out.println("close");
    }
}
