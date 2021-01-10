package com.cxycd.pc;

/**
 * @author 陈东东
 * @date 2021/1/10 18:21
 * @description 生产,消费
 */
public class PCtest {

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        },"D").start();

    }

}

class Data{
    private int number = 0;

    // 生产
    public synchronized void increment() {
        // 使用while 可以防止虚假唤醒
        while (number > 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "  --  " + number);
        this.notifyAll();
    }
    // 消费
    public synchronized void decrement() {
        // 使用while 可以防止虚假唤醒
        while (number <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "  --  " + number);
        this.notifyAll();
    }



}