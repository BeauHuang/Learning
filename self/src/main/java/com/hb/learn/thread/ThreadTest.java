package com.hb.learn.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2022/11/6 11:15
 * @Version 1.0
 */
public class ThreadTest {
}

class TongBu1 {

    public static int a = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (TongBu1.class) {
                for (int i = 0; i < 100000; i++) {
                    a++;
                }
            }
        }).start();


        new Thread(() -> {
            synchronized (TongBu1.class) {
                System.out.println(a);
            }
        }).start();
    }
}

class TongBu2 {

    public static int a = 0;

    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 100000; i++) {
                a++;
            }
            //lock.unlock();
        }).start();


        new Thread(() -> {
            try {
                if (lock.tryLock(2, TimeUnit.SECONDS)) {
                    lock.lock();
                    System.out.println(a);
                    lock.unlock();
                }
                else {
                    System.out.println("拿不到锁");
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}


class TongBu3 {

    public volatile static int a = 0;
    public volatile static boolean b = false;

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                a++;
            }
            b = true;
        }).start();


        new Thread(() -> {
            System.out.println(a);
            System.out.println(b);
        }).start();
    }
}

