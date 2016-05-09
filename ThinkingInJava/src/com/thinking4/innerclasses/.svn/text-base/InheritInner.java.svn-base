package com.thinking4.innerclasses;
//: innerclasses/InheritInner.java
// Inheriting an inner class.

class WithInner {
  class Inner {}
}

public class InheritInner extends WithInner.Inner {
	//初始化类，首先要初始化父类
	//因为父类是内部类，所以必须先初始化外部类才能初始化内部类
	//这样的话，必须传递一个参数用来初始化父类的外部类
  //! InheritInner() {} // Won't compile
  InheritInner(WithInner wi) {
    wi.super();
  }
  public static void main(String[] args) {
    WithInner wi = new WithInner();
    InheritInner ii = new InheritInner(wi);
  }
} ///:~
