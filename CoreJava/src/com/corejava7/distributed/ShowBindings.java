package com.corejava7.distributed;

import java.rmi.*;
import java.rmi.server.*;
import javax.naming.*;

/**
   This programs shows all RMI bindings.
*/
public class ShowBindings
{  
   public static void main(String[] args)
   {  
      try
      {  
         Context namingContext = new InitialContext();
         NamingEnumeration<NameClassPair> e = namingContext.list("rmi:");
         while (e.hasMore())
            System.out.println(e.next().getName());
      }
      catch (Exception e)
      {  
         e.printStackTrace();
      }
   }
}
