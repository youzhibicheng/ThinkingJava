package com.thinking.objclass;

import java.util.*;

public class EmployeeTest
{  
   public static void main(String[] args)
   {  
      // fill the staff array with three Employee2 objects
      Employee2[] staff = new Employee2[3];

      staff[0] = new Employee2("Carl Cracker", 75000, 1987, 12, 15);
      staff[1] = new Employee2("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee2("Tony Tester", 40000, 1990, 3, 15);

      // raise everyone's salary by 5%
      for (Employee2 e : staff)
         e.raiseSalary(5);

      // print out information about all Employee2 objects
      for (Employee2 e : staff)
         System.out.println("name=" + e.getName()
            + ",salary=" + e.getSalary()
            + ",hireDay=" + e.getHireDay());
   }
}

class Employee2
{  
   public Employee2(String n, double s, int year, int month, int day)
   {  
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
         // GregorianCalendar uses 0 for January
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
