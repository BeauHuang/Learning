package com.hb.learn.thread;

/**
 * @ClassName PrintNumByThreeThread
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2022/8/16 0:02
 * @Version 1.0
 */
public class PrintNumByThreeThread {

    static Object obj1 = new Object();
    static Object obj2 = new Object();
    static Object obj3 = new Object();
    static int count = 1;
    static int num = 10000;

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        new PrintNumByThreeThread().printNum01();
        //new PrintNumByThreeThread().printNum02();
        long t2 = System.currentTimeMillis();
        System.out.println("耗时" + (t2 - t1) + "毫秒");
    }

    public void printNum01() {
        Thread t1 = new Thread(() -> {
            while (count < num) {
                synchronized (obj1) {
                    synchronized (obj2) {
                        if (count % 3 == 1) {
                            System.out.println(Thread.currentThread().getName() + count++);
                        }
                    }
                }
            }

        }, "线程一：");

        Thread t2 = new Thread(() -> {
            while (count < num) {
                synchronized (obj1) {
                    synchronized (obj3) {
                        if (count % 3 == 2) {
                            System.out.println(Thread.currentThread().getName() + count++);
                        }
                    }
                }
            }

        }, "线程二：");

        Thread t3 = new Thread(() -> {
            while (count < num) {
                synchronized (obj2) {
                    synchronized (obj3) {
                        if (count % 3 == 0) {
                            System.out.println(Thread.currentThread().getName() + count++);
                        }
                    }
                }
            }

        }, "线程三：");
        t1.start();

        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e) {
        }

    }

    public void printNum02() {
        for (int i = 0; i < num; i++) {
            System.out.println(Thread.currentThread().getName() + count++);
        }
    }

}
