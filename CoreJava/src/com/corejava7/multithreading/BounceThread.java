package com.corejava7.multithreading;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

/**
   Shows an animated bouncing BallThread.
*/
public class BounceThread
{
   public static void main(String[] args)
   {
      JFrame frame = new BounceFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A runnable that animates a bouncing BallThread.
*/
class BallThreadRunnable implements Runnable
{
   /**
      Constructs the runnable.
      @aBallThread the BallThread to bounce
      @aPanel the component in which the BallThread bounces
   */
   public BallThreadRunnable(BallThread aBallThread, Component aComponent) 
   { 
      BallThread = aBallThread; 
      component = aComponent;
   }

   public void run()
   {
      try
      {
         for (int i = 1; i <= STEPS; i++)
         {
            BallThread.move(component.getBounds());
            component.repaint();
            Thread.sleep(DELAY);
         }
      }
      catch (InterruptedException e)
      {                    
      }
   }

   private BallThread BallThread;
   private Component component;
   public static final int STEPS = 1000;
   public static final int DELAY = 5;
}

/**
   A BallThread that moves and bounces off the edges of a 
   rectangle
*/
class BallThread
{
   /**
      Moves the BallThread to the next position, reversing direction
      if it hits one of the edges
   */
   public void move(Rectangle2D bounds)
   {
      x += dx;
      y += dy;
      if (x < bounds.getMinX())
      { 
         x = bounds.getMinX();
         dx = -dx;
      }
      if (x + XSIZE >= bounds.getMaxX())
      {
         x = bounds.getMaxX() - XSIZE; 
         dx = -dx; 
      }
      if (y < bounds.getMinY())
      {
         y = bounds.getMinY(); 
         dy = -dy;
      }
      if (y + YSIZE >= bounds.getMaxY())
      {
         y = bounds.getMaxY() - YSIZE;
         dy = -dy; 
      }
   }

   /**
      Gets the shape of the BallThread at its current position.
   */
   public Ellipse2D getShape()
   {
      return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
   }

   private static final int XSIZE = 15;
   private static final int YSIZE = 15;
   private double x = 0;
   private double y = 0;
   private double dx = 1;
   private double dy = 1;
}

/**
   The panel that draws the BallThreads.
*/
class BallThreadPanel extends JPanel
{
   /**
      Add a BallThread to the panel.
      @param b the BallThread to add
   */
   public void add(BallThread b)
   {
      BallThreads.add(b);
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      for (BallThread b : BallThreads)
      {
         g2.fill(b.getShape());
      }
   }

   private ArrayList<BallThread> BallThreads = new ArrayList<BallThread>();
}

/**
   The frame with panel and buttons.
*/
class BounceThreadFrame extends JFrame
{
   /**
      Constructs the frame with the panel for showing the
      bouncing BallThread and Start and Close buttons
   */
   public BounceThreadFrame()
   {
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      setTitle("BounceThread");

      panel = new BallThreadPanel();
      add(panel, BorderLayout.CENTER);
      JPanel buttonPanel = new JPanel();
      addButton(buttonPanel, "Start",
         new ActionListener()
         {  
            public void actionPerformed(ActionEvent event)
            {
               addBallThread();
            }
         });
      
      addButton(buttonPanel, "Close",
         new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });
      add(buttonPanel, BorderLayout.SOUTH);
   }

   /**
      Adds a button to a container.
      @param c the container
      @param title the button title
      @param listener the action listener for the button
   */
   public void addButton(Container c, String title, ActionListener listener)
   {
      JButton button = new JButton(title);
      c.add(button);
      button.addActionListener(listener);
   }

   /**
      Adds a bouncing BallThread to the canvas and starts a thread
      to make it bounce
   */
   public void addBallThread()
   {
      BallThread b = new BallThread();
      panel.add(b);
      Runnable r = new BallThreadRunnable(b, panel);
      Thread t = new Thread(r);
      t.start();
   }

   private BallThreadPanel panel;
   public static final int DEFAULT_WIDTH = 450;
   public static final int DEFAULT_HEIGHT = 350;  
   public static final int STEPS = 1000;
   public static final int DELAY = 3;
}

















