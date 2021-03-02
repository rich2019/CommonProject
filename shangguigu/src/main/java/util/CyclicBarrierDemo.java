package util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 陈东东
 * @date 2021/2/22 19:51
 * @description 累加,加法完成后执行CyclicBarrier后的线程
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () ->
                System.out.println("close")
        );
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "  " + "out");
                try {
                    // 阻塞并开始计数,计数完成后继续运行
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  " + "out success");
            }, String.valueOf(i)).start();
        }
    }
}
