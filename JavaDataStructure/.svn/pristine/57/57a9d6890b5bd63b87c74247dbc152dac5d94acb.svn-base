package applications;

// FILE: VirtualTest.java
//  This small program tests to see whether static methods are virtual.


class A implements Cloneable
{
     public static void foo( )
	  {
	       System.out.println("A");
	  }
}

class B extends A
{
     public static void foo( )
	  {
	       System.out.println("B");
	  }
}

public class VirtualTest
{                                                                                   
   public static void main(String[ ] args)
	  {
	       B b = new B( );
	       testfoo(b);
	  }

     public static void testfoo(A a)
	  {
	       a.foo( );
	  }
}
 
