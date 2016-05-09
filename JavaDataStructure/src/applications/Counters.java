package applications;
// File: Counters.java
// A Java application to illustrate generic methods.
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/Counters.html

/******************************************************************************
* The Counters Java application tests several methods to count the number
* of occurrences of a target in an array. 
*
* @see <A HREF="../applications/Counters.java">
*      Java Source Code
*      (www.cs.colorado.edu/~main/applications/Counters.java)
*      </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jul 14, 2005
******************************************************************************/
public class Counters
{

   /**
   * The main method ...
   **/
   public static void main(String[ ] args) 
   {
      Double[] arrayDoubleObjects = {1.0, 2.0, 3.0, 4.0, 1.0};       
      double[] arrayDoublePrimitives = { 1.0, 2.0, 3.0, 4.0, 1.0};
      countOccurrences(arrayDoubleObjects, 1.0);
   }

   static int countOccurrences(Object[] data, Object target)
   // The return value is the number of times target appears in data.
   {
      int answer= 0;
      if (target == null)
      { // Count how many times null appears in the data array:
         for (Object next : data)
            if (next == null)
               answer++;
      }
      else
      { // Use target.equals to determine how many times target occurs.
         for (Object next : data)
            if (target.equals(next))
               answer++;
      }
      return answer;
   }
        
}
