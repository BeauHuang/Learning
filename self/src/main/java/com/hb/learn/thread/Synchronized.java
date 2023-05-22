package com.hb.learn.thread;

/**
 * @ClassName Synchronized
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2022/12/13 23:54
 * @Version 1.0
 */
public class Synchronized {
}

/**
 * 未同步的a++
 */
class Test1 implements Runnable {

    static int a = 0;
    static Test1 t = new Test1();

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            a++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(t, "线程1");
        Thread t2 = new Thread(t, "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a);
    }
}

/**
 * 同步的a++——第一种方式
 * <p>
 * synchronized修饰同步代码块
 * 锁可以是当前类的对象，也可以是类对象Test2.class
 */
class Test2 implements Runnable {

    static int a = 0;
    static Test2 t = new Test2();

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100000; i++) {
                a++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(t, "线程1");
        Thread t2 = new Thread(t, "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a);
    }
}

/**
 * 同步的a++——第二种方式
 * <p>
 * synchronized修饰同步代码方法
 * 直接在run方法上加synchronized关键字，就可以达到互斥效果
 */
class Test3 implements Runnable {

    static int a = 0;
    static Test3 t = new Test3();

    @Override
    public synchronized void run() {
        for (int i = 0; i < 100000; i++) {
            a++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(t, "线程1");
        Thread t2 = new Thread(t, "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a);
    }
}