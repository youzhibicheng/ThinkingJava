package com.corejava7.innerclasses;

import java.lang.reflect.*;
import java.util.*;

public class ProxyTest
{  
   public static void main(String[] args)
   {  
      Object[] elements = new Object[1000];

      // fill elements with proxies for the integers 1 ... 1000
      // elements里面存放的全部是代理对象
      // 代理对象的调用处理器的值是1...1000
      for (int i = 0; i < elements.length; i++)
      {
         Integer value = i + 1;
         Class[] interfaces = value.getClass().getInterfaces();
         InvocationHandler handler = new TraceHandler(value);
         Object proxy = Proxy.newProxyInstance(null,
            interfaces, handler);
         elements[i] = proxy;
      }
      System.out.println("---finish construct elements---");
      // construct a random integer
      Integer key = new Random().nextInt(elements.length) + 1;

      // search for the key
      System.out.println("---begin search for the key---");
      //binarySearch一次次的调用compareTo的方法进行比较查找
      //每调用一次compareTo方法，就需要调用一次TraceHandler的invoke方法
      int result = Arrays.binarySearch(elements, key);
      System.out.println("---finish search for the key---");

      // print match if found
      if (result >= 0) System.out.println("find result = "+elements[result]);
   }
}

/**
   An invocation handler that prints out the method name
   and parameters, then invokes the original method
*/
class TraceHandler implements InvocationHandler
{ 
   /**
      Constructs a TraceHandler
      @param t the implicit parameter of the method call
   */
   public TraceHandler(Object t)
   {  
      target = t;
   }

   public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
   {  
      // print implicit argument
      System.out.print(target);
      // print method name
      System.out.print("." + m.getName() + "(");
      // print explicit arguments
      if (args != null)
      {
         for (int i = 0; i < args.length; i++)
         {  
            System.out.print(args[i]);
            if (i < args.length - 1)
               System.out.print(", ");
         }
      }
      System.out.println(")");

      // invoke actual method
      return m.invoke(target, args);
   }

   private Object target;
}
