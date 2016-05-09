// File: FormatWriter.java from the package edu.colorado.io
// Complete documentation is available from the FormatWriter link in:
//   http://www.cs.colorado.edu/~main/docs
package edu.colorado.io;

import java.text.NumberFormat;

/******************************************************************************
* The <CODE>FormatWriter</CODE> class has a collection of static methods for
* writing formatted output to System.out.
* 
* <dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/io/FormatWriter.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/io/FormatWriter.java
*   </A>
*
* @author 
*   Michael Main (main@colorado.edu) with help from Judy Abbott.
*
* @version
*   Jan 22, 1999
*
* @see EasyReader
******************************************************************************/
public class FormatWriter 
{

   // Note: getNumberInstance( ) creates a NumberFormat object using local
   // information about the characters for a decimal point and separators.
   private static NumberFormat form = NumberFormat.getNumberInstance( );
   
   
   /**
   * Make the computation pause for a specified number of milliseconds.
   * @param <CODE>milliseconds</CODE>
   *   the number of milliseconds to pause
   * <dt><b>Postcondition:</b><dd>
   *   The computation has paused for the specified time.
   **/
   public static void pause(long milliseconds)
   {
      try
      {
         Thread.sleep(milliseconds);
      }
      catch (InterruptedException e)
      {
         // Resume execution
      }
   }
   
   
   /**
   * Print a number to </CODE>System.out</CODE>, using a specified format.
   * @param <CODE>d</CODE>
   *   the number to be printed
   * @param <CODE>minimumWidth</CODE>
   *   the minimum number of characters in the entire output
   * @param <CODE>fractionDigits</CODE>
   *   the number of digits to print on the right side of the decimal point
   * <dt><b>Precondition:</b><dd>
   *   <CODE>fractionDigits</CODE> is not negative.
   * <dt><b>Postcondition:</b><dd>
   *   The number <CODE>d</CODE> has been printed to <CODE>System.out</CODE>.
   *   This printed number is rounded to the specified number of digits on the
   *   right of the decimal. If <CODE>fractionDigits</CODE> is 0, then only the
   *   integer part of <CODE>d</CODE> is printed. If necessary, spaces appear
   *   at the front of the number to raise the total number of printed
   *   characters to the minimum. Additional formatting details are obtained
   *   from the current locale. For example, in the United States, a period is
   *   used for the decimal and commas are used to separate groups of
   *   integer digits.
   * @exception <CODE>IllegalArgumentException</CODE>
   *   Indicates that <CODE>fractionDigits</CODE> is negative.
   * <dt><b>Example:</b><dd>
   *   <CODE>printNumber(12345.27, 8, 1);
   *   <BR>
   *   Prints 12,345.3 in the U.S.
   **/
   public static void printNumber(double d, int minimumWidth, int fractionDigits)
   {
      String output;
      int i;

      // Set the number of digits to appear on the right of the decimal.
      if (fractionDigits < 0)
         throw new IllegalArgumentException("fractionDigits < 0:" + fractionDigits);
      form.setMinimumFractionDigits(fractionDigits);
      form.setMaximumFractionDigits(fractionDigits);
        
      // Round and format the number.
      output = form.format(d);
            
      printRight(output, minimumWidth);
   }


   /**
   * Print an <CODE>Object</CODE> (such as a <CODE>String</CODE>) to 
   * <CODE>System.out</CODE>, using left justification.
   * @param <CODE>output</CODE>
   *   the Object to be printed
   * @param <CODE>minimumWidth</CODE>
   *   the minimum number of characters in the entire output
   * <dt><b>Postcondition:</b><dd>
   *   The <CODE>Object</CODE> has been printed to <CODE>System.out</CODE>.
   *   If necessary, spaces appear
   *   at the front of the Object to raise the total number of printed
   *   characters to the minimum.
   * <dt><b>Example:</b><dd>
   *   <CODE>printNumber("Foo", 8);
   *   <BR>
   *   Prints "Foo     " (with 5 spaces).
   **/
   public static void printLeft(Object output, int minimumWidth)
   {
      int i;
      String s = output.toString( );
         
      // Print any trailing spaces and the Object itself.
      System.out.print(s);   
      for (i = s.length( ); i < minimumWidth; i++)
         System.out.print(' ');

   }
     
        
   
   /**                    
   * Print an <CODE>Object</CODE> (such as a <CODE>String</CODE>) to 
   * <CODE>System.out</CODE>, using right justification.
   * @param <CODE>output</CODE>
   *   the Object to be printed
   * @param <CODE>minimumWidth</CODE>
   *   the minimum number of characters in the entire output
   * <dt><b>Postcondition:</b><dd>
   *   The <CODE>Object</CODE> has been printed to <CODE>System.out</CODE>.
   *   If necessary, spaces appear
   *   at the front of the Object to raise the total number of printed
   *   characters to the minimum.
   * <dt><b>Example:</b><dd>
   *   <CODE>printNumber("Foo", 8);
   *   <BR>
   *   Prints "     Foo" (with 5 spaces).
   **/
   public static void printRight(Object output, int minimumWidth)
   {
      int i;
      String s = output.toString( );
            
      // Print any leading spaces and the Object itself.
      for (i = s.length( ); i < minimumWidth; i++)
         System.out.print(' ');
      System.out.print(s);
   }
     
     
   /**
   * Print a whole number to </CODE>System.out</CODE>, using a specified format.
   * @param <CODE>d</CODE>
   *   the number to be printed
   * @param <CODE>minimumWidth</CODE>
   *   the minimum number of characters in the entire output
   * <dt><b>Postcondition:</b><dd>
   *   The number <CODE>n</CODE> has been printed to <CODE>System.out</CODE>.
   *   If necessary, spaces appear
   *   at the front of the number to raise the total number of printed
   *   characters to the minimum. Additional formatting details are obtained
   *   from the current locale. For example, in the United States
   *   commas are used to separate groups of
   *   integer digits.
   * <dt><b>Example:</b><dd>
   *   <CODE>printNumber(12345, 8);
   *   <BR>
   *   Prints "  12,345" in the U.S. (with 2 spaces in front)
   **/
   public static void printWhole(long n, int minimumWidth)
   {
      String output;
        
      // Format the number.
      output = form.format(n);
            
      // Print any leading spaces and the number itself.
      printRight(output, minimumWidth);
   }
   
   
   /**
   * A demonstration program.
   * To run the demonstration: 
   * <BR><CODE>java edu.colorado.io.FormatWriter</CODE>
   **/
   public static void main(String[ ] args)
   { 
      System.out.println("Each example has output between the square brackets.");
      System.out.println( );
            
      System.out.print("Output of printNumber(12345.27, 8, 1) is: [");
      printNumber(12345.27, 8, 1);
      System.out.println(']');
      
      System.out.print("Output of printNumber(12345.22, 8, 1) is: [");
      printNumber(12345.22, 8, 1);
      System.out.println(']');
      
      System.out.print("Output of printNumber(-2345.27, 8, 1) is: [");
      printNumber(-2345.27, 8, 1);
      System.out.println(']');
      
      System.out.print("Output of printNumber(-2345.22, 8, 1) is: [");
      printNumber(-2345.22, 8, 1);
      System.out.println(']');
      
      System.out.print("Output of printNumber(-2345.22, 8, 0) is: [");
      printNumber(-2345.22, 8, 0);
      System.out.println(']');
      
      System.out.print("Output of printLeft(\"Foo\", 8) is:         [");
      printLeft("Foo", 8);
      System.out.println(']');

      System.out.print("Output of printRight(\"Foo\", 8) is:        [");
      printRight("Foo", 8);
      System.out.println(']');

      System.out.print("Output of printWhole(12345, 8) is:        [");
      printWhole(12345, 8);
      System.out.println(']');
   }
   
    
}
