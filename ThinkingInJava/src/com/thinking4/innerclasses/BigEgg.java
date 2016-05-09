package com.thinking4.innerclasses;
//: innerclasses/BigEgg.java
// An inner class cannot be overriden like a method.
import static com.thinking4.util.Print.*;
//注释掉的那些都是新加的
class Egg {
  private Yolk y;
  protected class Yolk {
    public Yolk() { print("Egg.Yolk()"); }
    //public String toString(){ return "Egg.Yolk"; }
  }
  public Egg() {
    print("New Egg()");
    y = new Yolk();
  }
  public String toString(){ return "Egg."+y.toString() ; }
}	

public class BigEgg extends Egg {
  //private Yolk y = new Yolk();
  public class Yolk {
    public Yolk() { print("BigEgg.Yolk()"); }
    //public String toString(){ return "BigEgg.Yolk"; }
  }
  //public String toString(){ return "BigEgg."+y.toString() ; }
  public static void main(String[] args) {
	new BigEgg();
    //Egg egg = new BigEgg();
    //System.out.println(egg);
    //如何才能调用到父类的toString方法呢?
    //System.out.println( );
  }
} /* Output:
New Egg()
Egg.Yolk()
*///:~

/*
New Egg()
Egg.Yolk()
BigEgg.Yolk()
BigEgg.BigEgg.Yolk
 * */