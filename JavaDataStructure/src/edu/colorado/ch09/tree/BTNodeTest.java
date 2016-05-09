package edu.colorado.ch09.tree;

public class BTNodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		printTest();
		removeLeftmostTest();
	}
	
	public static void printTest(){
		// 	  1
		//	2   3
		// 4 5 6 7
		//8
		BTNode node8 = new BTNode(8, null, null);
		BTNode node7 = new BTNode(7, null, null);
		BTNode node6 = new BTNode(6, null, null);
		BTNode node5 = new BTNode(5, null, null);
		BTNode node4 = new BTNode(4, node8, null);
		BTNode node3 = new BTNode(3, node6, node7);
		BTNode node2 = new BTNode(2, node4, node5);
		BTNode node1 = new BTNode(1, node2, node3);
		node1.print(0);
	}

	public static void removeLeftmostTest(){
		BTNode node8 = new BTNode(8, null, null);
		BTNode node7 = new BTNode(7, null, null);
		BTNode node6 = new BTNode(6, null, null);
		BTNode node5 = new BTNode(5, null, null);
		BTNode node4 = new BTNode(4, node8, null);
		BTNode node3 = new BTNode(3, node6, node7);
		BTNode node2 = new BTNode(2, node4, node5);
		BTNode node1 = new BTNode(1, node2, node3);
		node1.removeLeftmost();
		node1.print(0);
	}
}
