package edu.colorado.ch12.sort;
// File: Heapsort.java
// A Java application to illustrate the use of a heapsort
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/Heapsort.html
 
/******************************************************************************
* The <CODE>Heapsort</CODE> Java application illustrates a heapsort.
* Part of the implementation (the <CODE>makeHeap</CODE> and
* <CODE>reheapifyDown</CODE> methods) is left
* as a student exercise.
*
* <p><dt><b>Java Source Code for this class (without 
* <CODE>makeHeap</CODE> and <CODE>reheapifyDown</CODE>:</b><dd>
*   <A HREF="../applications/Heapsort.java">
*   http://www.cs.colorado.edu/~main/applications/Heapsort.java
*   </A>
*
* @author Michael Main and (___student name___) 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jun 12, 1998
******************************************************************************/
public class Heapsort
{
   /**
   * The main method illustrates the use of a heapsort to sort a 
   * small array.
   * The <CODE>String</CODE> arguments (<CODE>args</CODE>) are not used 
   * in this implementation.
   **/
   public static void main(String[ ] args)
   {
      final String BLANKS = "  "; // A String of two blanks
      int i;                      // Array index

      int[ ] data = { 80, 10, 50, 70, 60, 90, 20, 30, 40, 0 };

      // Print the array before sorting:
      System.out.println("Here is the entire original array:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );

      // Sort the numbers, and print the result with two blanks after each number.
      heapsort(data, data.length);
      System.out.println("After sorting, the numbers are:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );
   }
   
   
   /**
   * This method cannot be used until the student implements 
   * <CODE>makeHeap</CODE> and <CODE>reheapifyDown</CODE>.
   * Sort an array of integers from smallest to largest, using a heapsort
   * algorithm.
   * @param <CODE>data</CODE>
   *   the array to be sorted
   * @param <CODE>n</CODE>
   *   the number of elements to sort, (from <CODE>data[0]</CODE> 
   *   through <CODE>data[n-1]</CODE>)
   * <dt><b>Precondition:</b><dd>
   *   <CODE>data</CODE> has at least <CODE>n</CODE> elements.
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>n</CODE> is zero or negative then no work is done. Otherwise, 
   *   the elements of </CODE>data</CODE> have been rearranged so that 
   *   <CODE>data[0] &lt= data[1] &lt= ... &lt= data[n-1]</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that <CODE>data</CODE> has fewer than </CODE>n</CODE> elements.
   * */
   public static void heapsort(int[ ] data, int n)
   {
      int unsorted; // Size of the unsorted part of the array
      int temp;     // Used during the swapping of two array locations

      makeHeap(data, n);

      unsorted = n;

      while (unsorted > 1)
      {
         unsorted--;

         // Swap the largest element (data[0]) with the final element of unsorted part  
         temp = data[0];
         data[0] = data[unsorted];
         data[unsorted] = temp;

         reheapifyDown(data, unsorted);
      }
   }
   
   //建堆
   private static void makeHeap(int[ ] data, int n)
   // Precondition: data is an array with at least n elements.
   // Postcondition: The elements of data have been rearranged so that the
   // complete binary tree represented by this array is a heap.
   {      
      System.err.println("The student needs to implement the makeHeap and");
      System.err.println("reheapifyDown methods before the heapsort can be used.");
      System.exit(0);
   }

   //向下堆重排
   private static void reheapifyDown(int[ ] data, int n)
   // Precondition: n > 0, and data is an array with at least n elements. These
   // elements form a heap, except that data[0] may be in an incorrect
   // location.
   // Postcondition: The data values have been rearranged so that the first
   // n elements of data now form a heap.
   {
      System.err.println("The student needs to implement the makeHeap and");
      System.err.println("reheapifyDown methods before the heapsort can be used.");
      System.exit(0);
   }
}


