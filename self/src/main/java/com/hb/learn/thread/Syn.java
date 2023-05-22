package com.hb.learn.thread;

/**
 * @ClassName Syn
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2022/12/15 23:09
 * @Version 1.0
 */
public class Syn implements Runnable{
    static int a = 0;
    static Syn t = new Syn();

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
