package com.thinking4.io;
//: io/FreezeAlien.java
// Create a serialized output file.
import java.io.*;

public class FreezeAlien {
  public static void main(String[] args) throws Exception {
    ObjectOutput out = new ObjectOutputStream(
      new FileOutputStream("src/com/thinking4/io/X.file"));
    Alien quellek = new Alien();
    out.writeObject(quellek);
  }
} ///:~
