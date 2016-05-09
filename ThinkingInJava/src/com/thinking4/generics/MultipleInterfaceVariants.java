package com.thinking4.generics;
//: generics/MultipleInterfaceVariants.java
// {CompileTimeError} (Won't compile)

interface Payable<T> {}

class Employee implements Payable<Employee> {}
//下面这个语句执行不了，会有错误的
//class Hourly extends Employee
//  implements Payable<Hourly> {} ///:~
