// File: TrafficLight.java from the package edu.colorado.simulations
// Additional documentation is available from the Throttle link in:
//   http://www.cs.colorado.edu/~main/docs/

package edu.colorado.simulations;

/******************************************************************************
* A <CODE>TrafficLight</CODE> object simulates a simple traffic light.
*
* <dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/simulations/TrafficLight.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/simulations/TrafficLight.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jan 12, 1999
******************************************************************************/
public class TrafficLight
{
   private int redSpan;            // Seconds that the light stays red
   private int greenSpan;          // Seconds that the light stays green
   private boolean nowRed;         // True if the light is now red
   private int secondsUntilChange; // Seconds until the next color change
                      
   /**
   * Construct a <CODE>TrafficLight</CODE> with a specified lengths of time
   * that the light stays red and green.
   * @param <CODE>r</CODE>
   *   the number of seconds that this light stays red
   * @param <CODE>g</CODE>
   *   the number of seconds that this light stays green
   * <dt><b>Precondition:</b><dd>
   *   Both r and g are positive.
   * <dt><b>Postcondition:</b><dd>
   *   This <CODE>TrafficLight</CODE> has been initialized. It starts
   *   red and stays red for r seconds; then it switches to green for
   *   g seconds, back to red for r seconds, back to green for g
   *   seconds, and so on.
   * @exception IllegalArgumentException
   *   Indicates that one of the parameters is zero or negative. 
   **/
   public TrafficLight(int r, int g)
   {
      if (r <= 0)
         throw new IllegalArgumentException("r <= 0: " + r);
      if (g <= 0)
         throw new IllegalArgumentException("g <= 0: " + g);
      redSpan = r;
      greenSpan = g;
      nowRed = true;
      secondsUntilChange = r;
   }


   /**
   * Simulate the passage of a certain amount of time for this
   * <CODE>TrafficLight</CODE>.
   * @param <CODE>t</CODE>
   *   the number of seconds to simulate during the call to this method
   * <dt><b>Precondition:</b><dd>
   *   <CODE>t >= 0.</CODE>
   * <dt><b>Postcondition:</b><dd>
   *   This <CODE>TrafficLight</CODE> has simulated the passage of
   *   t more seconds of time.
   * @exception IllegalArgumentException
   *   Indicates that <CODE>t</CODE> is negative. 
   **/
   public void simulateTime(int t) 
   {
      while (t >= secondsUntilChange)
      {
         t -= secondsUntilChange;
         nowRed = !nowRed;
         secondsUntilChange = nowRed ? redSpan : greenSpan;
      }
      secondsUntilChange -= t;
   }
   

   /**
   * Check whether this <CODE>TrafficLight</CODE> is red.
   * @param - none
   * @return
   *   If this <CODE>TrafficLight</CODE> is red, then the return
   *   value is true; otherwise the return value is false.
   **/
   public boolean isRed( )
   {
      return nowRed;
   }


   /**
   * Check whether this <CODE>TrafficLight</CODE> is green.
   * @param - none
   * @return
   *   If this <CODE>TrafficLight</CODE> is green, then the return
   *   value is true; otherwise the return value is false.
   **/
   public boolean isGreen( )
   {
      return !nowRed;
   }
   
}
