package com.corejava7.awt;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import java.util.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.swing.*;

/**
   This program demonstrates how to print 2D graphics
*/
public class PrintTest
{  
   public static void main(String[] args)
   {  
      JFrame frame = new PrintTestFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   This frame shows a panel with 2D graphics and buttons
   to print the graphics and to set up the page format.
*/
class PrintTestFrame extends JFrame
{  
   public PrintTestFrame()
   {  
      setTitle("PrintTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      
      canvas = new PrintPanel();
      add(canvas, BorderLayout.CENTER);
      //构造一个新的空打印请求属性集
      //可以在一个实现了PrintRequestAttributeSet接口的类的对象中收集到各种打印机的设置，然后把该对象作为参数传递给PrintDialog方法
      attributes = new HashPrintRequestAttributeSet();
      
      JPanel buttonPanel = new JPanel();
      JButton printButton = new JButton("Print");
      buttonPanel.add(printButton);
      printButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               try
               {
            	  //启动打印作业
                  PrinterJob job = PrinterJob.getPrinterJob();
                  job.setPrintable(canvas);
                  //在开始打印作业之前，应该调用printDialog方法来显示一个打印对话框
                  if (job.printDialog(attributes))
                     job.print(attributes);//
               }
               catch (PrinterException e)
               {  
                  JOptionPane.showMessageDialog(PrintTestFrame.this, e);
               }
            }
         });

      JButton pageSetupButton = new JButton("Page setup");
      buttonPanel.add(pageSetupButton);
      pageSetupButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               PrinterJob job = PrinterJob.getPrinterJob();
               //显示跨平台页面设置对话框的便捷方法。可用的选择将反映当前在此 PrinterJob 上设置的打印服务。
               //输入的 attributes 参数将反映用户对话框中最初选择所需的客户端。未指定 attributes 时使用该服务的默认应用程序显示。返回时，它将反映用户的选择。可以更新选择，以与当前选择的打印服务支持的值一致。 
               //返回值为 PageFormat，它等于 PrintRequestAttributeSet 中选择的值。如果用户取消对话框，则 attributes 将不会反映用户进行的任何更改，并且返回值将为 null。 
               job.pageDialog(attributes);
            }
         });

      add(buttonPanel, BorderLayout.NORTH);
   }

   private PrintPanel canvas;
   private PrintRequestAttributeSet attributes;

   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 300;
}

/**
   This panel generates a 2D graphics image for screen display
   and printing.
   提供一个实现了Printable接口的对象，该接口只有下面1个方法 
*/
class PrintPanel extends JPanel implements Printable
{  
   public void paintComponent(Graphics g)
   {  
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      drawPage(g2);
   }

   public int print(Graphics g, PageFormat pf, int page)
      throws PrinterException
   {  
      if (page >= 1) return Printable.NO_SUCH_PAGE;
      Graphics2D g2 = (Graphics2D) g;
      g2.translate(pf.getImageableX(), pf.getImageableY());
      g2.draw(new Rectangle2D.Double(0, 0, pf.getImageableWidth(), pf.getImageableHeight()));

      drawPage(g2);
      return Printable.PAGE_EXISTS;
   }

   /**
      This method draws the page both on the screen and the
      printer graphics context.
      @param g2 the graphics context
   */
   public void drawPage(Graphics2D g2)
   {  
      FontRenderContext context = g2.getFontRenderContext();
      Font f = new Font("Serif", Font.PLAIN, 72);
      GeneralPath clipShape = new GeneralPath();

      TextLayout layout = new TextLayout("Hello", f, context);
      AffineTransform transform = AffineTransform.getTranslateInstance(0, 72);
      Shape outline = layout.getOutline(transform);
      clipShape.append(outline, false);

      layout = new TextLayout("World", f, context);
      transform  = AffineTransform.getTranslateInstance(0, 144);
      outline = layout.getOutline(transform);
      clipShape.append(outline, false);

      g2.draw(clipShape);
      g2.clip(clipShape);

      final int NLINES =50;
      Point2D p = new Point2D.Double(0, 0);
      for (int i = 0; i < NLINES; i++)
      {  
         double x = (2 * getWidth() * i) / NLINES;
         double y = (2 * getHeight() * (NLINES - 1 - i))
            / NLINES;
         Point2D q = new Point2D.Double(x, y);
         g2.draw(new Line2D.Double(p, q));
      }
   }
}


