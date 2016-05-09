package com.thinking.interfaces;

import java.util.*;

public class CloneTest
{  
   public static void main(String[] args)
   {  
      try
      {
         Employee2 original = new Employee2("John Q. Public", 50000); 
         original.setHireDay(2000, 1, 1);
         Employee2 copy = original.clone();
         copy.raiseSalary(10);
         copy.setHireDay(2002, 12, 31);
         System.out.println("original=" + original);
         System.out.println("copy=" + copy);
      }
      catch (CloneNotSupportedException e) 
      { 
         e.printStackTrace(); 
      }
   }
}

class Employee2 implements Cloneable
{  
   public Employee2(String n, double s)
   {  
      name = n;
      salary = s;
   }

   public Employee2 clone() throws CloneNotSupportedException
   {
      // call Object.clone()
	  //通过这种方法，salary复制了值
	  //name和hireDay复制了引用,指向同一个对象
      Employee2 cloned = (Employee2)super.clone(); 
      
      // clone mutable fields
      //因为String是不变对象，所以不会因为变化导致的不一致
      //只需要复制hireDay的值就可以了
      cloned.hireDay = (Date)hireDay.clone();
      
      return cloned;
   }

   /**
      Set the hire day to a given date
      @param year the year of the hire day
      @param month the month of the hire day
      @param day the day of the hire day
   */
   public void setHireDay(int year, int month, int day)
   {
      hireDay = new GregorianCalendar(year, month - 1, day).getTime();
   }

   public void raiseSalary(double byPercent)
   {  
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   public String toString()
   {
      return "Employee2[name=" + name
         + ",salary=" + salary
         + ",hireDay=" + hireDay
         + "]";
   }

   private String name;
   private double salary;
   private Date hireDay;
}
