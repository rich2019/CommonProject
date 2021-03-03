package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 陈东东
 * @date 2021/3/2 19:23
 * @description 一句話描述用途
 */
public class ExectorsThreadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5); //一个线程池5个线程
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); //一个线程池只有一个线程
        ExecutorService executorService = Executors.newCachedThreadPool(); //一个线程池有多个线程,动态变化自动调整

        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "线程干活");
                });
//                try {
//                    TimeUnit.MILLISECONDS.sleep(4);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
            System.out.println("干完收工");
        }

    }
}
