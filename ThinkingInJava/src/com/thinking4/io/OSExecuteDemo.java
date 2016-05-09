package com.thinking4.io;
//: io/OSExecuteDemo.java
// Demonstrates standard I/O redirection.
import com.thinking4.util.*;

public class OSExecuteDemo {
  public static void main(String[] args) {
    OSExecute.command("javap com/thinking4/io/OSExecuteDemo");
  }
} /* Output:
Compiled from "OSExecuteDemo.java"
public class OSExecuteDemo extends java.lang.Object{
    public OSExecuteDemo();
    public static void main(java.lang.String[]);
}
*///:~
