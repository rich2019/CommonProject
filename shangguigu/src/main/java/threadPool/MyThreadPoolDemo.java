package threadPool;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;

/**
 * @author 陈东东
 * @date 2021/3/3 15:09
 * @description 一句話描述用途
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5,
                2L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        // AbortPolicy          抛出异常,并中断程序
        // CallerRunsPolicy     任务退给调用者
        // DiscardOldestPolicy  丢弃队列中等待最久的任务,把当前任务加入到队列并尝试提交
        // DiscardPolicy        放弃当前任务

        try {
            for (int i = 0; i < 11; i++) {
                final int a = i;
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "执行任务     " + a);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }

    }
}
