/**
   @version 1.11 2004-08-30
   @author Cay Horstmann
*/

package com.corejava7.javabean;

import java.beans.*;

/**
   A custom editor for the titlePosition property of the 
   ChartBean. The editor lets the user choose between
   Left, Center, and Right
*/
public class TitlePositionEditor
   extends PropertyEditorSupport
{  
   //将所有可选项都列出来
   public String[] getTags() { return options; }
   private String[] options = { "Left", "Center", "Right" };
   public String getJavaInitializationString() { return "" + getValue(); }
   //用于在选项栏的显示
   public String getAsText()
   {  
      int value = (Integer) getValue();
      return options[value];
   }
 //用于在选项栏的设置值
   public void setAsText(String s)
   {  
      for (int i = 0; i < options.length; i++)
      {  
         if (options[i].equals(s))
         {  
            setValue(i);
            return;
         }
      }
   }
}

