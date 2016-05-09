package com.thinking.objclass;

public class StaticTest
{
   public static void main(String[] args)
   {
      // fill the staff array with three Employee objects
      Employee4[] staff = new Employee4[3];

      staff[0] = new Employee4("Tom", 40000);
      staff[1] = new Employee4("Dick", 60000);
      staff[2] = new Employee4("Harry", 65000);

      // print out information about all Employee4 objects
      for (Employee4 e : staff)
      {
         e.setId();
         System.out.println("name=" + e.getName()
            + ",id=" + e.getId()
            + ",salary=" + e.getSalary());
      }

      int n = Employee4.getNextId(); // calls static method
      System.out.println("Next available id=" + n);
   }
}

class Employee4
{
   public Employee4(String n, double s)
   {
      name = n;
      salary = s;
      id = 0;
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public int getId()
   {
      return id;
   }

   public void setId()
   {
      id = nextId; // set id to next available id
      nextId++;
   }

   public static int getNextId()
   {
      return nextId; // returns static field
   }

   public static void main(String[] args) // unit test
   {
      Employee4 e = new Employee4("Harry", 50000);
      System.out.println(e.getName() + " " + e.getSalary());
   }

   private String name;
   private double salary;
   private int id;
   private static int nextId = 1;
}
