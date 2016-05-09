/**
   @version 1.21 2004-08-30
   @author Cay Horstmann
*/

package com.corejava7.javabean;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.beans.*;

/**
   The property editor for the inverse property of the ChartBean.
   The inverse property toggles between colored graph bars
   and colored background.
*/
public class InverseEditor extends PropertyEditorSupport
{  
   public Component getCustomEditor() { return new InverseEditorPanel(this); }
   public boolean supportsCustomEditor() { return true; }
   public boolean isPaintable() { return true; }
   public String getAsText() { return null; }
   //通过这个方法，可以将设置属性当前值的Java代码交给开发工具
   //开发工具就可以使用这个字符串自动生成代码
   public String getJavaInitializationString() { return "" + getValue(); }

   public void paintValue(Graphics g, Rectangle box)
   {  
      Graphics2D g2 = (Graphics2D) g;
      boolean isInverse = (Boolean) getValue();
      String s = isInverse ? "Inverse" : "Normal";
      g2.setPaint(isInverse ? Color.black : Color.white);
      g2.fill(box);
      g2.setPaint(isInverse ? Color.white : Color.black);
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D stringBounds = g2.getFont().getStringBounds(s, context);
      double w = stringBounds.getWidth();
      double x = box.x;
      if (w < box.width) x += (box.width - w) / 2;
      double ascent = -stringBounds.getY();
      double y = box.y + (box.height - stringBounds.getHeight()) / 2 + ascent;
      g2.drawString(s, (float) x, (float) y);
   }
}


