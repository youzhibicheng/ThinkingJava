// File: Herbivore.java from the package edu.colorado.simulations
// Complete documentation is available from the Herbivore link in
//   http://www.cs.colorado.edu/~main/docs /

package edu.colorado.ch13.extension;

/******************************************************************************
* A <CODE>Herbivore</CODE> is an <CODE>Animal</CODE> with extra methods that
* allow it to eat <CODE>Plant</CODE> objects.
*
* <dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/simulations/Herbivore.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/simulations/Herbivore.java
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

public class Herbivore extends Animal
{ 
   /**
   * Construct an <CODE>Herbivore</CODE> with a specified size, growth rate, and
   * weekly eating need.
   * @param <CODE>initSize</CODE>
   *   the initial size of this <CODE>Herbivore</CODE>, in ounces
   * @param <CODE>initRate</CODE>
   *   the initial growth rate of this <CODE>Herbivore</CODE>, in ounces
   * @param <CODE>initNeed</CODE>
   *   the initial weekly eating requirement of this <CODE>Animal</CODE>, in
   *   ounces per week
   * <dt><b>Precondition:</b><dd>
   *   <CODE>initSize >= 0</CODE> and <CODE>initNeed >= 0</CODE>.
   *   Also, if <CODE>initSize</CODE> is zero, then
   *   <CODE>initRate</CODE> must also be zero.
   * <dt><b>Postcondition:</b><dd>
   *   This <CODE>Herbivore</CODE> has been initialized. The value returned from
   *   <CODE>getSize()</CODE> is now <CODE>initSize</CODE>, the value
   *   returned from <CODE>getRate()</CODE> is now <CODE>initRate</CODE>, and
   *   this <CODE>Herbivore</CODE> must eat at least <CODE>initNeed</CODE> ounces
   *   of food each week to survive.
   * @exception IllegalArgumentException
   *   Indicates that <CODE>initSize</CODE>, <CODE>initRate</CODE>, or  
   *   <CODE>initNeed</CODE> violates the precondition.
   **/   
   public Herbivore(double initSize, double initRate, double initNeed)
   {
      super(initSize, initRate, initNeed);
   }
   
   
   /**
   * Have this <CODE>Herbivore</CODE> eat part of a <CODE>Plant</CODE>.
   * @param <CODE>meal</CODE>
   *   the <CODE>Plant</CODE> that will be partly eaten
   * <dt><b>Postcondition:</b><dd>
   *   Part of the <CODE>Plant</CODE> has been eaten by this <CODE>Herbivore</CODE>,
   *   by activating both <CODE>eat(amount)</CODE> and 
   *   <CODE>meal.nibbledOn(amount)</CODE>. The <CODE>amount</CODE> is usually
   *   half of the </CODE>Plant</CODE>, but it will not be more than 10% of 
   *   this </CODE>Herbivore</CODE>�s weekly need nor more than the amount that 
   *   this </CODE>Herbivore</CODE> still needs to eat to survive this week.
   **/
   public void nibble(Plant meal)
   {
      final double PORTION = 0.5; // Eat no more than this portion of plant
      final double MAX_FRACTION = 0.1; // Eat no more than this fraction of weekly need
      double amount; // How many ounces of the plant will be eaten
      
      // Set amount to some portion of the plant, but no more than a given
      // maximum fraction of the total weekly need, and no more than what the
      // herbivore still needs to eat this week.
      amount = PORTION * meal.getSize( );
      if (amount > MAX_FRACTION * getNeed( ))
         amount = MAX_FRACTION * getNeed( );
      if (amount > stillNeed( ))
         amount = stillNeed( );

      // Eat the plant
      eat(amount);
      meal.nibbledOn(amount);
   }
   
}
