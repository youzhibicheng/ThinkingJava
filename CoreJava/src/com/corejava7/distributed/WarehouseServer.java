package com.corejava7.distributed;

import java.rmi.*;
import java.rmi.server.*;
import javax.naming.*;

/**
   This server program instantiates a remote warehouse
   objects, registers it with the naming service, and waits 
   for clients to invoke methods.
*/
public class WarehouseServer
{  
   public static void main(String[] args)
   {  
      try
      {  
         System.out.println("Constructing server implementations...");
         WarehouseImpl w = new WarehouseImpl();
         w.add(new ProductImpl2("Blackwell Toaster", Product2.BOTH, 18, 200, "Household"));
         w.add(new ProductImpl2("ZapXpress Microwave Oven", Product2.BOTH, 18, 200, "Household"));
         w.add(new ProductImpl2("DirtDigger Steam Shovel", Product2.MALE, 20, 60, "Gardening"));
         w.add(new ProductImpl2("U238 Weed Killer", Product2.BOTH, 20, 200, "Gardening"));
         w.add(new ProductImpl2("Persistent Java Fragrance", Product2.FEMALE, 15, 45, "Beauty"));
         w.add(new ProductImpl2("Rabid Rodent Computer Mouse", Product2.BOTH, 6, 40, "Computers"));
         w.add(new ProductImpl2("My first Espresso Maker", Product2.FEMALE, 6, 10, "Household"));
         w.add(new ProductImpl2("JavaJungle Eau de Cologne", Product2.MALE, 15, 45, "Beauty"));
         w.add(new ProductImpl2("FireWire Espresso Maker", Product2.BOTH, 20, 50, "Computers"));
         w.add(new ProductImpl2("Learn Bad Java Habits in 21 Days Book", Product2.BOTH, 20, 200, 
            "Computers"));

         System.out.println("Binding server implementations to registry...");
         Context namingContext = new InitialContext();
         namingContext.bind("rmi:central_warehouse", w);

         System.out.println("Waiting for invocations from clients...");
      }
      catch (Exception e)
      {  
         e.printStackTrace();
      }
   }
}

