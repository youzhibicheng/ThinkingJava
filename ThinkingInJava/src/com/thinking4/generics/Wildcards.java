package com.thinking4.generics;
//: generics/Wildcards.java
// Exploring the meaning of wildcards.

public class Wildcards {
   // Raw argument:
  static void rawArgs(Holder holder, Object arg) {
     holder.set(arg); // Warning:
    //   Unchecked call to set(T) as a
    //   member of the raw type Holder
    // holder.set(new Wildcards()); // Same warning

    // Can't do this; don't have any 'T':
    // T t = holder.get();

    // OK, but type information has been lost:
    Object obj = holder.get();
  }	
  // Similar to rawArgs(), but errors instead of warnings:
  static void unboundedArg(Holder<?> holder, Object arg) {
//     holder.set(arg); // Error:
    //   set(capture of ?) in Holder<capture of ?>
    //   cannot be applied to (Object)
    // holder.set(new Wildcards()); // Same error

    // Can't do this; don't have any 'T':
    // T t = holder.get();

    // OK, but type information has been lost:
    Object obj = holder.get();
  }	
  static <T> T exact1(Holder<T> holder) {
    T t = holder.get();
    return t;
  }
  static <T> T exact2(Holder<T> holder, T arg) {
    holder.set(arg);
    T t = holder.get();
    return t;
  }
  static <T>
  T wildSubtype(Holder<? extends T> holder, T arg) {
//     holder.set(arg); // Error:
    //   set(capture of ? extends T) in
    //   Holder<capture of ? extends T>
    //   cannot be applied to (T)
	//即使是T的子类，也能转换成T
    T t = holder.get();
    return t;
  }	
  
  //? super T 语法将泛型类限制为所有T的超类（包括T自身），但只能用于参数中，不可以在返回值用加以限定。
//extends	向下限制
//super		向上限制,如<? super Double>，表示类型只能接受Double及其上层父类类型，如Number、Object类型的实例。
  /*
* 泛型的通配符(用于方法的参数)
* 1.<?> 允许所有泛型的引用调用
* 2.<? extends Number> 只允许泛型为Number及Number子类的引用调用
* 3.<? super Number> 只允许泛型为Number及Number父类的引用调用

Apple Orange 都继承自Fruit类,同时Jonathan是Apple的子类    
List<? extends Fruit> list = new ArrayList<Apple>();    
//list.add(new Apple());Error 为什么连Apple都不让放呢
//list.add(new Fruit());Error 已经表示好了只能放Apple了
   
List<? super Fruit> list = new ArrayList<Apple>();    
list.add(new Apple());//可以
list.add(new Fruit());//可以
   * */
  static <T>
  void wildSupertype(Holder<? super T> holder, T arg) {
    holder.set(arg);
    //可能会存在T的父类，很难保证能转换成T
    // T t = holder.get();  // Error:
    //   Incompatible types: found Object, required T

    // OK, but type information has been lost:
    Object obj = holder.get();
  }
  public static void main(String[] args) {
    Holder raw = new Holder<Long>();
    // Or:
    raw = new Holder();
    Holder<Long> qualified = new Holder<Long>();
    Holder<?> unbounded = new Holder<Long>();
    Holder<? extends Long> bounded = new Holder<Long>();
    Long lng = 1L;

    rawArgs(raw, lng);
    rawArgs(qualified, lng);
    rawArgs(unbounded, lng);
    rawArgs(bounded, lng);
	
    unboundedArg(raw, lng);
    unboundedArg(qualified, lng);
    unboundedArg(unbounded, lng);
    unboundedArg(bounded, lng);

     Object r1 = exact1(raw); // Warnings:
    //   Unchecked conversion from Holder to Holder<T>
    //   Unchecked method invocation: exact1(Holder<T>)
    //   is applied to (Holder)
    Long r2 = exact1(qualified);
    Object r3 = exact1(unbounded); // Must return Object
    Long r4 = exact1(bounded);
	
//     Long r5 = exact2(raw, lng); // Warnings:不是警告了，已经是出错了
    //   Unchecked conversion from Holder to Holder<Long>
    //   Unchecked method invocation: exact2(Holder<T>,T)
    //   is applied to (Holder,Long)
    Long r6 = exact2(qualified, lng);
//     Long r7 = exact2(unbounded, lng); // Error:
    //   exact2(Holder<T>,T) cannot be applied to
    //   (Holder<capture of ?>,Long)
    // Long r8 = exact2(bounded, lng); // Error:
    //   exact2(Holder<T>,T) cannot be applied
    //   to (Holder<capture of ? extends Long>,Long)
	
//     Long r9 = wildSubtype(raw, lng); // Warnings:不是警告了，已经是出错了
    //   Unchecked conversion from Holder
    //   to Holder<? extends Long>
    //   Unchecked method invocation:
    //   wildSubtype(Holder<? extends T>,T) is
    //   applied to (Holder,Long)
    Long r10 = wildSubtype(qualified, lng);
    // OK, but can only return Object:
    //这条语句暂时编译不过去
    //Object r11 = wildSubtype(unbounded, lng);
    Long r12 = wildSubtype(bounded, lng);
	
    // wildSupertype(raw, lng); // Warnings:
    //   Unchecked conversion from Holder
    //   to Holder<? super Long>
    //   Unchecked method invocation:
    //   wildSupertype(Holder<? super T>,T)
    //   is applied to (Holder,Long)
    wildSupertype(qualified, lng);
    // wildSupertype(unbounded, lng); // Error:
    //   wildSupertype(Holder<? super T>,T) cannot be
    //   applied to (Holder<capture of ?>,Long)
    // wildSupertype(bounded, lng); // Error:
    //   wildSupertype(Holder<? super T>,T) cannot be
    //  applied to (Holder<capture of ? extends Long>,Long)
  }
} ///:~
