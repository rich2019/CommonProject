package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 陈东东
 * @date 2021/2/7 13:47
 * @description 两个线程操作一个变量
 * 一个线程加一,一个线程减一
 * 交替操作10轮
 * <p>
 * 1. 高内聚 低耦合,线程操作资源类
 * 2. 判断/通知/干活
 * 3. 多线程交互中,要防止线程的虚假唤醒(用while不用if)
 */
public class ThreadWaitNotifyLockDemo {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ticket.increment();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ticket.decrement();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ticket.increment();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ticket.decrement();
            }
        }, "D").start();


    }

}

class Ticket2 {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void increment() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "  加一  " + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "  减一  " + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
