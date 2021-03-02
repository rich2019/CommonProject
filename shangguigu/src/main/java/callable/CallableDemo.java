package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 陈东东
 * @date 2021/2/22 19:13
 * @description 一句話描述用途
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask<Integer> futrueTask = new FutureTask<>(myThread);

        Thread thread = new Thread(futrueTask);
        thread.start();
        System.out.println(futrueTask.get()); //并行,最后获取数据
    }

}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("callable");
        return 1024;
    }
}
