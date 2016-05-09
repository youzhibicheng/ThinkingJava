//: annotations/Testable.java
package com.thinking4.annotations;
import com.thinking4.atunit.*;

public class Testable {
  public void execute() {
    System.out.println("Executing..");
  }
  @Test void testExecute() { execute(); }
} ///:~
