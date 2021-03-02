package util;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 陈东东
 * @date 2021/2/22 20:05
 * @description 限制资源数 信号灯
 * 3个车位 6个车抢
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到了");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("\t     " + Thread.currentThread().getName() + "\t离开了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
