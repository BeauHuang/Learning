package com.hb.learn.designmode;

/**
 * @ClassName Factory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/24 23:55
 * @Version 1.0
 */
public class Factory {
}

interface Car {
    void run();
}

class Audi implements Car {
    @Override
    public void run() {
        System.out.println("Audi is running...");
    }
}

class BMW implements Car {
    @Override
    public void run() {
        System.out.println("BMW is running...");
    }
}

interface CarFactory {
    Car createCar();
}

class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}

class BMWFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new BMW();
    }
}

class Test {
    public static void main(String[] args) {
        CarFactory audiFactory = new AudiFactory();
        CarFactory bmwFactory = new BMWFactory();

        Car audi = audiFactory.createCar();
        Car bmw = bmwFactory.createCar();

        audi.run();
        bmw.run();
    }
}

