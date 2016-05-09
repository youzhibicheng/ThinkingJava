package com.thinking4.polymorphism;
//: polymorphism/PrivateOverride.java
// Trying to override a private method.
import static com.thinking4.util.Print.*;
//所有的private方法默认都是final的，不可继承
//如果在父类中有一样的定义，相当于是重定义，不是重写
public class PrivateOverride {
  private void f() { print("private f()"); }
  public static void main(String[] args) {
    PrivateOverride po = new Derived();
    po.f();
  }
}

class Derived extends PrivateOverride {
  public void f() { print("public f()"); }
} /* Output:
private f()
*///:~
