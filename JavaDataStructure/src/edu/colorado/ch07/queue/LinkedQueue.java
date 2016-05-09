// File: LinkedQueue.java from the package edu.colorado.collections
// Complete documentation is available from the LinkedQueue link in:
//   http://www.cs.colorado.edu/~main/docs/

package edu.colorado.ch07.queue;

import java.util.NoSuchElementException;

import edu.colorado.ch04.link.Node;

/******************************************************************************
* A <CODE>LinkedQueue&lt;E&gt;</CODE> is a queue of references to E objects.
*
* <dl><dt><b>Limitations:</b><dd>
*   Beyond <CODE>Int.MAX_VALUE</CODE> items, <CODE>size</CODE> is wrong. 
* </dl>
*
* <dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/LinkedQueue.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/LinkedQueue.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jul 21, 2005
*
* @see ArrayQueue
******************************************************************************/
//Queue的链表实现
public class LinkedQueue<E> implements Cloneable
{
   // Invariant of the LinkedQueue class:
   //   1. The number of items in the queue is stored in the instance variable
   //      manyNodes.
   //   2. The items in the queue are stored in a linked list, with the front 
   //      of the queue stored at the head node, and the rear of the queue at 
   //      the final node.
   //   3. For a non-empty queue, the instance variable front is the head 
   //      reference of the linked list of items and the instance variable rear
   //      is the tail reference of the linked list. For an empty queue, both 
   //      front and rear are the null reference.
   private int manyNodes;
   private Node<E> front;	//第一个结点
   private Node<E> rear;	//最后一个结点


   /**
   * Initialize an empty queue.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   This queue is empty.
   **/   
   public LinkedQueue( )
   {
      front = null;
      rear = null;
   }


   /**
   * Put a new a new item in this queue. 
   * @param <CODE>item</CODE>
   *   the item to be pushed onto this queue 
   * <dt><b>Postcondition:</b><dd>
   *   The item has been pushed onto this queue.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for increasing the queue's capacity.
   * <dt><b>Note:</b><dd>
   *   An attempt to increase the capacity beyond
   *   <CODE>Integer.MAX_VALUE</CODE> will cause the queue to fail with an
   *   arithmetic overflow.
   **/    
   public void add(E item)
   {
       if (isEmpty( ))
       {  // Insert first item.
	  front = new Node<E>(item, null);
	  rear = front;
       }
       else
       {  // Insert an item that is not the first.
          rear.addNodeAfter(item);
          rear = rear.getLink( );          
       }
       manyNodes++;
   }
              
   
   /**
   * Generate a copy of this queue.
   * @param - none
   * @return
   *   The return value is a copy of this queue. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to an <CODE>LinkedQueue</CODE> before it can be used.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public LinkedQueue<E> clone( )       
   {  // Clone a LinkedQueue<E>.
      LinkedQueue<E> answer;
      Node<E>[ ] cloneInfo;
      
      try
      {
         answer = (LinkedQueue<E>) super.clone( );
      }
      catch (CloneNotSupportedException e)
      { 
         // This exception should not occur. But if it does, it would probably indicate a
         // programming error that made super.clone unavailable. The most comon error
         // The most common error would be forgetting the "Implements Cloneable"
         // clause at the start of this class.
         throw new RuntimeException
         ("This class does not implement Cloneable");
      }
      
      cloneInfo = Node.listCopyWithTail(front);
      answer.front = cloneInfo[0];
      answer.rear = cloneInfo[1];
      
      return answer;
   }        

 
   /**
   * Determine whether this queue is empty.
   * @param - none
   * @return
   *   <CODE>true</CODE> if this queue is empty;
   *   <CODE>false</CODE> otherwise. 
   **/
   public boolean isEmpty( )
   {
      return (manyNodes == 0);
   }


   /**
   * Get the front item, removing it from this queue.
   * @param - none
   * <dt><b>Precondition:</b><dd>
   *   This queue is not empty.
   * <dt><b>Postcondition:</b><dd>
   *   The return value is the front item of this queue, and the item has
   *   been removed.
   * @exception NoSuchElementException
   *   Indicates that this queue is empty.
   **/    
   public E remove( )
   {
      E answer;

      if (manyNodes == 0)
         // NoSuchElementException is from java.util and its constructor has no argument.
         throw new NoSuchElementException("Queue underflow");
      answer = front.getData( );
      front = front.getLink( );
      manyNodes--;
      if (manyNodes == 0)
         rear = null;
      return answer;
   }
   
   
   /**
   * Accessor method to determine the number of items in this queue.
   * @param - none
   * @return
   *   the number of items in this queue
   **/ 
   public int size( )   
   {
      return manyNodes;
   }

}
