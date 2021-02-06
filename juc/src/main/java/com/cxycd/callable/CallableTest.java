package com.cxycd.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author 陈东东
 * @date 2021/2/6 13:28
 * @description 一句話描述用途
 */
public class CallableTest {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
    }
}

class MyThread implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("call");
        return 1024;
    }
}
