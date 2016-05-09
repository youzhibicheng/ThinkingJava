// File: Statistician.java
// This is an assignment for students to complete after reading Chapter 2 of
// "Data Structures and Other Objects Using Java" by Michael Main.

// Check with your instructor to see whether you should put this class in
// a package. At the moment, it is declared as part of edu.colorado.homework:
package edu.colorado.homework;

/******************************************************************************
* This class is a homework assignment;									       
* A <CODE>Statistician</CODE> keeps track of statistics about a sequence of
* double numbers.
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* <dt><b>Outline of Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/homework/Statistician.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/homework/Statistician.java
*   </A>
*
* @version
*   Jan 24, 1999
******************************************************************************/
public class Statistician
{   
   /**
   * Initialize a new Statistician.  
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   This Statistician is newly initialized and has not yet been given any 
   *   numbers.
   **/   
   public Statistician( )
   {
      // Student implementation.      
   }        


   /**
   * Add the numbers of another Statistician to this Statistician.
   * @param <CODE>addend</CODE>
   *   a Statistician whose numbers will be added to this Statistician
   * <dt><b>Precondition:</b><dd>
   *   The parameter, <CODE>addend</CODE>, is not null. 
   * <dt><b>Postcondition:</b><dd>
   *   The numbers from <CODE>addend</CODE> have been added to this
   *   Statistician. After the operation, this Statistician acts as if
   *   if was given all of its numbers and also given all of the numbers
   *   from the addend.
   * @exception NullPointerException
   *   Indicates that <CODE>addend</CODE> is null. 
   **/
   public void addAll(Statistician addend)
   {
      // Student implementation.
   }   
   
   
   /**
   * Clear this Statistician. 
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   This Statistician is reinitialized as if it has never been given any 
   *   numbers.
   **/
   public void clear( )
   {
      // Student implementation.
   }


   /**
   * Compare this <CODE>Statistician</CODE> to another object for equality.
   * @param <CODE>obj</CODE>
   *   an object with which this <CODE>Statistician</CODE> will be compared
   * @return
   *   A return value of <CODE>true</CODE> indicates that 
   *   <CODE>obj</CODE> refers to a 
   *   <CODE>Statistican</CODE> object with the same length, sum, mean,
   *   minimum and maximum as this 
   *   <CODE>Statistician</CODE>. Otherwise the return value is 
   *   <CODE>false</CODE>.
   * <dt><b>Note:</b><dt>
   *   If <CODE>obj</CODE> is null or does not refer to a 
   *   <CODE>Statistician</CODE> object, then the answer is 
   *   <CODE>false</CODE>.
   **/   
   public boolean equals(Object obj)
   {
      // The student's code will replace this return statement:
      return false;
   } 
   
   
   /**
   * Determine how many numbers have been given to this Statistician.
   * @param - none
   * @return
   *   the count of how many numbers have been given to this Statistician
   *   since it was initialized or reinitialized.
   * <dt><b>Note:</b><dd>
   *   Giving a Statistician more than
   *   <CODE>Integer.MAX_VALUE</CODE> numbers, will
   *   cause failure with an arithmetic overflow.
   **/ 
   public int length( )
   {
      // The student's code will replace this return statement:
      return 0;
   }


   /**
   * Determine the largest number that has been given 
   * to this Statistician.
   * @param - none
   * @return
   *   the largest number that has been given to this 
   *   Statistician
   *   since it was initialized or reinitialized.
   * <dt><b>Note:</b><dd>
   *   If <CODE>length()</CODE> is zero, then the answer from this method
   *   is <CODE>Double.NaN</CODE>.
   **/ 
   public double maximum( )
   {
      // The student's code will replace this return statement:
      return 0;
   }


   /**
   * Determine the arithmetic average of all the numbers that have been given 
   * to this Statistician.
   * @param - none
   * @return
   *   the arithmetic mean of all the number that have been given to this 
   *   Statistician
   *   since it was initialized or reinitialized.
   * <dt><b>Note:</b><dd>
   *   If this Statistician has been given more than
   *   <CODE>Integer.MAX_VALUE</CODE> numbers, then this method fails
   *   because of arithmetic overflow.
   *   If <CODE>length()</CODE> is zero, then the answer from this method
   *   is <CODE>Double.NaN</CODE>.
   *   If <CODE>sum()</CODE> exceeds the bounds of double numbers, then the 
   *   answer from this method may be 
   *   <CODE>Double.POSITIVE_INFINITY</CODE> or
   *   <CODE>Double.NEGATIVE_INFINITY</CODE>.
   **/ 
   public double mean( )
   {
      // The student's code will replace this return statement:
      return 0;
   }


   /**
   * Determine the smallest number that has been given 
   * to this Statistician.
   * @param - none
   * @return
   *   the smallest number that has been given to this 
   *   Statistician
   *   since it was initialized or reinitialized.
   * <dt><b>Note:</b><dd>
   *   If <CODE>length()</CODE> is zero, then the answer from this method
   *   is <CODE>Double.NaN</CODE>.
   **/ 
   public double minimum( )
   {
      // The student's code will replace this return statement:
      return 0;
   }


   /**
   * Give a new number to this Statistician. 
   * @param <CODE>number</CODE>
   *   the new number that is being given the this Statistician
   * <dt><b>Postcondition:</b><dd>
   *   The specified number has been given to this Statistician and
   *   it will be included in any subsequent statistics.
   **/
   public void next(double number)
   {
      // Student implementation.
   }


   /**
   * Determine the sum of all the numbers that have been given to this 
   * Statistician.
   * @param - none
   * @return
   *   the sum of all the number that have been given to this 
   *   Statistician
   *   since it was initialized or reinitialized.
   * <dt><b>Note:</b><dd>
   *   If the sum exceeds the bounds of double numbers, then the answer
   *   from this method may be 
   *   <CODE>Double.POSITIVE_INFINITY</CODE> or
   *   <CODE>Double.NEGATIVE_INFINITY</CODE>.
   **/ 
   public double sum( )
   {
      // The student's code will replace this return statement:
      return 0;
   }


   /**
   * Create a new Statistician that behaves as if it was given all the
   * numbers from two other bags.
   * @param <CODE>s1</CODE>
   *   the first of two Statisticians
   * @param <CODE>s2</CODE>
   *   the second of two Statisticians
   * <dt><b>Precondition:</b><dd>
   *   Neither s1 nor s2 is null.
   * @return
   *   a new Statistician that acts as if it was given all the numbers from
   *   s1 and s2.
   * @exception NullPointerException.
   *   Indicates that one of the arguments is null.
   **/   
   public static Statistician union(Statistician s1, Statistician s2)
   {
      // The student's code will replace this return statement:
      return null;
   }
      
}
           
