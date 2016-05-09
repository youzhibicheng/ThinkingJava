// File: LinkedSeq.java from the package edu.colorado.linked

// This is an assignment for students to complete after reading Chapter 5 of
// "Data Structures and Other Objects Using Java" by Michael Main.

// Check with your instructor to see whether you should put this class in
// a package. At the moment, it is declared as part of edu.colorado.collections:
package edu.colorado.ch04.link;

// My suggested implementation uses this Node class from Chapter 5:

/******************************************************************************
* This class is a homework assignment;									       
* A <CODE>LinkedSeq</CODE> is a sequence of references to Objects.
* The sequence can have a special "current element," which is specified and
* accessed through four methods that are not available in the bag classes
* (<CODE>start, getCurrent, advance,</CODE> and <CODE>isCurrent</CODE>).
*
* <dl><dt><b>Limitations:</b> <dd>
*   Beyond <CODE>Long.MAX_VALUE</CODE> elements, the <CODE>size</CODE> method
*   does not work. This is not a
*   problem for current implementations of the Java Virtual Machine (JVM). 
*   But future JVMs could have heaps that allow linked lists longer than
*   <CODE>Long.MAX_VALUE</CODE>.
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* <dt><b>Java Source Code for the stubs of this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/LinkedSeq.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/LinkedSeq.java
*   </A> 
*   </dl>
*
* @version
*   Jan 24, 1999
******************************************************************************/
public class LinkedSeq implements Cloneable
{
   // Invariant of the LinkedSeq class:
   //  1. manyNodes is the number of nodes in the sequence.
   //  2. The nodes form a linked list, with head and tail being references
   //     to the head and tail of the list. If the list is empty, then both
   //     head and tail are null.
   //  3. If there is a current element, then cursor is a reference to the node
   //     that contains the current element; otherwise cursor is null.
   //  4. If there is a current element, and the current element is not at the
   //     head, then precursor refers to the node before cursor. Otherwise,
   //     precursor is null.
   private Node head;
   private Node tail;
   private Node cursor;
   private Node precursor;
   private long manyNodes;   

   /**
   * Initialize an empty sequence.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   This sequence is empty.
   **/
   public LinkedSeq( )
   {
   }
   
   
   /**
   * Adds a new element to this sequence, after the current element.
   * @param <CODE>element</CODE>
   *   a reference to the new element that is being added
   * <dt><b>Postcondition:</b><dd>
   *   A reference to the element has been added to this sequence. If there
   *   was a current element, the new element is placed after the current
   *   element. If there was no current element, the new element is placed at
   *   the end of the sequence. In all cases, the new element becomes the new
   *   current element of the sequence. Note that the newly added element may 
   *   be a null reference.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addAfter(Object element)
   {
   }
   
   
   /**
   * Adds a new element to this sequence, before the current element.
   * @param <CODE>element</CODE>
   *   a reference to the new element that is being added
   * <dt><b>Postcondition:</b><dd>
   *   A reference to the element has been added to this sequence. If there
   *   was a current element, the new element is placed before the current
   *   element. If there was no current element, the new element is placed at
   *   the start of the sequence. In all cases, the new element becomes the new
   *   current element of the sequence. Note that the newly added element may 
   *   be a null reference.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addBefore(Object element)
   {
   }


   /**
   * Place the contents of another sequence at the end of this sequence.
   * @param <CODE>addend</CODE>
   *   a sequence whose contents will be placed at the end of this sequence
   * <dt><b>Precondition:</b><dd>
   *   The parameter, <CODE>addend</CODE>, is not null.
   * <dt><b>Postcondition:</b><dd>
   *   The elements from <CODE>addend</CODE> have been placed at the end of
   *   this sequence. The current element of this sequence remains where it
   *   was, and the <CODE>addend</CODE> is also unchanged.
   * @throws NullPointerException
   *   Indicates that addend is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of this sequence.   
   **/
   public void addAll(LinkedSeq addend)
   {
   }
   
   
   /**
   * Move forward, so that the current element is now the next element in 
   * the sequence.
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   <CODE>isCurrent( )</CODE> returns <CODE>true</CODE>.
   * <dt><b>Postcondition:</b><dd>
   *   If the current element was already the end element of the sequence 
   *   (with nothing after it), then there is no longer any current element.
   *   Otherwise, the new element is the element immediately after the 
   *   original current element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so advance may not be 
   *   activated.
   **/
   public void advance( )
   {
   }
   
   
   /**
   * Generate a copy of this sequence.
   * @param - none
   * @return
   *   The return value is a copy of this sequence. Subsequent changes to 
   *   the copy will not affect the original, nor vice versa. The return value
   *   must be type cast to a <CODE>LinkedSeq</CODE> before it is used.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/
   public Object clone( )
   {  // Clone a LinkedSeq object.
      LinkedSeq answer;
      
      try
      {
         answer = (LinkedSeq) super.clone( );
      }
      catch (CloneNotSupportedException e)
      {  // This exception should not occur. But if it does, it would probably
         // indicate a programming error that made super.clone unavailable.
         // The most common error would be forgetting the "Implements Cloneable"
         // clause at the start of this class.
         throw new RuntimeException
         ("This class does not implement Cloneable");
      }
      
      // STUDENT CODE GOES HERE TO MODIFY THE ANSWER SO THAT IT DOESN'T
      // SHARE THE SAME LINKED LIST WITH THE ORIGINAL.
      
      return answer;
   }
   

   /**
   * Create a new sequence that contains all the elements from one sequence
   * followed by another.
   * @param <CODE>s1</CODE>
   *   the first of two sequences
   * @param s2
   *   the second of two sequences
   * <dt><b>Precondition:</b><dd>
   *   Neither <CODE>s1</CODE> nor <CODE>s2</CODE> is null.
   * @return
   *   a new sequence that has the elements of <CODE>s1</CODE> followed by 
   *   <CODE>s2</CODE> (with no current element)
   * @exception NullPointerException
   *   Indicates that one of the arguments is null.
   * @throws OutOfMemoryError
   *   Indicates insufficient memory for the new sequence.
   **/
   public static LinkedSeq concatentation(LinkedSeq s1, LinkedSeq s2)
   {
      return null; // To permit this stub to compile
   }
   
   
   /**
   * Accessor method to determine the current capacity of this sequence. The 
   * <CODE>addBefore</CODE> and <CODE>addAfter</CODE> methods works efficiently
   * (without needing more memory) until this capacity is reached.
   * @param - none
   * @return
   *   the current capacity of this sequence
   **/
   public Object getCurrent( )
   {
      return null;  // To permit this stub to compile
   }
   
   
   /**
   * Accessor method to determine whether this sequence has a specified current
   * element that can be retrieved with the <CODE>getCurrent</CODE> method.
   * @param - none
   * return
   *   <CODE>true</CODE> (there is a current element) or <CODE>false</CODE>
   *   (there is no current element at the moment)
   **/
   public boolean isCurrent( )
   {
      return false;  // To permit this stub to compile
   }
   
   
   /**
   * Remove the current element from this sequence.
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   <CODE>isCurrent()</CODE> returns <CODE>true</CODE>.
   * <dt><b>Postcondition:</b><dd>
   *   The current element has been removed from this sequence, and the
   *   following element (if there is one) is now the new current element. 
   *   If there was no following element, then there is now no current element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so <CODE>removeCurrent</CODE>
   *   may not be called.
   **/
   public void removeCurrent( )
   {
   }
   
   
   /**
   * Accessor method to determine the number of elements in this sequence.
   * @param - none
   * @return
   *   the number of elements in this sequence
   **/
   public long size( )
   {
      return manyNodes;
   }
   
   
   /**
   * Set the current element at the front of this sequence.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   The front element of this sequence is now the current element (but if
   *   this sequence has no elements at all, then there is no current element).
   **/
   public void start( )
   {
   }

}
           
