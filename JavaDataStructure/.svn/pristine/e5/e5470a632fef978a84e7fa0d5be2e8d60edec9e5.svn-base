package applications;
// FILE: Traffic.java
// The simlights method was written by: ---(Put your name here)---
// A simple program to simulate two synchronized traffic lights. The
// program prints a table indicating the average wait-time for cars coming
// through the two lights.

// The following classes are available in the directory
// http://www.cs.colorado.edu/~main/edu/colorado/simulations, with 
// documentation in http://www.cs.colorado.edu/~main/docs/.
// The three .java files must be present on your machine in
// a subdirectory called edu/colorado/simulations, and the edu
// must itself be in a subdirectory that is part of your Java
// CLASSPATH.
import edu.colorado.simulations.TrafficLight;

import edu.colorado.ch07.queue.Averager;
import edu.colorado.ch07.queue.BooleanSource;
import edu.colorado.ch07.queue.IntQueue;
// The following class is available in the directory
// http://www.cs.colorado.edu/~main/edu/colorado/collections, with 
// documentation in http://www.cs.colorado.edu/~main/docs/.
// The .java files must be present on your machine in
// a subdirectory called edu/colorado/collections, and the edu
// must itself be in a subdirectory that is part of your Java
// CLASSPATH.

import java.text.NumberFormat;

public class Traffic
{
   // Note: getNumberInstance( ) creates a NumberFormat object using
   // local information about the characters for a decimal point and
   // separators.
   private static NumberFormat form = NumberFormat.getNumberInstance( );

   public static void main(String[ ] args)
   {
      final double ARRIVAL_PROB = 0.1; // Prob. of car arrival in a second.
      final  int TRAVEL_TIME = 40;     // Seconds to travel between lights.
      final  int TOTAL_TIME = 6000;    // Total seconds in the simulation.
      final  int SPAN = 30;            // How long is a light red or green?
    
      int offset;

      for (offset = 0; offset < 2*SPAN; offset++)
      {
	 System.out.print("Offset of ");
         printNumber(offset, 2, 0);
         System.out.print(" seconds results in average wait of ");
         //Comments by JAMES ZOU
//	 printNumber(
//            simlights(offset, SPAN, ARRIVAL_PROB, TRAVEL_TIME, TOTAL_TIME),
//            7,
//            2
//         );
	 System.out.println(" seconds.");
      }
   }

   public double simlights(
      int offset,
      int span,
      double arrivalProb,
      int travelTime,
      int totalTime
   )
   // This is a method to simulate traffic flowing through two synchronized
   // traffic lights.
   // Parameters and return value:
   // Offset:
   //   This is the number of seconds between the time that the
   //   first light changes to green and the time that the second light changes to
   //   green. For example, if offset is zero, then the two lights change to green
   //   at the same time. If offset is 10 then the first light changes to green
   //   10 seconds ahead of the second.
   // Span:
   //   This is the length of time that each light stays red or green. For
   //   example, if span is 30, then each light stays red for 30 seconds then
   //   switches to green for 30 seconds, and so on.
   // ArrivalProb:
   //   This is the probability during any given second that a car arrives at
   //   the first traffic light. For example, if arrival_prob is 0.25, then there
   //   is a 25% chance that a car arrives at the first light during any given
   //   second and a 75% chance that no car arrives. (There will never be more
   //   than one car arriving during a single second.)
   // TravelTime:
   //   This is the number of seconds that it takes a car to travel from the
   //   first traffic light to the second.
   // TotalTime:
   //   This is the total number of seconds that the method will simulate
   //   at the traffic lights. (At the start of this simulation, there are no
   //   cars waiting at either light).
   // Computation and Return value:
   //   The method simulates cars arriving at the first stop light, waiting
   //   for a green light, moving to the second stoplight, waiting again, and
   //   moving through the second light. During a green light, at most one car
   //   can move through the the light per second. As the computation proceeds,
   //   the method uses an Averager to keep track of the average waiting time
   //   for cars that arrived and pass through the first light. A second
   //   Averager keeps track of the average waiting time for cars that arrived
   //   and passed through the second light. The method's return value is the
   //   sum of these two averages.
   // Special Case:
   //   If no cars make it through the second light, then the return value is -1.
   {
      /*
      -- Student must implement the body of this method. The method should
      -- use two Queues--one for the cars waiting at each stoplight. Each
      -- Queue contains the arrival times of cars that are waiting to go
      -- through the light. The method should have just one BooleanSource
      -- to determine when new cars arrive at the first light. There should
      -- also be two TrafficLight objects and two Averager objects.
      */
      return 0; 
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
      if (d >= 0)
         output = form.format(d + 0.5 * Math.pow(10, -fractionDigits));
      else
         output = form.format(d - 0.5 * Math.pow(10, -fractionDigits));
            
      //Comments by JAMES ZOU
//      printRight(output, minimumWidth);
   }

}

