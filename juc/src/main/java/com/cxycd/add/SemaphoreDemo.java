package com.cxycd.add;

import java.util.concurrent.Semaphore;

/**
 * @author 陈东东
 * @date 2021/2/6 14:24
 * @description 一句話描述用途
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 限流,每次限制能执行的线程数量
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 11; i++) {
            new Thread(() -> {
                try {
                    // 拿到计数器
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 进入");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放
                    semaphore.release();
                    System.out.println("            " + Thread.currentThread().getName() + " 释放");
                }
            }, String.valueOf(i)).start();
        }

    }
}
