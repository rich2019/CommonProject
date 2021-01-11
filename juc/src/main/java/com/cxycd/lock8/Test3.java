package com.cxycd.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈东东
 * @date 2021/1/11 19:52
 * @description 一句話描述用途
 */
public class Test3 {
    public static void main(String[] args) {
        Data3 data1 = new Data3();
        Data3 data2 = new Data3();

        new Thread(() -> {data1.sendMes();},"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->data2.call(),"B").start();
    }


}

class Data3{
    // static静态方法
    // 类一加载就有了,锁的是class
    public static synchronized void sendMes(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("sendMes");
    }

    public static synchronized void call(){
        System.out.println("call");
    }
}
