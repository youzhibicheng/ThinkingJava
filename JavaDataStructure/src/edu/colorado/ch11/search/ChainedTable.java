// File: ChainedTable.java from the package edu.colorado.collections
// This is an assignment for students to complete after reading Chapter 11 of
// "Data Structures and Other Objects Using Java" by Michael Main.

package edu.colorado.ch11.search;

/******************************************************************************
* A <CODE>ChainedTable</CODE> is a chained hash table.
* The implementation isn't given here since it is an assignment in a typical
* data structures class. In general,
* programs should  use java.util.HashTable
* rather than this ChainedTable.
*
* <dt><b>Outline of Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/ChainedTable.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/ChainedTable.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jan 24, 1999
******************************************************************************/
public class ChainedTable
{
   // Invariant of the ChainedTable class:
   //   1. An element with a given key is stored as part of the linked list at
   //      table[hash(key)].
   private ChainedHashNode[ ] table;

     
   /**
   * Initialize an empty ChainedTable with a specified table size.
   * @param <CODE>tableSize</CODE>
   *   the table size for this new chained hash table
   * <dt><b>Precondition:</b><dd>
   *   <CODE>tableSize > 0</CODE>
   * <dt><b>Postcondition:</b><dd>
   *   This ChainedTable is empty and has the specified table size.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the specified table size. 
   * @exception IllegalArgumentException
   *   Indicates that tableSize is not positive.
   **/   
   public ChainedTable(int tableSize)
   {
      if (tableSize <= 0)
	   throw new IllegalArgumentException("Table size must be positive.");
      // Allocate the table which is initially all null head references.
      table = new ChainedHashNode[tableSize];
   }
   
   
   /**
   * Determines whether a specified key is in this ChainedTable.
   * @param <CODE>key</CODE>
   *   the non-null key to look for
   * <dt><b>Precondition:</b><dd>
   *   <CODE>key</CODE> cannot be null.
   * @return
   *   <CODE>true</CODE? (if this ChainedTable contains an object with the specified 
   *   key); <CODE>false</CODE> otherwise. Note that <CODE>key.equals( )</CODE>
   *   is used to compare the <CODE>key</CODE> to the keys that are in the 
   *   ChainedTable.
   * @exception NullPointerException
   *   Indicates that <CODE>key</CODE> is null.
   **/
   public boolean containsKey(Object key)
   {
      // The following return statement should be replaced by the student's code:
      return false;
   }
   
   
   /** Retrieves an object for a specified key.
   * @param <CODE>key</CODE>
   *   the non-null key to look for
   * <dt><b>Precondition:</b><dd>
   *   <CODE>key</CODE> cannot be null.
   * @return
   *   a reference to the object with the specified <CODE>key</CODE (if this 
   *   ChainedTable contains an such an object);  null otherwise. Note that 
   *   <CODE>key.equals( )</CODE> is used to compare the <CODE>key</CODE>
   *   to the keys that are in the ChainedTable.
   * @exception NullPointerException
   *   Indicates that <CODE>key</CODE> is null.
   **/
   public Object get(Object key)
   {
      // The following return statement should be replaced by the student's code:
      return null;
   }
   
   
   private int hash(Object key)
   // The return value is a valid index of the ChainedTable's table. The index is
   // calculated as the remainder when the absolute value of the key's
   // hash code is divided by the size of the ChainedTable's table.
   {
      return Math.abs(key.hashCode( )) % table.length;
   }
   
   
   /**
   * Add a new element to this ChainedTable, using the specified key.
   * @param <CODE>key</CODE>
   *   the non-null key to use for the new element
   * @param <CODE>element</CODE>
   *   the new element that's being added to this ChainedTable
   * <dt><b>Precondition:</b><dd>
   *   Neither <CODE>key</CODE> nor </CODE>element</CODE> is null.
   * <dt><b>Postcondition:</b><dd>
   *   If this ChainedTable already has an object with the specified <CODE>key</CODE>,
   *   then that object is replaced by </CODE>element</CODE>, and the return 
   *   value is a reference to the replaced object. Otherwise, the new 
   *   </CODE>element</CODE> is added with the specified <CODE>key</CODE>
   *   and the return value is null.
   * @exception NullPointerException
   *   Indicates that <CODE>key</CODE> or <CODE>element</CODE> is null.   
   **/
   public Object put(Object key, Object element)
   {
      ChainedHashNode cursor = null;
      Object answer = null;

      // Student code should be placed here to set cursor so that it refers to
      // the node that already contains the specified key. If there is no such
      // node, then the student code should set cursor to null.

      if (cursor == null)
      {  // Add a new node at the front of the list of table[hash(key)].
		 int i = hash(key);
		 cursor = new ChainedHashNode( );
		 cursor.element = element;
		 cursor.key = key;
		 cursor.link = table[i];
		 table[i] = cursor;
      }
      else
      {  // The new element replaces an old node.
         answer = cursor.element;
         cursor.element = element;
      }

      return answer;
   }
      
   
   /**
   * Removes an object for a specified key.
   * @param <CODE>key</CODE>
   *   the non-null key to look for
   * <dt><b>Precondition:</b><dd>
   *   <CODE>key</CODE> cannot be null.
   * <dt><b>Postcondition:</b><dd>
   *   If an object was found with the specified </CODE>key</CODE>, then that
   *   object has been removed from this ChainedTable and a copy of the removed object
   *   is returned; otherwise, this ChainedTable is unchanged and the null reference
   *   is returned.  Note that 
   *   <CODE>key.equals( )</CODE> is used to compare the <CODE>key</CODE>
   *   to the keys that are in the ChainedTable.
   * @exception NullPointerException
   *   Indicates that </CODE>key</CODE> is null.
   **/
   public Object remove(Object key)
   {
      // The following return statement should be replaced by the student's code:
      return null;
   }
        
}
           
class ChainedHashNode
{
   Object element;
   Object key;
   ChainedHashNode link;
}
