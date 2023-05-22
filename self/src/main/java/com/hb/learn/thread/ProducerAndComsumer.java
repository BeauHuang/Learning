package com.hb.learn.thread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ProducerAndComsumer
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/1/14 11:59
 * @Version 1.0
 */
public class ProducerAndComsumer {

    public static ProducerAndComsumer lock = new ProducerAndComsumer();
    public static LinkedList<Integer> number;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Producer(), "生产者").start();
        TimeUnit.MILLISECONDS.sleep(100);
        new Thread(new Comsumer(), "消费者").start();
    }

    static class Producer implements Runnable {

        public int i;

        public Producer() {
            i = 0;
            number = new LinkedList<>();
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (number.size() == 0 || number.size() <= 10) {
                        System.out.println(Thread.currentThread().getName() + " 生产 " + i);
                        number.add(i++);
                    }
                    i = 0;
                    lock.notify();
                    try {
                        lock.wait();
                    }
                    catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    static class Comsumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (number.size() > 0) {
                        System.out.println(Thread.currentThread().getName() + " 消费 " + number.poll());
                    }
                    lock.notify();
                    try {
                        lock.wait();
                    }
                    catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
