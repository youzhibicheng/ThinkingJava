package com.thinking4.strings;
//: strings/ReFlags.java
import java.util.regex.*;
/*
 * Pattern.CASE_INSENSITIVE		?i	大小写不敏感
 * Pattern.MULTILINE			?m	多行模式，^/$匹配一行开始和结束
 * */
public class ReFlags {
  public static void main(String[] args) {
    Pattern p =  Pattern.compile("^java",
      Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    Matcher m = p.matcher(
      "java has regex\nJava has regex\n" +
      "JAVA has pretty good regular expressions\n" +
      "Regular expressions are in Java");
    while(m.find())
      System.out.println(m.group());
  }
} /* Output:
java
Java
JAVA
*///:~
