package util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 陈东东
 * @date 2021/2/22 20:34
 * @description 一句話描述用途
 */
public class ReadWhiteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final  int temp = i;
            new Thread( ()-> {
                myCache.put(String.valueOf(temp),temp);
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final  int temp = i;
            new Thread( ()-> {
                myCache.get(String.valueOf(temp));
            },String.valueOf(i)).start();
        }
    }
}
class MyCache{
    private volatile Map<String,Object> map = new HashMap();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 写数据");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println("\t " + Thread.currentThread().getName() + "\t 读数据");
            Object o = map.get(key);
            System.out.println("\t " + Thread.currentThread().getName() + "\t " + o);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}
