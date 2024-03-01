package com.hb.learn.javase;


/**
 * @ClassName CreateObject @Description TODO @Author huangbo @Mail refusers@163.com @Date 2023/5/28
 * 20:57 @Version 1.0
 */
public class CreateObject {
  public static void main(String[] args) {
    new A();
  }
}

class A {
  B b;

  static int count;

  public A() {
    System.out.println("new A:" + count++);
    b = new B();
  }
}

class B {
  A a;
  static int count;

  public B() {
    System.out.println("new B:" + count++);

    a = new A();
  }
}

class ReferenceCountingGC {
  public Object instance = null;
  private static final int _1MB = 1024 * 1024;
  /** * 这个成员属性的唯一意义就是占点内存， 以便能在GC日志中看清楚是否有回收过 */
  private byte[] bigSize = new byte[2 * _1MB];

  public static void main(String[] args) {
    testGC();
  }

  public static void testGC() {
    ReferenceCountingGC objA = new ReferenceCountingGC();
    ReferenceCountingGC objB = new ReferenceCountingGC();
    objA.instance = objB;
    objB.instance = objA;
    objA = null;
    objB = null; // 假设在这行发生GC， objA和objB是否能被回收？
    System.gc();
  }
}
