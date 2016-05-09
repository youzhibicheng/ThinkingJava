package com.thinking.swing;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;

/**
   This program demonstrates the use of a progress bar
   to monitor the progress of a thread.
*/
public class ProgressBarTest
{  
   public static void main(String[] args)
   {  
      JFrame frame = new ProgressBarFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);      
   }
}

/**
   A frame that contains a button to launch a simulated activity,
   a progress bar, and a text area for the activity output.
*/
class ProgressBarFrame extends JFrame
{  
   public ProgressBarFrame()
   {  
      setTitle("ProgressBarTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // this text area holds the activity output
      textArea = new JTextArea();

      // set up panel with button and progress bar

      JPanel panel = new JPanel();
      startButton = new JButton("Start");
      progressBar = new JProgressBar();
      progressBar.setStringPainted(true);
      panel.add(startButton);
      panel.add(progressBar);

      checkBox = new JCheckBox("indeterminate");// indeterminate a. 不确的,不确定的,含混的
      checkBox.addActionListener(new 
         ActionListener()
         {  
            public void actionPerformed(ActionEvent event)
            {  
               progressBar.setIndeterminate(checkBox.isSelected());
            }
         });
      panel.add(checkBox);
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      add(panel, BorderLayout.SOUTH); 

      // set up the button action

      startButton.addActionListener(new 
         ActionListener()
         {  
            public void actionPerformed(ActionEvent event)
            {  
               progressBar.setMaximum(1000);
               activity = new SimulatedActivity(1000);
               new Thread(activity).start();
               activityMonitor.start();
               startButton.setEnabled(false);
            }
         });


      // set up the timer action

      activityMonitor = new Timer(500, new 
         ActionListener()
         {  
            public void actionPerformed(ActionEvent event)
            {  
               int current = activity.getCurrent();
               
               // show progress
               textArea.append(current + "\n");
               progressBar.setStringPainted(!progressBar.isIndeterminate());
               progressBar.setValue(current);
               
               // check if task is completed
               if (current == activity.getTarget())
               {  
                  activityMonitor.stop();
                  startButton.setEnabled(true);
               }
            }
         });
   }

   private Timer activityMonitor;
   private JButton startButton;
   private JProgressBar progressBar;
   private JCheckBox checkBox;
   private JTextArea textArea;
   private SimulatedActivity activity;

   public static final int DEFAULT_WIDTH = 400;
   public static final int DEFAULT_HEIGHT = 200;
}

/**
   A similated activity runnable.
*/
class SimulatedActivity implements Runnable
{ 
   /**
      Constructs the simulated activity thread object. The
      thread increments a counter from 0 to a given target.
      @param t the target value of the counter.
   */
   public SimulatedActivity(int t)
   {  
      current = 0;
      target = t;
   }

   public int getTarget()
   {  
      return target;
   }

   public int getCurrent()
   {  
      return current;
   }

   public void run()
   {  
      try
      {
         while (current < target)
         {    
            Thread.sleep(100);
            current++;
         }
      }
      catch(InterruptedException e)
      {  
      }
   }
   /*
    * Volatile修饰的成员变量在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。
    * 而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
    * Java语言规范中指出：为了获得最佳速度，允许线程保存共享成员变量的私有拷贝，而且只当线程进入或者离开同步代码块时才与共享成员变量的原始值对比。
    * 这样当多个线程同时与某个对象交互时，就必须要注意到要让线程及时的得到共享成员变量的变化。 
    * 而volatile关键字就是提示VM：对于这个成员变量不能保存它的私有拷贝，而应直接与共享成员变量交互。 
    * 使用建议：在两个或者更多的线程访问的成员变量上使用volatile。当要访问的变量已在synchronized代码块中，或者为常量时，不必使用。 
    * 由于使用volatile屏蔽掉了VM中必要的代码优化，所以在效率上比较低，因此一定在必要时才使用此关键字。
    * */
   private volatile int current;//volatile a. 反复无常的,挥发性的

   private int target;
}







