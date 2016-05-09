package edu.colorado.ch08.recursive;

// File: WriteVertical.java
// A Java application to illustrate some first recursive methods
// that write the digits of a number vertically.
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/WriteVertical.html

import java.util.Scanner;

/******************************************************************************
* The <CODE>WriteVertical</CODE> Java application illustrates recursive
* methods that write the digits of a number vertically. 
*
* <p><dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../applications/WriteVertical.java">
*   http://www.cs.colorado.edu/~main/applications/WriteVertical.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jul 22, 2005
******************************************************************************/
public class WriteVertical 
{

   /**
   * The main method prompts the user for a number that is then printed
   * in two different ways using recursive methods. The <CODE>String</CODE>
   * argument (<CODE>args</CODE>) is not used in this implementation.
   **/
   public static void main(String[ ] args) 
   {
      Scanner stdin = new Scanner(System.in);
      int response;
      
      System.out.println("Please type an integer for me to display.");
      System.out.println("I will use writeVertical for non-negative values,");
      System.out.println("and I'll use superWriteVertical for negative values.");
      
      do
      {
	 System.out.print("Your value: ");
         response = stdin.nextInt( );
         if (response >= 0)
            writeVertical(response);
         else
            superWriteVertical(response);
      }  while (query(stdin, "Another number?"));         
      
      System.out.println("Think recursively!");
   }

   public static boolean query(Scanner input, String prompt)
   {
      String answer;
	
      System.out.print(prompt + " [Y or N]: ");
      answer = input.nextLine( ).toUpperCase( );
      while (!answer.startsWith("Y") && !answer.startsWith("N"))
      {
	 System.out.print("Invalid response. Please type Y or N: ");
	 answer = input.nextLine( ).toUpperCase( );
      }

      return answer.startsWith("Y");
   }
        
   /**
   * Print the digits of a non-negative integer vertically.
   * @param <CODE>number</CODE> 
   *   the number to be printed
   * <dt><b>Precondition:</b><dd>
   *   <CODE>n >= 0</CODE>. The method does not check the precondition, but
   *   the behavior is wrong for negative numbers.
   * <dt><b>Postcondition:</b><dd>
   *   The digits of <CODE>number</CODE> have been written, stacked vertically. 
   **/
   public static void writeVertical(int number)
   {
      if (number < 10)
         System.out.println(number);      // Write the one digit.
      else
      {
         writeVertical(number/10);     // Write all but the last digit.
         System.out.println(number % 10);   // Write the last digit.
      }
   }


   /**
   * Print the digits of an integer vertically.
   * @param <CODE>number</CODE> 
   *   the number to be printed
   * <dt><b>Postcondition:</b><dd>
   *   The digits of <CODE>number</CODE> have been written, stacked vertically. 
   *   If <CODE>number</CODE> is negative, then a negative sign appears on top.
   **/
   public static void superWriteVertical(int number)
   {
      if (number < 0)
      {
         System.out.println("-");               // Print a negative sign.
         superWriteVertical(-number);           // abs computes absolute value.
         // This is Spot #1 referred to in the text.
      }
      else if (number < 10) 
         System.out.println(number);            // Write the one digit.
      else
      {
         superWriteVertical(number/10);         // Write all but the last digit.
         // This is Spot #2 referred to in the text. 
         System.out.println(number % 10);       // Write the last digit.
      }
   }
    
}
