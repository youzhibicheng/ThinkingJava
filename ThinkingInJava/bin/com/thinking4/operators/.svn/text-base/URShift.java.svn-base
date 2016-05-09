package com.thinking4.operators;
//: operators/URShift.java
// Test of unsigned right shift.
import static com.thinking4.util.Print.*;
// >>>  无符号右移，无论正负，都在高位插入0
public class URShift {
  public static void main(String[] args) {
    int i = -1;
    print(Integer.toBinaryString(i));
    i >>>= 10;
    print(Integer.toBinaryString(i));
    long l = -1;
    print(Long.toBinaryString(l));
    l >>>= 10;
    print(Long.toBinaryString(l));
    // 先转换成int，再进行右移操作，然后被截断，赋值给原来的类型
    short s = -1;
    print(Integer.toBinaryString(s));
    //刚转换玩之后是
    //00000000001111111111111111111111
    //但由于s是short，存储不了这么多位，所以就直接截断了
    s >>>= 10;
    //用Interger打印short，需要自动添加位
    print(Integer.toBinaryString(s));
    // 先转换成int，再进行右移操作，然后被截断，赋值给原来的类型
    byte b = -1;
    print(Integer.toBinaryString(b));
    b >>>= 10;
    print(Integer.toBinaryString(b));
    b = -1;
    print(Integer.toBinaryString(b));
    //由于没有赋值给b，而是直接打印出来，所以结果是正确的
    print(Integer.toBinaryString(b>>>10));
  }
} /* Output:
11111111111111111111111111111111
1111111111111111111111
1111111111111111111111111111111111111111111111111111111111111111
111111111111111111111111111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
11111111111111111111111111111111
1111111111111111111111
*///:~
