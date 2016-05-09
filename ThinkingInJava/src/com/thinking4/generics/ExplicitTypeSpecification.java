package com.thinking4.generics;
//: generics/ExplicitTypeSpecification.java
import com.thinking4.typeinfo.pets.*;
import java.util.*;
import com.thinking4.util.*;

public class ExplicitTypeSpecification {
  static void f(Map<Person, List<Pet>> petPeople) {}
  public static void main(String[] args) {
    f(New.<Person, List<Pet>>map());
  }
} ///:~
