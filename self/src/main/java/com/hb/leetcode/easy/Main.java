package com.hb.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main @Description TODO @Author huangbo @Mail refusers@163.com @Date 2024/1/30
 * 21:53 @Version 1.0
 */
public class Main {}

class Q118 {

  public static void main(String[] args) {
    System.out.println(generate(1));
  }

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ge = new ArrayList<>();
    getRow(numRows - 1, ge);
    return ge;
  }

  public static List<Integer> getRow(int rowIndex, List<List<Integer>> ge) {
    // 初始化长度
    List<Integer> list = new ArrayList<>(rowIndex + 1);

    // 初始化赋值
    for (int i = 0; i < rowIndex + 1; i++) {
      list.add(1);
    }

    // 递归到最上层结束
    if (rowIndex < 0) {
      return list;
    }

    // 递归运算
    List<Integer> res = getRow(rowIndex - 1, ge);

    // 下一层的数字依赖于上一层的，比对一下坐标就行
    for (int i = 1; i < rowIndex; i++) {
      list.set(i, res.get(i - 1) + res.get(i));
      list.set(rowIndex - i, res.get(rowIndex - i) + res.get(rowIndex - i - 1));
    }

    ge.add(list);

    return list;
  }
}

class Q119 {

  public static void main(String[] args) {
    System.out.println(getRow(20));
  }

  public static List<Integer> getRow(int rowIndex) {
    // 初始化长度
    List<Integer> list = new ArrayList<>(rowIndex + 1);

    // 初始化赋值
    for (int i = 0; i < rowIndex + 1; i++) {
      list.add(1);
    }

    // 递归到最上层结束
    if (rowIndex < 0) {
      return list;
    }

    // 递归运算
    List<Integer> res = getRow(rowIndex - 1);

    // 下一层的数字依赖于上一层的，比对一下坐标就行
    for (int i = 1; i < rowIndex; i++) {
      list.set(i, res.get(i - 1) + res.get(i));
      list.set(rowIndex - i, res.get(rowIndex - i) + res.get(rowIndex - i - 1));
    }
    System.out.println(list);

    return list;
  }
}

class Q409 {
  public static void main(String[] args) {

    System.out.println(longestPalindrome("abccccdd"));
  }

  public static int longestPalindrome(String s) {
    int[] charCount = new int[128]; // 由于字符集为ASCII，使用长度为128的数组表示每个字符的出现次数

    // 统计字符出现的次数
    for (char c : s.toCharArray()) {
      charCount[c]++;
    }

    int length = 0; // 回文串的长度
    boolean hasOdd = false; // 是否有出现奇数次的字符

    // 遍历数组
    for (int count : charCount) {
      // 使用字符的偶数次数或偶数次数 - 1来构造回文串
      length += count / 2 * 2;

      // 如果字符出现次数为奇数，则标记为有奇数次数的字符
      if (count % 2 == 1) {
        hasOdd = true;
      }
    }

    // 如果存在奇数次数的字符，则可以在回文串中选择一个作为中心
    if (hasOdd) {
      length++;
    }

    return length;
  }
}

class Q13 {
  public static void main(String[] args) {
    System.out.println(romanToInt("III"));
    System.out.println(romanToInt("IV"));
    System.out.println(romanToInt("IX"));
    System.out.println(romanToInt("LVIII"));
    System.out.println(romanToInt("MCMXCIV"));
  }

  public static int romanToInt(String s) {

    String[] arr = s.split("");

    int value = 0;

    for (int i = 0; i < arr.length; i++) {
      switch (arr[i]) {
        case "I":
          value += 1;
          break;
        case "V":
          value += 5;
          break;
        case "X":
          value += 10;
          break;
        case "L":
          value += 50;
          break;
        case "C":
          value += 100;
          break;
        case "D":
          value += 500;
          break;
        case "M":
          value += 1000;
          break;
      }
      if (i < arr.length - 1) {
        if (arr[i].equals("I") && (arr[i + 1].equals("V") || arr[i + 1].equals("X"))) {
          value -= 2;
        } else if (arr[i].equals("X") && (arr[i + 1].equals("L") || arr[i + 1].equals("C"))) {
          value -= 20;
        } else if (arr[i].equals("C") && (arr[i + 1].equals("D") || arr[i + 1].equals("M"))) {
          value -= 200;
        }
      }
    }

    return value;
  }


  /**
   * Returns a hash code value for the object. This method is
   * supported for the benefit of hash tables such as those provided by
   * {@link java.util.HashMap}.
   * <p>
   * The general contract of {@code hashCode} is:
   * <ul>
   * <li>Whenever it is invoked on the same object more than once during
   *     an execution of a Java application, the {@code hashCode} method
   *     must consistently return the same integer, provided no information
   *     used in {@code equals} comparisons on the object is modified.
   *     This integer need not remain consistent from one execution of an
   *     application to another execution of the same application.
   * <li>If two objects are equal according to the {@code equals(Object)}
   *     method, then calling the {@code hashCode} method on each of
   *     the two objects must produce the same integer result.
   * <li>It is <em>not</em> required that if two objects are unequal
   *     according to the {@link java.lang.Object#equals(java.lang.Object)}
   *     method, then calling the {@code hashCode} method on each of the
   *     two objects must produce distinct integer results.  However, the
   *     programmer should be aware that producing distinct integer results
   *     for unequal objects may improve the performance of hash tables.
   * </ul>
   * <p>
   * As much as is reasonably practical, the hashCode method defined by
   * class {@code Object} does return distinct integers for distinct
   * objects. (This is typically implemented by converting the internal
   * address of the object into an integer, but this implementation
   * technique is not required by the
   * Java&trade; programming language.)
   *
   * @return  a hash code value for this object.
   * @see     java.lang.Object#equals(java.lang.Object)
   * @see     java.lang.System#identityHashCode
   */
  public native int hashCode();
}
