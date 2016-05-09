// File: EasyReader.java from the package edu.colorado.io
// Complete documentation is available from the EasyReader link in:
//   http://www.cs.colorado.edu/~main/docs
package edu.colorado.io;

import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PushbackReader;

/******************************************************************************
* The <CODE>EasyReader</CODE> object has a small collection of methods for
* reading some primitive data values from an input stream or file.
*
* <P><B>Limitations:</B>
* <BR>
* If an <CODE>IOException</CODE> or <CODE>FileNotFoundException</CODE> occurs
* during any  operation, then the
* <CODE>EasyReader</CODE> prints an error message and halts the program.
* The exceptions is not passed back to the calling program,
* so the calling program does not need to catch any exceptions. 
*
* <P><B>Example:</B>
* <BR>
* This example declares an <CODE>EasyReader</CODE> that is attached to the
* keyboard input (<CODE>System.in</CODE>). It then uses 
* <CODE>doubleQuery</CODE> to ask the user to enter a double number. The
* square of this double number is then printed:
* <CODE>
* <BR>  import edu.colorado.io.EasyReader
* <BR>  ...
* <BR>  EasyReader stdin = new EasyReader(System.in); // Attaches to keyboard
* <BR>  double d;
* <BR>  d = stdin.doubleQuery("Please type a double value: ");
* <BR>  System.out.println("The square of that is: " + d*d);  
* <BR></CODE>
*
* <dl><dt><b>The <CODE>EasyReader</CODE> class includes:</b>
*   <dd>
*   (1) Three constructors to create an <CODE>EasyReader</CODE> from an
*   <CODE>InputStream</CODE>, from an <CODE>InputStreamReader</CODE>, or from
*   a file name. For example, to create an <CODE>EasyReader</CODE> from 
*   <CODE>System.in</CODE>:
*   <br><code>EasyReader stdin = new EasyReader(System.in);</CODE>
*   <dd>
*   (2) Query methods: The names of these methods end with "Query".
*   Each method prints a prompt (which is a String parameter) and then reads
*   one line of input, converting the line to some type (char, double,
*   int, or String). All of the query methods reject improperly formatted
*   input lines (such as a 1.5 for an integer input). When an input line is
*   rejected, the method prompts the user for a correctly formatted input.
*   This continues until an input line is typed in the correct format.
*   <dd>
*   (3) Peek method: This method returns the next character of the input
*   without actually reading it.
*   <dd>
*   (4) Input methods: The names of these methods end with "Input" or
*   "InputLine". The methods read input and convert it to some type
*   (char, double, int, or String). The "Input" methods just read the
*   data, and the "InputLine" methods  read the data and then discard the rest
*   of the line.
*   <dd>
*   (5) Boolean methods: The names of these methods begin with "is". They
*   return various information about the input status.
*   <dd>
*   (6) The methods skipLine and ignore. They
*   read and throw away various input.
* </dl>
* 
* <dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/io/EasyReader.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/io/EasyReader.java
*   </A>
*
* @author 
*   Michael Main (main@colorado.edu)
*
* @version
*   Jun 12, 1998
*
* @see FormatWriter
******************************************************************************/
public class EasyReader extends PushbackReader 
{
   final static int  EOF_VALUE = -1;      // Returned by read( ) at EOF
   final static char ZERO_CHAR = '\0';    // Unicode character zero   

   private boolean formatProblem = false;
   
   /**
   * Initialize this <CODE>EasyReader</CODE> so that it reads from an 
   * <CODE>InputStream</CODE>.
   * @param <CODE>in</CODE>
   *   an <CODE>InputStream</CODE> that this <CODE>EasyReader</CODE>
   *   will read from
   * <dt><b>Postcondition:</b><dd>
   *   This <CODE>EasyReader</CODE> has been initialized so that its
   *   subsequent input comes from the specified <CODE>InputStream</CODE>.
   * <dt><b>Example:</b><dd>
   *   <CODE>EasyReader stdin = new EasyReader(System.in);</CODE>
   **/
   public EasyReader(InputStream in)
   {
      super(new InputStreamReader(in));
   }
   
   
   /**
   * Initialize this <CODE>EasyReader</CODE> so that it reads from a 
   * specified file.
   * @param <CODE>name</CODE>
   *   the name of the file that this <CODE>EasyReader</CODE>
   *   will read from
   * <dt><b>Postcondition:</b><dd>
   *   This <CODE>EasyReader</CODE> has been initialized so that its
   *   subsequent input comes from the specified file. 
   *   If the file does not exist, then an error message is printed
   *   to System.err and the program exits.
   * <dt><b>Example:</b><dd>
   *   <CODE>EasyReader stdin = new EasyReader("foo.txt");</CODE>
   **/
   public EasyReader(String name) 
   {
      super(makeFileReader(name));
   }
   
   
   /**
   * Initialize this <CODE>EasyReader</CODE> so that it reads from an 
   * <CODE>InputStreamReader</CODE>.
   * @param <CODE>in</CODE>
   *   an <CODE>InputStreamReader</CODE> that this <CODE>EasyReader<CODE>
   *   will read from
   * <dt><b>Postcondition:</b><dd>
   *   This <CODE>EasyReader</CODE> has been initialized so that its subsequent
   *   input comes from the specified <CODE>InputStreamReader</CODE>.
   **/
   public EasyReader(InputStreamReader isr)
   {
      super(isr);
   }


   /**
   * Read a character from this <CODE>EasyReader</CODE>.
   * @param - none
   * @return
   *   a character that's been read
   * <dt><b>Note:</b>
   *   This method reads and throws away whitespace. Then it reads and
   *   returns the next character. If end-of-file has been reached, then
   *   it returns ASCII value zero. 
   **/
   public char charInput( )
   {
      readSpaces( );
      return readChar( );
   }   
   
   
   /**
   * Read a character from a complete line of this <CODE>EasyReader</CODE>.
   * @param - none
   * @return
   *   a character that's been read
   * <dt><b>Note:</b><dd>
   *   This method is indentical <CODE>charInput()</CODE> with an added
   *   activation of <CODE>skipLine()</CODE> just before returning. 
   **/
   public char charInputLine( )
   {
      char answer = charInput( );
      skipLine( );
      return answer;
   }
   

   /**
   * Print a prompt, then read and return a character from this 
   * <CODE>EasyReader</CODE>.
   * @param <CODE>prompt</CODE>
   *   a prompt to print
   * <dt><b>Postcondition:</b><dd>
   *   The prompt has been printed to <CODE>System.out</CODE>. Then a
   *   character has been read and returned with <CODE>charInputLine</CODE>.  
   **/
   public char charQuery(String prompt)
   {
      char answer;
            
      System.out.print(prompt);
      return charInputLine( );
   }
   
   
   /**
   * Read a <CODE>double</CODE> number from this <CODE>EasyReader</CODE>.
   * @param - none
   * @return
   *   a </CODE>double</CODE> number that's been read
   * <dt><b>Input Method:</b>
   *   <dd>An attempt is made to read the following items into a 
   *   <CODE>String</CODE>:
   *   <dd>(1) Zero or more whitespace characters (which are discarded);
   *   <dd>(2) An optional + or - sign.
   *   <dd>(3) A sequence of digits that form the integer part of the number.
   *   <dd>(4) If the next character is a decimal point, then it is read
   *           along with a sequence of digits that form the fractional part
   *           of the number.
   *   <dd>(5) If the next character is 'e' or 'E', then it is read along 
   *           with an optional +/- sign and digits that form the exponent
   *           part of the number.
   *   <dd> After these items, there may be a non-digit delimiter, or the
   *        end-of-file may appear after the number. The delimiter (or EOF)
   *        is not read.
   * <dt><b>Conversion:</b> The above items are converted to a double value 
   *   using <CODE>Double.valueOf</CODE>.
   * <dt><b>Format Problems:</b><dd>
   *   If a <CODE>NumberFormatException</CODE>
   *   occurs, then the method returns <CODE>Double.NaN</CODE> and an immediate
   *   activation of <CODE>isFormatProblem()</CODE> will return true.
   **/
   public double doubleInput( )
   {
      final char POINT = '.';
      StringBuffer input = new StringBuffer( );

      readSpaces( );
      input.append(readSign( ));
      input.append(readDigits( ));
      if (peek( ) == POINT)
      {  // Read the decimal point and fractional part.
         input.append(readChar( ));
         input.append(readDigits( ));
      }
      if (Character.toUpperCase(peek( )) == 'E')
      {  // Read the E and exponent.
         input.append(readChar( ));
         input.append(readSign( ));
         input.append(readDigits( ));
      }
      
      try
      {
         formatProblem = false;
         return Double.valueOf(input.toString( )).doubleValue( );
      }
      catch (NumberFormatException e)
      {
         formatProblem = true;
         return Double.NaN;
      }
   } 
   
                  
   /**
   * Read a double value from a complete line of this <CODE>EasyReader</CODE>.
   * @param - none
   * @return
   *   a double value that's been read
   * <dt><b>Note:</b><dd>
   *   This method is identical <CODE>doubleInput( )</CODE> with an added
   *   activation of <CODE>skipLine( )</CODE> just before returning. 
   **/
   public double doubleInputLine( )
   {
      double answer = doubleInput( );
      skipLine( );
      return answer;
   }
   

   /**
   * Print a prompt, then read and return a double value from this
   * <CODE>EasyReader</CODE>.
   * @param <CODE>prompt</CODE>
   *   a prompt to print
   * <dt><b>Postcondition:</b><dd>
   *   The prompt has been printed to <CODE>System.out</CODE>. Then a double
   *   value has been read and returned with <CODE>doubleInputLine</CODE>.
   * <dt><b>Format Problems:</b><dd>
   *   If <CODE>doubleInputLine</CODE> encounters a format problem, but
   *   <CODE>!isEOF()</CODE>, then the user is prompted to type a new
   *   input line until a correct double value is provided. If end-of-file
   *   is reached, then the method returns <CODE>Double.NaN</CODE> and
   *   an immediate activation of <CODE>isFormatProblem()</CODE> will return 
   *   true.  
   **/
   public double doubleQuery(String prompt)
   {
      double answer;
            
      System.out.print(prompt);
      answer = doubleInputLine( );
      while (formatProblem)
      {
         System.out.print("Invalid response. Please type a double value: ");
         if (isEOF( ))
            return Double.NaN;
         answer = doubleInputLine( );
      }
     
      return answer;
   }
   
     
   private static void handleException(Exception e)
   // Print an error message and halt the program.
   {
      System.err.println("Exception:" + e);
      System.err.println("EasyReader will cause program to halt.");
      System.exit(0);
   }


   /**
   * Read and discard one character.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   One character has been read and discarded.
   **/
   public void ignore( )
   {
         readChar( );
   }
      
   
   /**
   * Read an integer from this <CODE>EasyReader</CODE>.
   * @param - none
   * @return
   *   an integer that's been read
   * <dt><b>Format:</b>
   *   <dd>An attempt is made to read the following items into a 
   *   <CODE>String</CODE>:
   *   <dd>(1) Zero or more whitespace characters (which are discarded);
   *   <dd>(2) An optional + or - sign.
   *   <dd>(3) A sequence of digits that form the actual integer.
   *       There may be a non-digit delimiter after the integer, or the
   *       end-of-file may appear after the integer. The delimiter (or EOF)
   *       is not read.
   * <dt><b>Conversion:</b> The above items are converted to an integer value 
   *   using <CODE>Integer.parseInt</CODE>.
   * <dt><b>Format Problems:</b><dd>
   *   If a <CODE>NumberFormatException</CODE>
   *   occurs, then the method returns <CODE>Integer.MIN_VALUE</CODE> and an
   *   immediate activation of <CODE>isFormatProblem()</CODE> will return true.   
   **/
   public int intInput( )
   {
      String input = null;
 
      readSpaces( );
      input = readSign( ) + readDigits( );
      
      try
      {
         formatProblem = false;
         return Integer.parseInt(input);
      }
      catch (NumberFormatException e)
      {
         formatProblem = true;
         return Integer.MIN_VALUE;
      }
   }
   
   
   /**
   * Read an integer from a complete line of this <CODE>EasyReader</CODE>.
   * @param - none
   * @return
   *   an integer that's been read
   * <dt><b>Note:</b><dd>
   *   This method is indentical <CODE>intInput( )</CODE> with an added
   *   activation of <CODE>skipLine( )</CODE> just before returning. 
   **/
   public int intInputLine( )
   {
      int answer = intInput( );
      skipLine( );
      return answer;
   }
   

   /**
   * Print a prompt, then read and return an integer from this
   * <CODE>EasyReader</CODE>.
   * @param <CODE>prompt</CODE>
   *   a prompt to print
   * <dt><b>Postcondition:</b><dd>
   *   The prompt has been printed to <CODE>System.out</CODE>. Then an
   *   integer has been read and returned with <CODE>intInputLine</CODE>.
   * <dt><b>Format Problems:</b><dd>
   *   If <CODE>intInputLine</CODE> encounters a format problem, but
   *   <CODE>!isEOF()</CODE>, then the user is prompted to type a new
   *   input line until a correct int value is provided. If end-of-file
   *   is reached, then the method returns <CODE>Integer.MIN_VALUE</CODE>
   *   and an immediate activation of <CODE>isFormatProblem()</CODE> will return 
   *   true.   
   **/
   public int intQuery(String prompt)
   {
      int answer;
            
      System.out.print(prompt);
      answer = intInputLine( );
      while (formatProblem)
      {
         System.out.print("Invalid response. Please type an integer value: ");
         if (isEOF( ))
            return Integer.MIN_VALUE;
         answer = intInputLine( );
      }
      
      return answer;
   }

   
   /**
   * Determine whether this <CODE>EasyReader</CODE> has reached the 
   * end-of-file.
   * @param - none
   * @return
   *   If this <CODE>EasyReader</CODE> has reached the end of file 
   *   (reading all characters up to but not including EOF), then the return
   *   value is true; if an attempt to read causes an <CODE>IOException,</CODE>
   *   then the return value is also
   *   true; otherwise the return value is false.
   * <dt><b>Note:</b><dd>
   *   A user at the keyboard indicates EOF for standard input by typing 
   *   ctrl-z (MS Windows) or ctrl-c (Unix). For an interactive user, this
   *   method does pause until the
   *   user provides some input or indicates end-of-file by pressing ctrl-z.
   * <dt><b>Example:</b><dd>
   *   Read one integer per line from standard input until EOF, then print
   *   the sum of all the integers:
   *   <CODE>
   *   <br> EasyReader stdin = new EasyReader(System.in);
   *   <br> int sum = 0;
   *   <br> System.out.println("Type one int per line & press ctrl-z to end:");
   *   <br> while (!stdin.isEOF( ))
   *   <br>    sum += stdin.intInputLine( );
   *   <br> System.out.println("Total sum: " + sum);
   *   </CODE>
   **/          
   public boolean isEOF( )
   {      
      return (readAhead( ) == EOF_VALUE);
   }

   
   /**
   * Determine whether the next input character is an end-of-line.
   * @param - none
   * @return
   *   If the next input character is a newline ('\n') or carriage return
   *   ('\r'), then the return value is true; if <CODE>isEOF()</CODE>, then the
   *   return value is also true; if an attempt to read causes an 
   *   <CODE>IOException</CODE>, then
   *   the return value is also true; otherwise the return value is false.
   **/          
   public boolean isEOLN( )
   {
      int next = readAhead( );
      return (next == '\n') || (next == '\r') || (next == EOF_VALUE);
   }
  
   
   /**
   * Determine whether there was an incorrectly formatted input to the most
   * recent input operation.
   * @param - none
   * @return
   *   A true return value indicates that the most recent activation of an
   *   input methods had an IOException OR was given input of the wrong form 
   *   (such as "abc" instead of an integer). Note that the return value is
   *   applicable to only the MOST RECENT activation of these input methods:
   *   <CODE>
   *   <br> doubleInput,     intInput
   *   <br> doubleInputLine, intInputLine
   *   <br> doubleQuery,     intQuery
   *   </CODE>
   **/       
   public boolean isFormatProblem( )
   {
      return formatProblem;
   }
   
   
   private static FileReader makeFileReader(String name)
   // Create and return a FileReader to read from the named file. If the file doesn’t exist then print
   // an error message and halt the program.
   {
      try
      {
         return new FileReader(name);
      }
      catch (FileNotFoundException e)
      {
         handleException(e);
         return null;
      }
   }
   
    
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
   * Peek ahead at the next character from this <CODE>EasyReader</CODE>
   * (but don't read it).
   * @param - none 
   * @return
   *   The return value is the next character that will be read from this
   *   <CODE>EasyReader</CODE>. If there is no next character (because of 
   *   the end-of-file marker), then the return value is '\0'.
   **/
   public char peek( )
   {
      int next = readAhead( );
      if (next == EOF_VALUE)
         return ZERO_CHAR;
      else
         return (char) next;
   }
     
   
   /**
   * Print a prompt, then read and return a YES/NO answer from this
   * <CODE>EasyReader</CODE>.
   * @param <CODE>prompt</CODE>
   *   a prompt to print
   * <dt><b>Postcondition:</b><dd>
   *   <CODE>stringQuery(prompt)</CODE> has been called to ask a question
   *   and read the answer, which is considered true if it begins with
   *   "Y" or "y" and false if it begins with "N" or "n". If the answer did
   *   not begin with a lower- or upper-case Y or N, then the process is 
   *   repeated until a correct Yes/No answer is provided. If EOF is reached,
   *   then false is returned.    
   **/
   public boolean query(String prompt)
   {
      String answer;
            
      System.out.print(prompt + " [Y or N] ");
      answer = stringInputLine( ).toUpperCase( );
      while (!answer.startsWith("Y") && !answer.startsWith("N"))
      {
         System.out.print("Invalid response. Please type Y or N: ");
         if (isEOF( ))
            return false;
         answer = stringInputLine( ).toUpperCase( );
      }
      
      return answer.startsWith("Y");
   }   
   
      
   private int readAhead( )
   // Peek ahead and return the next character (or -1 for EOF).
   {
      int next = EOF_VALUE;
      
      try
      {
         next = read( );
         if (next == EOF_VALUE)
         {
            // End-of-file was encountered. We pause 1 second to allow the
            // ctrl-z from the keyboard to be processed since it blocks output
            // to the screen on some systems.
            pause(1000);
         }
         else
            unread(next);
      } 
      catch (IOException e)
      {
         handleException(e); 
      }
      
      return next;
   }


   private char readChar( )
   // Read and return the next character (or ZERO_CHAR for EOF). 
   {
      int next = EOF_VALUE;
      
      try
      {
         next = read( );
         if (next == EOF_VALUE)
         {
            next = ZERO_CHAR;
            // End-of-file was encountered. We pause 1 second to allow the
            // ctrl-z from the keyboard to be processed since it blocks output
            // to the screen on some systems.
            pause(1000);
         }
      } 
      catch (IOException e)
      {
         handleException(e); 
      }
      
      return (char) next;
   }   
   
   
   private String readDigits( )
   // Read a sequence of digits and return the sequence as a String.
   {
      StringBuffer buffer = new StringBuffer( );
      
      while (Character.isDigit(peek( )))
         buffer.append(readChar( ));
         
      return buffer.toString( );
   }
   
   
   private String readSign( )
   // Read a + or - sign (if one is present) and return the read characters as a string.
   {
      StringBuffer buffer = new StringBuffer(1);
      char possibleSign;
      
      possibleSign = peek( );
      if ((possibleSign == '-') || (possibleSign == '+'))
         buffer.append(readChar( ));
         
      return buffer.toString( );
   }
   
   
   private String readSpaces( )
   // Read a sequence of whitespace characters and return the sequence as a String.
   {
      StringBuffer buffer = new StringBuffer( );
      
      while (Character.isWhitespace(peek( )))
         buffer.append(readChar( ));
         
      return buffer.toString( );
   }
   
   
   /**
   * Read and discard the rest of the current input line.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   Characters have been read and discarded up to and including the end of
   *   the current input line (or to the end-of-file).
   **/
   public void skipLine( )
   {
      while (!isEOLN( ))
         readChar( );
      if (peek( ) == '\r')
         readChar( );
      if (peek( ) == '\n')
         readChar( );
   }
   
 
   /**
   * Read a <CODE>String</CODE> (up to whitespace) from this 
   * <CODE>EasyReader</CODE>.
   * @param - none
   * @return
   *   a <CODE>String</CODE> that's been read
   * <dt><b>Format:</b>
   *   Whitespace has been skipped, and then a string has been read
   *   up to but not including the next whitespace character.  
   **/
   public String stringInput( )
   {
      StringBuffer buffer = new StringBuffer( );

      formatProblem = false;
      readSpaces( );
      while (!isEOF( ) && !Character.isWhitespace(peek( )))
         buffer.append(readChar( ));
      return buffer.toString( );
   }

 
   /**
   * Read a <CODE>String</CODE> from a complete line of this 
   * <CODE>EasyReader</CODE>.
   * @param - none
   * @return
   *   a <CODE>String</CODE> that's been read
   * <dt><b>Format:</b>
   *   An entire line of characters has been read up to and including the end
   *   of the current line (or the end-of-file). All characters before the
   *   end are returned in a <CODE>String</CODE>.   
   **/
   public String stringInputLine( )
   {
      StringBuffer buffer = new StringBuffer( );

      while (!isEOLN( ) && !isEOF( ))
         buffer.append(readChar( ));
      skipLine( );
      return buffer.toString( );
   }  
   

   /**
   * Print a prompt, then read and return a <CODE>String</CODE> from this
   * <CODE>EasyReader</CODE>.
   * @param <CODE>prompt</CODE>
   *   a prompt to print
   * <dt><b>Postcondition:</b><dd>
   *   The prompt has been printed to <CODE>System.out</CODE>. Then a
   *   <CODE>String</CODE> has been read and returned with 
   *   <CODE>stringInputLine</CODE>. 
   **/
   public String stringQuery(String prompt)
   {
      System.out.print(prompt);
      return stringInputLine( );
   }
      
   
   /**  
   * A demonstration program.
   * To run the demonstration: 
   * <BR><CODE>java edu.colorado.io.EasyReader</CODE>
   **/
   public static void main(String[ ] args)
   { 
      EasyReader stdin = new EasyReader(System.in);
         
      double d = stdin.doubleQuery("Double: ");
      if (stdin.isFormatProblem( ))
         System.out.println("A format error resulted in " + d);
      else
         System.out.println(d + " is a fine double number.");
      
      int i = stdin.intQuery("Int: ");
      if (stdin.isFormatProblem( ))
         System.out.println("A format error resulted in " + i);
      else
         System.out.println(i + " is a fine integer.");
 
      String s = stdin.stringQuery("String: ");
      if (stdin.isFormatProblem( ))
         System.out.println("A format error resulting in " + s);
      else
         System.out.println('"' + s + '"' + " is a fine String.");
      
      int sum = 0;
      System.out.println("Type one int per line & press ctrl-z to end:");
      while (!stdin.isEOF( ))
         sum += stdin.intInputLine( );
      System.out.println("Total sum: " + sum);
   }
   
    
}
