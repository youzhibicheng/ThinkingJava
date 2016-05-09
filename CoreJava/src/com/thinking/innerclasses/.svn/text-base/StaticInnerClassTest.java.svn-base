package com.thinking.innerclasses;

public class StaticInnerClassTest
{  
   public static void main(String[] args)
   {  
      double[] d = new double[20];
      for (int i = 0; i < d.length; i++)
         d[i] = 100 * Math.random();
      ArrayAlg.Pair p = ArrayAlg.minmax(d);
      System.out.println("min = " + p.getFirst());
      System.out.println("max = " + p.getSecond());
      //ArrayAlg.Pair p2 = new ArrayAlg.Pair(1,4);
      //System.out.println("min2 = " + p2.getFirst());
      //System.out.println("max2 = " + p2.getSecond());
   }
}

class ArrayAlg
{  
   /**
      A pair of floating point numbers
      Pair类不需要引用任何其他的对象，所以定义成static类
      只有内部类才可以声明成static
   */
   public static class Pair
   { 
      /** 
          Constructs a pair from two floating point numbers
          @param f the first number
          @param s the second number
          我觉得这个地方构造函数改成private更加适合一些
          如果是public，我们可以通过ArrayAlg.Pair p2 = new ArrayAlg.Pair(1,4);方式构造对象
          如果是public，我们只能通过ArrayAlg.Pair p = ArrayAlg.minmax(d);获得对喜爱那个
      */
      public Pair(double f, double s)
      {  
         first = f;
         second = s;
      }

      /**
         Returns the first number of the pair
         @return the first number
      */
      public double getFirst()
      {  
         return first;
      }

      /**
         Returns the second number of the pair
         @return the second number
      */
      public double getSecond()
      {  
         return second;
      }

      private double first;
      private double second;
   }

   /**
      Computes both the minimum and the maximum of an array 
      @param values an array of floating point numbers
      @return a pair whose first element is the minimum and whose
      second element is the maximum
   */
   public static Pair minmax(double[] values)
   {  
      double min = Double.MAX_VALUE;
      double max = Double.MIN_VALUE;
      for (double v : values)
      {  
         if (min > v) min = v;
         if (max < v) max = v;
      }
      return new Pair(min, max);
   }
}
