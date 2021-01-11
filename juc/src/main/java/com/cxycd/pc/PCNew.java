package com.cxycd.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 陈东东
 * @date 2021/1/10 18:21
 * @description 生产, 消费 按顺序执行线程 A - B - C
 * 传统的方式 synchronize + wait + notify
 */
public class PCNew {

    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        }, "C").start();


    }

}

class Data2 {
    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printA() {
        try {
            lock.lock();
            while (number != 0) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "  ---  A");
            number = 1;
            // 唤醒2
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        try {
            lock.lock();
            while (number != 1) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "  ---  B");
            number = 2;
            // 唤醒3
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        try {
            lock.lock();
            while (number != 2) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "  ---  C");
            number = 0;
            // 唤醒1
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}