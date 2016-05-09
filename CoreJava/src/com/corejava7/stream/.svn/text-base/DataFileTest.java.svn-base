package com.thinking.stream;

import java.io.*;
import java.util.*;

public class DataFileTest
{
   public static void main(String[] args)
   {
      Employee1[] staff = new Employee1[3];

      staff[0] = new Employee1("Carl Cracker", 75000, 1987, 12, 15);
      staff[1] = new Employee1("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee1("Tony Tester", 40000, 1990, 3, 15);

      try
      {
         // save all Employee1 records to the file Employee1.dat
         PrintWriter out = new PrintWriter(new FileWriter("src\\com\\thinking\\stream\\Employee1.dat"));
         writeData(staff, out);
         out.close();

         // retrieve all records into a new array
         BufferedReader in = new BufferedReader(new FileReader("src\\com\\thinking\\stream\\Employee1.dat"));
         Employee1[] newStaff = readData(in);
         in.close();

         // print the newly read Employee1 records
         for (Employee1 e : newStaff)
            System.out.println(e);
      }
      catch(IOException exception)
      {
         exception.printStackTrace();
      }
   }

   /**
      Writes all Employee1s in an array to a print writer
      @param Employee1s an array of Employee1s
      @param out a print writer
   */
   static void writeData(Employee1[] Employee1s, PrintWriter out)
      throws IOException
   {
      // write number of Employee1s
      out.println(Employee1s.length);

      for (Employee1 e : Employee1s)
         e.writeData(out);
   }

   /**
      Reads an array of Employee1s from a buffered reader
      @param in the buffered reader
      @return the array of Employee1s
   */
   static Employee1[] readData(BufferedReader in)
      throws IOException
   {
      // retrieve the array size
      int n = Integer.parseInt(in.readLine());

      Employee1[] Employee1s = new Employee1[n];
      for (int i = 0; i < n; i++)
      {
         Employee1s[i] = new Employee1();
         Employee1s[i].readData(in);
      }
      return Employee1s;
   }
}

class Employee1
{
   public Employee1() {}

   public Employee1(String n, double s, int year, int month, int day)
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

   /**
      Writes Employee1 data to a print writer
      @param out the print writer
   */
   public void writeData(PrintWriter out) throws IOException
   {
      GregorianCalendar calendar = new GregorianCalendar();
      calendar.setTime(hireDay);
      out.println(name + "|"
         + salary + "|"
         + calendar.get(Calendar.YEAR) + "|"
         + (calendar.get(Calendar.MONTH) + 1) + "|"
         + calendar.get(Calendar.DAY_OF_MONTH));
   }

   /**
      Reads Employee1 data from a buffered reader
      @param in the buffered reader
   */
   public void readData(BufferedReader in) throws IOException
   {
      String s = in.readLine();
      StringTokenizer t = new StringTokenizer(s, "|");
      name = t.nextToken();
      salary = Double.parseDouble(t.nextToken());
      int y = Integer.parseInt(t.nextToken());
      int m = Integer.parseInt(t.nextToken());
      int d = Integer.parseInt(t.nextToken());
      GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
      hireDay = calendar.getTime();
   }

   private String name;
   private double salary;
   private Date hireDay;
}

