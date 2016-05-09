package applications;

// File: TemperatureConversion.java
// A Java application to print a temperature conversion table.
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/TemperatureConversion.html

/******************************************************************************
* The TemperatureConversion Java application prints a table 
* converting Celsius to Fahrenheit degrees.
*
* @see <A HREF="../applications/TemperatureConversion.java">
*      Java Source Code
*      (www.cs.colorado.edu/~main/applications/TemperatureConversion.java)
*      </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jun 27, 2005
******************************************************************************/
public class TemperatureConversion 
{

   /**
   * The main method prints a Celsius to Fahrenheit conversion
   * table.
   * The bounds of the table range from -50C to +50C in 10 degree increments.
   * The String argumments (args) are not used
   * in this implementation.
   **/
   public static void main(String[ ] args) 
   {
      final double TABLE_BEGIN = -50.0; // The table's first Celsius temperature
      final double TABLE_END   =  50.0; // The table's final Celsius temperature
      final double TABLE_STEP  =  10.0; // Increment between temperatures in table
             
      double celsius;                   // A Celsius temperature
      double fahrenheit;                // The equivalent Fahrenheit temperature

      System.out.println("TEMPERATURE CONVERSION");
      System.out.println("----------------------"); 
      System.out.println("Celsius     Fahrenheit");
       
      for (celsius = TABLE_BEGIN; celsius <= TABLE_END; celsius += TABLE_STEP) 
      {  // Each iteration prints one line of the conversion table.
         fahrenheit = celsiusToFahrenheit(celsius);
	 System.out.printf("%6.2fC", celsius);
	 System.out.printf("%14.2fF\n", fahrenheit);
      }
      System.out.println("----------------------");
   }
 
        
   /**
   * Convert a temperature from Celsius degrees to Fahrenheit degrees.
   * 
   * @param c 
   *   a temperature in Celsius degrees
   * @precondition
   *   c >= -273.16.
   * @return 
   *   the temperature c converted to Fahrenheit
   * @throws java.lang.IllegalArgumentException
   *   Indicates that c is less than the smallest Celsius 
   *   temperature (-273.16).
   **/
   public static double celsiusToFahrenheit(double c)
   {
      final double MINIMUM_CELCIUS = -273.16;

      if (c < MINIMUM_CELCIUS)
         throw new IllegalArgumentException("Argument " + c + " is too small.");
      return (9.0/5.0)*c + 32;
   }

}
