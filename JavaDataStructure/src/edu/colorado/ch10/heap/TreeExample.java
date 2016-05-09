package edu.colorado.ch10.heap;

// File: TreeExample.java
// This applet is a small example to illustrate how to write an applet
// that uses trees from, javax.swing.tree. This particular applet
// -- Michael Main (main@colorado.edu)

import javax.swing.JApplet;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeExample extends JApplet
{  
   // The root of a small tree for this Applet to manipulate:
   private JTree sample; 
   
   public void init( )
   {
      DefaultMutableTreeNode root;
      DefaultMutableTreeNode child;
      
      final String ROOT_QUESTION = "Are you a mammal?";
      final String LEFT_QUESTION = "Are you bigger than a cat?";
      final String RIGHT_QUESTION = "Do you live underwater?";
      final String ANIMAL1 = "Kangaroo";
      final String ANIMAL2 = "Mouse";
      final String ANIMAL3 = "Trout";
      final String ANIMAL4 = "Robin";

      // Create the root node:
      root = new DefaultMutableTreeNode(ROOT_QUESTION);

      // Create and attach the left subtree:
      child = new DefaultMutableTreeNode(LEFT_QUESTION);
      child.insert(new DefaultMutableTreeNode(ANIMAL1),0);
      child.insert(new DefaultMutableTreeNode(ANIMAL2),1);
      root.insert(child,0);
      
      // Create and attach the right subtree:
      child = new DefaultMutableTreeNode(RIGHT_QUESTION);
      child.insert(new DefaultMutableTreeNode(ANIMAL3),0);
      child.insert(new DefaultMutableTreeNode(ANIMAL4),1);
      root.insert(child,1);

      // Create the JTree and add it to the applet (with a handle on the root).
      // Note that a JApplet uses getContentPane( ).add rather than just add:
      sample = new JTree(root);
      sample.setShowsRootHandles(true);
      getContentPane( ).add(sample);
   }

}
