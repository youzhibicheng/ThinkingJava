package applications;

// FILE: PowerDemo.java
// This program illustrates the use of the power and pow method that uses
// recursion to calculate the value of a number raised to an integer power.

import java.io.IOException;
import edu.colorado.io.EasyReader ;

/******************************************************************************
* The <CODE>PowerDemo</CODE> Java application illustrates the use of
* the <CODE>power</CODE> and <CODE>pow</CODE> methods, which use recursion to 
* calculate the value of a number raised to an integer power.
*
* <p><dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../applications/PowerDemo.java">
*   http://www.cs.colorado.edu/~main/applications/PowerDemo.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jun 12, 1998
******************************************************************************/
public class PowerDemo
{
   /**
   * The <CODE>main</CODE> method activates <CODE>power</CODE> and 
   * <CODE>pow</CODE> with parameters that are provided by the user.
   * The <CODE>String</CODE> arguments (<CODE>args</CODE>) are not used
   * in this implementation.
   **/
   public static void main(String[ ] args)
   {
      EasyReader stdin = new EasyReader(System.in);
      int n;
      double x;
      
      System.out.println
      ("I can calculate the value of x raised to an integer power.");
      
      do
      {
         x = stdin.doubleQuery("The value of x: ");
         n = stdin.intQuery("The integer power: ");
         System.out.println("Answer using the power method: " + power(x,n));
         System.out.println("Answer using the pow   method: " + pow(x,n));
      }  while (stdin.query("Do you want to try other values?"));         
      
      System.out.println("Thank you beary much.");
   }
    

   /**
   * Computes the value of <CODE>x</CODE> raised to the <CODE>n</CODE> power.
   * @param <CODE>x</CODE>
   *   any <CODE>double</CODE> number
   * @param <CODE>n</CODE>
   *   the <CODE>int</CODE> power to raise <CODE>x</CODE> to
   * <dt><b>Precondition:</b><dd>
   *   If <CODE>x</CODE> is zero, then <CODE>n</CODE> must be positive.
   * @return
   *   <CODE>x</CODE> raised to the <CODE>n</CODE> power
   * @exception java.lang.IllegalArgumentException
   *   Indicates that <CODE>x</CODE> is zero and <CODE>n</CODE> is not positive.
   **/
   public static double power(double x, int n)
   {
      double product; // The product of x with itself n times
      int count;

      if (x == 0 && n <= 0)
         throw new IllegalArgumentException("x is zero and n=" + n);

      if (n >= 0)
      {
         product = 1;
         for (count = 1; count <= n; count++)
            product = product * x;
         return product;
      }
      else
         return 1/power(x, -n);
   }
   
   
   /**
   * Alternate implementation of the <CODE>power</CODE> method.
   **/
   public static double pow(double x, int n)
   {
      if (x == 0 && n <= 0)
         throw new IllegalArgumentException("x is zero and n=" + n);
      else if (n == 0)
         return 1;
      else if (n > 0)
         return x * pow(x, n-1);
      else // x is nonzero, and n is negative.
         return 1/pow(x, -n);
   }
    
}
