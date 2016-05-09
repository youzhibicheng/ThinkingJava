package com.thinking.distributed;

import java.io.*;
import java.rmi.*;
import java.util.*;
import java.rmi.server.*;
import java.util.*;
import java.util.concurrent.locks.*;

/**
   This class is the implementation for the remote
   Warehouse interface.
*/
public class WarehouseImpl
   extends UnicastRemoteObject
   implements Warehouse
{  
   /**
      Constructs a warehouse implementation.
   */
   public WarehouseImpl()
      throws RemoteException
   {  
      products = new ArrayList<ProductImpl2>();
      add(new ProductImpl2("Core Java Book", 0, 200, Product2.BOTH, "Computers"));
   }

   /**
      Add a product to the warehouse. Note that this is a local method.
      @param p the product to add
   */
   public void add(ProductImpl2 p)
   {  
      Lock wlock = rwlock.writeLock();
      wlock.lock();
      try 
      {
         products.add(p);
      }
      finally
      {
         wlock.unlock();
      }
   }

   public ArrayList<Product2> find(Customer c)
      throws RemoteException
   {  
      Lock rlock = rwlock.readLock();
      rlock.lock();
      try 
      {
         ArrayList<Product2> result = new ArrayList<Product2>();
         // add all matching products
         for (ProductImpl2 p : products)
         {  
            if (p.match(c)) result.add(p);
         }
         // add the product that is a good match for everyone, a copy of Core Java
         if (!result.contains(products.get(0)))
            result.add(products.get(0));
         
         // we reset c just to show that c is a copy of the client object
         c.reset(); 
         return result;
      }
      finally
      {
         rlock.unlock();
      }
   }

   private ArrayList<ProductImpl2> products;
   private ReadWriteLock rwlock = new ReentrantReadWriteLock();
}
