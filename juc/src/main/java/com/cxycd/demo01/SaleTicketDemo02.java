package com.cxycd.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 陈东东
 * @date 2021/1/10 17:18
 * @description 一句話描述用途
 */
public class SaleTicketDemo02 {

    public static void main(String[] args) {

        Ticket2 ticket = new Ticket2();

        new Thread(() -> { for (int i = 0; i < 60; i++) ticket.sale(); }, "a").start();
        new Thread(() -> { for (int i = 0; i < 60; i++) ticket.sale(); }, "b").start();
        new Thread(() -> { for (int i = 0; i < 60; i++) ticket.sale(); }, "c").start();
    }

}

class Ticket2 {
    private int number = 30;

    Lock lock = new ReentrantLock();

    public void sale() {
        try {
            lock.lock();
            if (number > 0) {
                number--;
                System.out.println(Thread.currentThread().getName() + "  " + " ---" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}