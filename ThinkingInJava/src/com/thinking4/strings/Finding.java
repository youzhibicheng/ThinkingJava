package com.thinking4.strings;
//: strings/Finding.java
import java.util.regex.*;
import static com.thinking4.util.Print.*;

public class Finding {
  public static void main(String[] args) {
    Matcher m = Pattern.compile("\\w+")
      .matcher("   Evening is full of the linnet's wings");
    while(m.find())
      printnb(m.group() + " ");
    print();
    int i = 0;
    //这个地方稍微难以理解一点
    while(m.find(i)) {
      printnb(m.group() + " ");
      i++;
    }
    System.out.println();
    System.out.println("i = "+i);
  }
} /* Output:
Evening is full of the linnet s wings
Evening vening ening ning ing ng g is is s full full ull ll l of of f the the he e linnet linnet innet nnet net et t s s wings wings ings ngs gs s
i = 40
*///:~
