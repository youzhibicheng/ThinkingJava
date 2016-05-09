package com.corejava7.graphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CenteredFrameTest
{  
   public static void main(String[] args)
   {  
      CenteredFrame frame = new CenteredFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);  
   }
}

class CenteredFrame extends JFrame
{
   public CenteredFrame()
   {
      // get screen dimensions

      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension screenSize = kit.getScreenSize();
      int screenHeight = screenSize.height;
      System.out.println("screenHeight="+screenHeight);
      int screenWidth = screenSize.width;
      System.out.println("screenWidth="+screenWidth);

      // center frame in screen

      setSize(screenWidth / 2, screenHeight / 2);
      setLocation(screenWidth / 4, screenHeight / 4);

      // set frame icon and title

      Image img = kit.getImage("src/com/thinking/graphics/icon.gif");
      setIconImage(img);
      setTitle("CenteredFrame");
   }
}

