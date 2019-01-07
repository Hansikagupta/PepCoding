package JanbinaryTree;

import java.util.LinkedList;

import JanbinaryTree.BinaryTree.PairPO;
import JanbinaryTree.BinaryTree.isBal;

public class clientbT {

	public static class BinofDec {
		int number;
		String bin = "";
//		int counter = 0;
	}

	public static void binary( int maxNo) {
		LinkedList<BinofDec> que = new LinkedList<>();
		BinofDec startNode = new BinofDec();
		startNode.number = 1;
		startNode.bin = "1";
		que.add(startNode);

		while (que.get(0).number < maxNo) {
			if (que.size() > 0) {
				BinofDec top = que.removeFirst();

				System.out.println(top.number+ " = " + top.bin + ", ");

				if (top.number * 2 < maxNo) {
					BinofDec n2 = new BinofDec();
					n2.bin = top.bin + "0";
					n2.number = top.number * 2;
					que.push(n2);
				} 
				if (top.number * 2  + 1< maxNo) {
					BinofDec n21 = new BinofDec();
					n21.bin = top.bin + "1";
					n21.number = top.number * 2 + 1; 
					que.push(n21);

				} 
			}
		}

	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1,
				-1, -1);
		bt.display();
//		System.out.println(bt.size());
//		System.out.println(bt.height());
//		System.out.println(bt.max());
//
////		bt.removeLeaves();
//		bt.display();
//		System.out.println();
//		bt.noSibling();
//		System.out.println(bt.find(31));
//		System.out.println(bt.nodeToRootPath(62));
//		bt.kAway(75, 2);
//		bt.printPathToLeafInRange(150, 250);
//		System.out.println(bt.diameter());
//		System.out.println(bt.diameter2());
//		System.out.println(bt.isTreeBalanced());
//		
//		BinaryTree bstTest = new BinaryTree(50, 25, 12, 10, -1, 20, -1, -1, 37, 30, 24, -1, 32, -1, -1,  40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1);
////		System.out.println(bstTest.isBST());
////		bstTest.largestBST();
////		int[] pre = {50, 25, 12,37, 30, 75, 62, 70};
//		int[] in = { 12, 25, 30, 37, 50, 60, 62, 70, 75, 87};
//		
//		int [] post = {12, 30, 37, 25, 60, 70, 62, 87, 75, 50};
////		BinaryTree bst2 = new BinaryTree(post, in, false);
//		bt.display();
//		System.out.println();
//		bt.preOrderIterative();
		binary(10);
	}

}
