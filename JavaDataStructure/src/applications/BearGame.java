package applications;
// FILE: BearGame.java
// This program illustrates the use of the bears method that uses
// recursion to determine whether it is possible to win a silly game.

//import java.io.IOException;
import java.util.Scanner;

/******************************************************************************
* The <CODE>BearGame</CODE> Java application illustrates the use of
* the <CODE>bears</CODE> method that uses recursion to determine whether it is
* possible to win a silly game.
* <p><dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../applications/BearGame.java">
*   http://www.cs.colorado.edu/~main/applications/BearGame.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jul 22, 2005
******************************************************************************/
public class BearGame
{
   /**
   * The main method interactively gets information from the user to
   * activate the <CODE>bears</CODE> method. It then prints a message
   * indicating whether the game's goal can be reached.  
   * The <CODE>String</CODE>
   * argument (<CODE>args</CODE>) is not used in this implementation.
   **/
   public static void main(String[ ] args)
   {
      Scanner stdin = new Scanner(System.in);
      int initial, goal, increment, n;
      
      System.out.println("Please type the following parameters for the game.");
      
      do
      {
         initial   = intQuery(stdin, "Initial number of bears: ");
         goal      = intQuery(stdin, "Goal number of bears:    ");
         increment = intQuery(stdin, "Increment for an a-step: ");
         n         = intQuery(stdin, "Maximum number of steps: ");
         if ((initial < 0) || (goal < 0) || (increment < 0) || (n <0))
            System.out.println("All parameters must be non-negative.");
         else if (bears(initial, goal, increment, n))
            System.out.println("Yes. The goal can be reached.");
         else
            System.out.println("No. The goal cannot be reached.");
      }  while (query(stdin, "Do you want to try other values?"));         
      
      System.out.println("Thank you beary much.");
   }
    
   /**
   * Print a prompt, then read and return an integer.
   * @param <CODE>prompt</CODE>
   *   a prompt to print
   * @param <CODE>input</CODE>
   *   a Scanner to read input from
   * <dt><b>Postcondition:</b><dd>
   *   The prompt has been printed to <CODE>System.out</CODE>. Then an
   *   integer has been read and returned with <CODE>intInputLine</CODE>.
   **/
   public static int intQuery(Scanner input, String prompt)
   {
      int answer;

      do
      {
         System.out.print(prompt);
         try
         {
	    answer = input.nextInt( );
	    return answer;  
         }
         catch (Exception e)
         {
            System.out.print("Invalid response. Please type an integer value: ");
         }
      }  while (true);
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
   * Determines whether the goal can be reached in the Teddy Bear game.
   * @param <CODE>initial</CODE>
   *   the initial number of bears in the game
   * @param <CODE>goal</CODE>
   *   the goal that must be reached to win the game
   * @param <CODE>increment</CODE>
   *   the number of new bears that you receive when you ask for more bears
   * @param <CODE>n</CODE>
   *   the maximum number of steps permitted to win the game
   * <dt><b>Precondition:</b><dd>
   *   All parameters should be non-negative.
   * <dt><b>Postcondition:</b><dd>
   *   The method has determined whether it is possible to reach the goal in
   *   the following "Teddy Bear" game: In the game, your friend gives you a
   *   certain number of bears. The number of bears is called
   *   <CODE>initial</CODE>, and your goal is to end up with a particular
   *   number of bears, called the <CODE>goal</CODE> number. At any point in 
   *   the game you have two choices: (a) You can ask for (and receive) 
   *   <CODE>increment</CODE> more bears, or (b) if you have an even number of
   *   bears, then you may give half of them back to your friend. Each time you
   *   do (a) or (b), that is called a step in the game. The return value is
   *   true if and only if the goal can be reached in <CODE>n</CODE> steps
   *   or fewer.
   **/
   public static boolean bears(int initial, int goal, int increment, int n)
   {
      if (initial == goal)
         return true;
      else if (n == 0)
         return false;
      else if (bears(initial+increment, goal, increment, n-1))
         return true;
      else if ((initial % 2 == 0) && bears(initial/2, goal, increment, n-1))
         return true;
      else
         return false;
   }
    
}
