package com.thinking4.generics;
//: generics/Manipulation.java
// {CompileTimeError} (Won't compile)

class Manipulator<T> {
  private T obj;
  public Manipulator(T x) { obj = x; }
  
  
  public void manipulate() {
	  //使用西面的语句将产生错误
	  //Error: cannot find symbol: method f():
	  //obj.f(); 
  }
}

public class Manipulation {
  public static void main(String[] args) {
    HasF hf = new HasF();
    Manipulator<HasF> manipulator =
      new Manipulator<HasF>(hf);
    manipulator.manipulate();
  }
} ///:~
