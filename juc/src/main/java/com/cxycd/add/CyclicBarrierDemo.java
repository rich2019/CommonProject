package com.cxycd.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 陈东东
 * @date 2021/2/6 14:08
 * @description 一句話描述用途
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,()->{
            System.out.println("over");
        });
        for (int i = 0; i < 8; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " -- add");
                try {
                    // 当前线程阻塞,等待cyclicBarrier计数完成后继续运行
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " -- 阻塞结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
