package com.corejava7.stream;


import java.io.*;
import java.util.*;

class ObjectFileTest
{  
   public static void main(String[] args)
   {  
      Manager3 boss = new Manager3("Carl Cracker", 80000, 1987, 12, 15);
      boss.setBonus(5000);

      Employee3[] staff = new Employee3[3];

      staff[0] = boss;
      staff[1] = new Employee3("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee3("Tony Tester", 40000, 1990, 3, 15);
      
      try
      {  
         // save all Employee3 records to the file Employee3.dat
         ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\com\\thinking\\stream\\Employee3.dat"));
         out.writeObject(staff);
         out.close();

         // retrieve all records into a new array
         ObjectInputStream in =  new ObjectInputStream(new FileInputStream("src\\com\\thinking\\stream\\Employee3.dat"));
         Employee3[] newStaff = (Employee3[]) in.readObject();
         in.close();

         // print the newly read Employee3 records
         for (Employee3 e : newStaff)
            System.out.println(e);
      }
      catch (Exception e)
      {  
         e.printStackTrace(); 
      }
   }
}

class Employee3 implements Serializable
{
   public Employee3() {}

   public Employee3(String n, double s, int year, int month, int day)
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

class Manager3 extends Employee3
{  
   /**
      @param n the Employee3's name
      @param s the salary
      @param year the hire year
      @param month the hire month
      @param day the hire day
   */
   public Manager3(String n, double s, int year, int month, int day)
   {  
      super(n, s, year, month, day);
      bonus = 0;
   }

   public double getSalary()
   { 
      double baseSalary = super.getSalary();
      return baseSalary + bonus;
   }

   public void setBonus(double b)
   {  
      bonus = b;
   }

   public String toString()
   {
      return super.toString()
        + "[bonus=" + bonus
        + "]";
   }

   private double bonus;
}
