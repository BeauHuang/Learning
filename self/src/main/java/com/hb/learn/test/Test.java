package com.hb.learn.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @ClassName Test
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2022/12/13 0:25
 * @Version 1.0
 */
public class Test {



}


class Test01{
    public static void main(String[] args) {
        while (true){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"==自然选择，前进四！");
            }).start();
        }
    }
}

class FunctionalProgrammingExample {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 30000000; i++) {
            numbers.add(i);
        }

        //List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 命令式编程方式
        List<Integer> squaredNumbersImperative = new ArrayList<>();
        long l1 = System.currentTimeMillis();
        for (Integer number : numbers) {
            squaredNumbersImperative.add(number * number);
        }
        long l2 = System.currentTimeMillis();
        //System.out.println("Squared numbers (Imperative): " + squaredNumbersImperative);
        System.out.println(l2-l1);

        // 函数式编程方式
        long l3 = System.currentTimeMillis();
        List<Integer> squaredNumbersFunctional = numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
        long l4 = System.currentTimeMillis();
        //System.out.println("Squared numbers (Functional): " + squaredNumbersFunctional);
        System.out.println(l4-l3);

    }
}