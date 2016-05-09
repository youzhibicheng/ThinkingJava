package com.thinking4.typeinfo;
//: typeinfo/ClassCasts.java

class Building {}
class House extends Building {}
class Test {}

public class ClassCasts {
  public static void main(String[] args) {
    Building b = new House();
    Class<House> houseType = House.class;
    House h = houseType.cast(b);
    h = (House)b; // ... or just do this.
    //类似于下面
    House h2 = (House)b;
    //第一种做法是什么时候用到呢？有什么好处呢?
    Test t = new Test();
    //编译能通过
    Class<House> houseType3 = House.class;
    House h3 = houseType.cast(t);
    //编译通不过
    //House h4 = (House)t;
  }
} ///:~
