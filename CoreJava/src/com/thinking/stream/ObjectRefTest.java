package com.thinking.stream;


import java.io.*;
import java.util.*;

class ObjectRefTest
{  
   public static void main(String[] args)
   {  
      Employee4 harry = new Employee4("Harry Hacker", 50000, 1989, 10, 1);
      Manager4 boss = new Manager4("Carl Cracker", 80000, 1987, 12, 15);
      boss.setSecretary(harry);

      Employee4[] staff = new Employee4[3];

      staff[0] = boss;
      staff[1] = harry;
      staff[2] = new Employee4("Tony Tester", 40000, 1990, 3, 15);
      
      try
      {  
         // save all Employee4 records to the file Employee4.dat
         ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\com\\thinking\\stream\\Employee4.dat"));
         out.writeObject(staff);
         out.close();

         // retrieve all records into a new array
         ObjectInputStream in =  new ObjectInputStream(new FileInputStream("src\\com\\thinking\\stream\\Employee4.dat"));
         Employee4[] newStaff = (Employee4[]) in.readObject();
         in.close();

         // raise secretary's salary
         newStaff[1].raiseSalary(10); 

         // print the newly read Employee4 records
         for (Employee4 e : newStaff)
            System.out.println(e);
      }
      catch (Exception e)
      {  
         e.printStackTrace(); 
      }
   }
}

class Employee4 implements Serializable
{
   public Employee4() {}

   public Employee4(String n, double s, int year, int month, int day)
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

class Manager4 extends Employee4
{  
   /**
      Constructs a Manager4 without a secretary
      @param n the Employee4's name
      @param s the salary
      @param year the hire year
      @param month the hire month
      @param day the hire day
   */
   public Manager4(String n, double s, int year, int month, int day)
   {  
      super(n, s, year, month, day);
      secretary = null;
   }

   /**
      Assigns a secretary to the Manager4.
      @param s the secretary
   */
   public void setSecretary(Employee4 s)
   {  
      secretary = s;
   }

   public String toString()
   {
      return super.toString()
        + "[secretary=" + secretary
        + "]";
   }

   private Employee4 secretary;
}

