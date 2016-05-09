//: interfaces/interfaceprocessor/Apply.java
package com.thinking4.interfaces.interfaceprocessor;
import static com.thinking4.util.Print.*;
/*
 * 参考com.thinking4.interfaces.classprocessor.Apply类
 * 当我们无法修改Apply的方法接受
 * public static void process(Filter p, Object s)
 * 但我们却想调用Filter的process方法的时候，我们会想用一个适配器类去适配Filter类
 * */
public class Apply {
  public static void process(Processor p, Object s) {
    print("Using Processor " + p.name());
    print(p.process(s));
  }
} ///:~
