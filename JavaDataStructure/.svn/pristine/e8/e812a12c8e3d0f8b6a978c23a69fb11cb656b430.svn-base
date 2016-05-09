package edu.colorado.ch07.queue;

// File: Palindrome.java
// This program determines whether an input line is a palindrome. The program 
// ignores everything except alphabetic letters, and it ignores the difference
// between upper- and lowercase letters.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;  // From Appendix B

/******************************************************************************
* The <CODE>Palindrome</CODE> Java application illustrates the use of a stack
* and a queue in the same program to determine whether a line is a
* palindrome. The program ignores everything except alphabetic letters, and it
* ignores the difference between upper- and lowercase letters. 
*
* <p><dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../applications/Palindrome.java">
*   http://www.cs.colorado.edu/~main/applications/Palindrome.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jul 21, 2005
******************************************************************************/
//回文(正向和逆向读取结果相同的字符串)
public class Palindrome 
{
   /**
   * The main method prompts the user for a strings. Each string is read
   * and checked to see whether it is a palindrome.  The program ends when
   * the user enters an empty line (just the return key).
   **/
   public static void main(String[ ] args)
   {
	Scanner stdin = new Scanner(System.in); // Keyboard input       
	String line;                            // One input line
      
      do
      {
	 System.out.print("Your expression (or return to end): ");
         line = stdin.nextLine( );
	 if (is_palindrome(line))
	    System.out.println("That is a palindrome.");
	 else
	    System.out.println("That is not a palindrome.");
      }
      while (line.length( ) != 0);
   }

   /**
   * The return value is true if and only if the input string is a palindrome.
   * All non-letters is ignored, and the case of the letters is also ignored.
   **/
   public static boolean is_palindrome(String input) 
   {   
      Queue<Character> q = new LinkedList<Character>( );
      Stack<Character> s = new Stack<Character>( );
      Character letter;   // One character from the input string
      int mismatches = 0; // Number of spots that mismatched
      int i;              // Index for the input string
      
      for (i = 0; i < input.length( ); i++)
      {
	 letter = input.charAt(i);
         if (Character.isLetter(letter))
         {
            q.add(letter);
            s.push(letter);
         }
      }
      
      while (!q.isEmpty( ))
      {
         if (q.remove( ) != s.pop( ))
            mismatches++;
      }

      // If there were no mismatches, then the string was a palindrome.
      return (mismatches == 0); 
   }
    
}
