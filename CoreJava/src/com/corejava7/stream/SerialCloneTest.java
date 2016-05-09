package com.corejava7.stream;

import java.io.*;
import java.util.*;

public class SerialCloneTest
{  
   public static void main(String[] args)
   {  
      Employee5 harry = new Employee5("Harry Hacker", 35000, 1989, 10, 1);
      // clone harry
      Employee5 harry2 = (Employee5) harry.clone();

      // mutate harry
      harry.raiseSalary(10);

      // now harry and the clone are different
      System.out.println(harry);
      System.out.println(harry2);
   }
}

/**
   A class whose clone method uses serialization.
*/
class SerialCloneable implements Cloneable, Serializable
{  
   public Object clone()
   {  
      try
      {  
         // save the object to a byte array
         ByteArrayOutputStream bout = new ByteArrayOutputStream();
         ObjectOutputStream out = new ObjectOutputStream(bout);
         out.writeObject(this);
         out.close();

         // read a clone of the object from the byte array
         ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
         ObjectInputStream in = new ObjectInputStream(bin);
         Object ret = in.readObject();
         in.close();

         return ret;
      }  
      catch (Exception e)
      {  
         return null;
      }
   }
}

/**
   The familiar Employee5 class, redefined to extend the
   SerialCloneable class. 
*/
class Employee5 extends SerialCloneable
{  
   public Employee5(String n, double s, int year, int month, int day)
   {  
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
      hireDay = calendar.getTime();
   }

   public String getName()
   {  
      return name;
   }

   public double getSalary()
   {  
      return salary;
   }

   public Date getHireDay()
   {  
      return hireDay;
   }

   public void raiseSalary(double byPercent)
   {  
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   public String toString()
   {  
      return getClass().getName()
         + "[name=" + name
         + ",salary=" + salary
         + ",hireDay=" + hireDay
         + "]";
   }

   private String name;
   private double salary;
   private Date hireDay;
}
 


