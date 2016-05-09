package applications;

// FILE: WordTags.java
// This demonstration illustrates the use of TreeMaps and Iterators.
// The program opens and reads a file called sentences.txt.
// Each line in this file should consist of an English word followed by
// a tag number from 0 to MAXTAG (defined in readTagFile).
// The tag numbers can represent things such
// as parts of speech (0 is a noun, 1 is a verb, etc).
// The program reads the tag file and then permits the use to make two
// kinds of queries:
// -- What tags appear with a given word?
// -- What words appear for a given tag?

import java.util.*;  // Provides TreeMap, Iterator
import edu.colorado.io.EasyReader;

public class WordTags
{
   public static void main(String[ ] args)
   {   
      TreeMap tags = new TreeMap( );

      readTagFile(tags);  
      testWords(tags);
      testTags(tags);
   }

   private static void readTagFile(TreeMap tags)
   {
      final int MAXTAG = 99;
      final String filename = "sentences.txt";
      
      EasyReader tagfile = new EasyReader(filename);
	
      String word;
      int tagnum;
      int[ ] count;
      
      while (!tagfile.isEOF( ))
      {
	 word = tagfile.stringInput( );
	 tagnum = tagfile.intInputLine( );
	 if (tags.containsKey(word))
	 {  // The word has occurred before, so get its count array from the map
	    count = (int[ ]) tags.get(word);
	 }
         else
	 {  // First occurrence of this word
	    count = new int[MAXTAG+1]; // Initialized to all zeros by Java
	 }
         if (0 <= tagnum && tagnum <= MAXTAG)
	    count[tagnum]++;
	 tags.put(word, count);
      }
   }

   private static void testWords(TreeMap tags)
   {
      EasyReader stdin = new EasyReader(System.in);
      String word;
      int tagnum;
      int[ ] count;
      int total;
      
      System.out.println("--------------------------------------------------");
      while (stdin.query("Do you want to test a word?"))
      {
	 word = stdin.stringQuery("Please type an English word: ");
         if (!tags.containsKey(word))
	 {
	    System.out.println(word + " does not occur in the data.");
	 }
	 else
	 {
	    count = (int[ ]) tags.get(word);
	    System.out.println(word + " appears with these valid tag numbers:");
	    total = 0;
	    for (tagnum = 0; tagnum < count.length; tagnum++)
	    {
	       if (count[tagnum] != 0)
	       {      
		  System.out.println("  Occurrences with tag " + tagnum + ": " + count[tagnum]);
		  total += count[tagnum];
	       }
	    }
	    System.out.println("  Total occurrences with valid tags: " + total + "\n");
	 }
      }
      System.out.println("--------------------------------------------------");
   }

   private static void testTags(TreeMap tags)
   {
      EasyReader stdin = new EasyReader(System.in);
      String word;
      int tagnum;
      int[ ] count;
      int total;
      Iterator it;
      
      System.out.println("--------------------------------------------------");
      while (stdin.query("Do you want to test a tag?"))
      {
	 tagnum = stdin.intQuery("Please type a tag number: ");
         it = tags.keySet( ).iterator( );
	 System.out.println("These words occur with tag " + tagnum + ":");
	 total = 0;
	 while (it.hasNext( ))
	 {
	    word = (String) it.next( );
	    count = (int[ ]) tags.get(word);
	    if (0 <= tagnum && tagnum < count.length && count[tagnum] != 0)
	    {
	       System.out.println("  Occurrences of " + word + ": " + count[tagnum]);
               total += count[tagnum];	        
	    }
	 }
	 System.out.println("  Total occurrences of this tag: " + total + "\n");
      }
      System.out.println("--------------------------------------------------");
   }

}
