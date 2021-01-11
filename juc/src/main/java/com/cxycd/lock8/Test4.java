package com.cxycd.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈东东
 * @date 2021/1/11 19:52
 * @description 一句話描述用途
 */
public class Test4 {
    public static void main(String[] args) {
        Data4 data1 = new Data4();

        new Thread(() -> {data1.sendMes();},"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->data1.call(),"B").start();
    }


}

class Data4{
    // static静态方法
    // 类一加载就有了,锁的是class 类模板
    public static synchronized void sendMes(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendMes");
    }

    // 锁的是调用者
    public synchronized void call(){
        System.out.println("call");
    }
}
