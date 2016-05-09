// File: Organism.java from the package edu.colorado.simulations
// Complete documentation is available from the Organism link in
//   http://www.cs.colorado.edu/~main/docs/

package edu.colorado.ch13.extension;

/******************************************************************************
* An <CODE>Organism</CODE> object simulates a growing organism such as a
* plant or animal.
*
* <dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/simulations/Organism.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/simulations/Organism.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jun 12, 1998
*
* @see Animal
* @see Plant
******************************************************************************/
//模拟生物生长
public class Organism
{   
   private double size;  // The current size of this Organism, in ounces
   private double rate;  // The current growth rate , in ounces per week
   
   /**
   * Construct an <CODE>Organism</CODE> with a specified size and growth rate.
   * @param <CODE>initSize</CODE>
   *   the initial size of this <CODE>Organism</CODE>, in ounces
   * @param <CODE>initRate</CODE>
   *   the initial growth rate of this <CODE>Organism</CODE>, in ounces
   * <dt><b>Precondition:</b><dd>
   *   <CODE>initSize >= 0</CODE>. Also, if <CODE>initSize</CODE> is zero, then
   *   <CODE>initRate</CODE> must also be zero.
   * <dt><b>Postcondition:</b><dd>
   *   This <CODE>Organism</CODE> has been initialized. The value returned from
   *   <CODE>getSize()</CODE> is now <CODE>initSize</CODE>, and the value
   *   returned from <CODE>getRate()</CODE> is now <CODE>initRate</CODE>.
   * @throws IllegalArgumentException
   *   Indicates that <CODE>initSize</CODE> or <CODE>initRate</CODE> violates
   *   the precondition.
   **/
   public Organism(double initSize, double initRate)
   {
      size = initSize;
      rate = initRate;
   }


   /**
   * Change the current size of this <CODE>Organism</CODE> by a given amount.
   * @param <CODE>amount</CODE>
   *   the amount to increase or decrease the size of this 
   *   <CODE>Organism</CODE> (in ounces)
   * <dt><b>Postcondition:</b><dd>
   *   The given amount (in ounces) has been added to the size of this 
   *   <CODE>Organism</CODE>. If this new size is less than or equal to zero,
   *   then </CODE>expire</CODE> is also activated.
   **/
   public void alterSize(double amount)
   {
      size += amount;
      if (size <= 0)
         expire( );
   }
      
      
   /**
   * Set this <CODE>Organism</CODE>抯 size and growth rate to zero.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   The size and growth rate of this <CODE>Organism</CODE> have been set
   *    to zero. 
   **/
   public void expire( )
   {
      size = rate = 0;
   }
   
   
   /**
   * Get the growth rate of this <CODE>Organism</CODE>.
   * @param - none
   * @return
   *   the growth rate of this <CODE>Organism</CODE> (in ounces per week)
   **/
   public double getRate( )
   {
      return rate;
   }
   
   
   /**
   * Get the current size of this <CODE>Organism</CODE>.
   * @param - none
   * @return
   *   the current size of this <CODE>Organism</CODE> (in ounces)
   **/
   public double getSize( )
   {
      return size;
   }


   /**
   * Determine whether this <CODE>Organism</CODE> is currently alive.
   * @param - none
   * @return
   *   If this <CODE>Organism</CODE>抯 current current size is greater than
   *   zero, then the return value is <CODE>true</CODE>; otherwise the return 
   *   value is <CODE>false</CODE>.
   **/
   public boolean isAlive( )
   {
      return (size > 0);
   }
   
   
   /**
   * Set the current growth rate of this <CODE>Organism</CODE>.
   * @param <CODE>newRate</CODE>
   *   the new growth rate for this <CODE>Organism</CODE> (in ounces per week)
   * <dt><b>Precondition:</b><dd>
   *   If the size is currently zero, then <CODE>newRate</CODE> must also be
   *   zero.
   * <dt><b>Postcondition:</b><dd>
   *   The growth rate for this <CODE>Organism</CODE> has been set to 
   *   <CODE>newRate</CODE>.
   * @throws IllegalArgumentException
   *   Indicates that the size is currently zero, but the <CODE>newRate</CODE>
   *   is nonzero.
   **/
   public void setRate(double newRate)
   {
      if ((size == 0) && (newRate != 0))
         throw new IllegalArgumentException
         ("newRate must be zero (because current size is zero");
      rate = newRate;
   }
   
   
   /**
   * Simulate the passage of one week in the life of this <CODE>Organism</CODE>.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   The size of this <CODE>Organism</CODE> has been changed by its current
   *   growth rate. If the new size is less than or equal to zero, then
   *   <CODE>expire</CODE> is activated to set both size and growth rate to 
   *   zero.
   **/
   public void simulateWeek( )
   {
      alterSize(rate);
   }
}
           
