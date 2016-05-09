package com.corejava7.inheritance;

import java.util.*;

public class ManagerTest
{  
   public static void main(String[] args)
   {  
      // construct a Manager object
      Manager3 boss = new Manager3("Carl Cracker", 80000, 1987, 12, 15);
      boss.setBonus(5000);

      Employee3[] staff = new Employee3[3];

      // fill the staff array with Manager3 and Employee3 objects

      staff[0] = boss;
      staff[1] = new Employee3("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee3("Tommy Tester", 40000, 1990, 3, 15);

      // print out information about all Employee3 objects
      for (Employee3 e : staff)
         System.out.println("name=" + e.getName()
            + ",salary=" + e.getSalary());
   }
}

class Employee3
{  
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

   private double bonus;
}


