package blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author 陈东东
 * @date 2021/3/2 16:55
 * @description 一句話描述用途
 */
public class BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue blockingQueue = new LinkedBlockingDeque<String>();
        BlockingQueue queue = new ArrayBlockingQueue(3);
        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        System.out.println(queue.add(3));
        queue.put(4);
    }
}
