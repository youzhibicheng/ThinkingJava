package com.thinking4.polymorphism;
//: polymorphism/FieldAccess.java
// Direct field access is determined at compile time.

class Super {
  public int field = 0;
  public int getField() { return field; }
}

class Sub extends Super {
  public int field = 1;
  public int getField() { return field; }
  public int getSuperField() { return super.field; }
}

public class FieldAccess {
  public static void main(String[] args) {
    Super sup = new Sub(); // Upcast
    //向上转型了，这个时候得到的是父类的field
    //只有方法的override和多态，并没有field的
    System.out.println("sup.field = " + sup.field +	
      ", sup.getField() = " + sup.getField());
    Sub sub = new Sub();
    System.out.println("sub.field = " +
      sub.field + ", sub.getField() = " +
      sub.getField() +
      ", sub.getSuperField() = " +
      sub.getSuperField());
  }
} /* Output:
sup.field = 0, sup.getField() = 1	//这里的sup.field = 0比较奇怪
sub.field = 1, sub.getField() = 1, sub.getSuperField() = 0
*///:~
