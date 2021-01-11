package com.cxycd.unsafe;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 陈东东
 * @date 2021/1/11 20:36
 * @description 一句話描述用途
 */
public class ListTest {
    public static void main(String[] args) {
        // 写入时复制
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(Thread.currentThread().getName() + "  " + list);
            },String.valueOf(i)).start();

        }
    }
}
