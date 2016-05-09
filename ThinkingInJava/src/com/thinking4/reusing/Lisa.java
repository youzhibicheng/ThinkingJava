package com.thinking4.reusing;
//: reusing/Lisa.java
// {CompileTimeError} (Won't compile)

class Lisa extends Homer {
  //有了override就不行，因为父类的doh(Milhouse m)是final的，这里相当于新建了一个方法
  //@Override 
  void doh(Milhouse m) {
    System.out.println("doh(Milhouse)");
  }
} ///:~
