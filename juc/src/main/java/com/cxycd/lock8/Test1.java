package com.cxycd.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈东东
 * @date 2021/1/11 19:52
 * @description 一句話描述用途
 */
public class Test1 {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(data::sendMes,"A").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(data::call,"B").start();
    }
}
class Data{
    // 锁的对象是方法的调用者
    // 两个方法用的是同一个锁,谁先拿到谁执行
    public synchronized void sendMes(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("sendMes");
    }

    public synchronized void call(){
        System.out.println("call");
    }
}
