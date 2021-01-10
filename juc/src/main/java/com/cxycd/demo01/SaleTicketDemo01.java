package com.cxycd.demo01;

/**
 * @author 陈东东
 * @date 2021/1/10 17:18
 * @description 一句話描述用途
 */
public class SaleTicketDemo01 {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "b").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "c").start();
    }

}

class Ticket {
    private int number = 30;

    public synchronized void  sale() {
        if (number > 0) {
            number--;
            System.out.println(Thread.currentThread().getName() + "  " + " ---" + number);
        }
    }
}