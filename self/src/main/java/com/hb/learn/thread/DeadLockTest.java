package com.hb.learn.thread;

/**
 * @ClassName DeadLock
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2022/11/24 0:15
 * @Version 1.0
 */
public class DeadLockTest {
    /**
     * 死锁：
     * 思想：多个线程，执行同一部分代码
     * 在该代码中，A线程先获取锁1，再去获取锁2；线程B刚好相反
     * 为达到演示效果，获取锁的空挡最好sleep一下
     */
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(deadLock, "1").start();
        new Thread(deadLock, "2").start();
    }
}


class DeadLock implements Runnable {

    private final Object A = new Object();
    private final Object B = new Object();

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        if (currentThreadName.equals("1")) {
            synchronized (A) {
                System.out.println(currentThreadName + " get A");
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println(currentThreadName + " get B");
                }
            }
        }
        else {
            synchronized (B) {
                System.out.println(currentThreadName + " get B");
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    System.out.println(currentThreadName + " get A");
                }
            }
        }
    }
}


class Main {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        new Thread(() -> {
            task(A, B);
        }).start();
        new Thread(() -> {
            task(B, A);
        }).start();
    }

    static void task(Object first, Object second) {
        String currentThreadName = Thread.currentThread().getName();
        synchronized (first) {
            System.out.println(currentThreadName + " get " + first);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (second) {
                System.out.println(currentThreadName + " get " + second);
            }
        }
    }
}


/**
 * 这种情况下是两个线程执行的是不同的资源，所以不影响锁的获取
 */
class DaedLock2 {

    static DaedLock2 lock1 = new DaedLock2();
    static DaedLock2 lock2 = new DaedLock2();

    public static void main(String[] args) {

        final Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("线程1拿到了锁1");
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("线程1获得了锁2");
                }
            }
        }, "线程1");

        final Thread t2 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("线程1拿到了锁1");
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("线程1获得了锁2");
                }
            }
        }, "线程2");

        t1.start();
        t2.start();

    }

}