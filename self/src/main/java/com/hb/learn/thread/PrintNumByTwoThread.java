package com.hb.learn.thread;

/**
 * @ClassName PrintNum
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2022/7/30 0:27
 * @Version 1.0
 */
public class PrintNumByTwoThread {

    //public static int count = 0;
    //private static Object obj = new Object();

    private int count = 0;
    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        new PrintNumByTwoThread().turning0();
        //new PrintNum().turning2();
        //new PrintNum().turning();

    }

    public void turning0() {
        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    while ((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + count++);
                    }
                }
            }
        }, "奇数").start();

        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    while ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + count++);
                    }
                }
            }
        }, "偶数").start();
    }

    public void turning2() throws InterruptedException {
        Thread even = new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println("偶数: " + count++);
                    lock.notifyAll();
                    try {
                        // 如果还没有结束，则让出当前的锁并休眠
                        if (count <= 100) {
                            lock.wait();
                        }
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread odd = new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println("奇数: " + count++);
                    lock.notifyAll();
                    try {
                        // 如果还没有结束，则让出当前的锁并休眠
                        if (count <= 100) {
                            lock.wait();
                        }
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        even.start();
        // 确保偶数线程线先获取到锁
        Thread.sleep(1);
        odd.start();
    }
}
