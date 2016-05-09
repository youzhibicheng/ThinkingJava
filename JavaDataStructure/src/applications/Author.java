package applications;

// FILE: Author.java
// This program reads some words into bags. Then a silly story is
// written using these items.

import edu.colorado.ch05.generic.ArrayBag;

import java.util.Scanner;

public class Author
{                                                                                
   private static Scanner stdin = new Scanner(System.in);
   
   public static void main(String[ ] args)
   {   
      final int WORDS_PER_BAG = 4;  // Number of items per bag
      final int MANY_SENTENCES = 3; // Number of sentences in story

      ArrayBag<String> good  = new ArrayBag<String>(WORDS_PER_BAG);
      ArrayBag<String> bad   = new ArrayBag<String>(WORDS_PER_BAG);
      ArrayBag<String> names = new ArrayBag<String>(WORDS_PER_BAG);
      int line;
      
      // Fill the three bags with items typed by the program's user.
      System.out.println("Help me write a story.\n");
      getWords(good,  WORDS_PER_BAG, "adjectives that describe a good mood");
      getWords(bad,   WORDS_PER_BAG, "adjectives that describe a bad mood");
      getWords(names, WORDS_PER_BAG, "first names");
      System.out.println("Thank you for your kind assistance.\n");
      
      // Use the items to write a silly story.
      System.out.println("LIFE");
      System.out.println("by A. Computer\n");
      for (line = 1; line <= MANY_SENTENCES; line++)
      {
         System.out.print((String) names.grab( ));
         System.out.print(" was feeling ");
         System.out.print((String) bad.grab( ));
         System.out.print(", yet he/she was also ");
         System.out.print((String) good.grab( ));
         System.out.println(".");
      }
      System.out.println("Life is " + (String) bad.grab( ) + ".\n");
      System.out.println("The " + (String) good.grab( ) + " end.");
      what( );
   }

   public static void getWords
   (ArrayBag<String> collection, int n, String description)
   // Postcondition: The parameter, description, has been written as a prompt
   // to System.out. Then n strings have been read using stdin.inputString, 
   // and these strings have been placed in the bag.
   {
      String userInput;
      int i;
      
      System.out.print("Please type " + n + " " + description);
      System.out.println(" with a space after each.");
      System.out.println("Press the <return> key after the final entry:");
      for (i = 1; i <= n; i++)
      {
         userInput = stdin.next( );
         collection.add(userInput);
      }
      System.out.println( );       
   }
   
   public static void what(){
	   // TODO
   }
}
