package util;

import java.util.concurrent.CountDownLatch;

/**
 * @author 陈东东
 * @date 2021/2/22 19:44
 * @description 累减,减完后执行主线程(被阻塞的线程)
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread( () -> {
                System.out.println(Thread.currentThread().getName() + "  " + "out");
                latch.countDown();
            },String.valueOf(i)).start();
        }
        latch.await();
        System.out.println("close");
    }
}
