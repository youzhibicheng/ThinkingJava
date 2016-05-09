package com.thinking.applet;


import java.awt.*;
import javax.swing.*;

public class CalculatorApplet extends JApplet
{  
   public void init()
   {  
      CalculatorPanel panel = new CalculatorPanel();
      add(panel);
   }
}




