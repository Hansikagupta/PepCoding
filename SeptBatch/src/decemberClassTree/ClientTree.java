package decemberClassTree;

import java.awt.HeadlessException;

public class ClientTree {

	public static void main(String[] args) {
		int sarr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };
		GenericTree gt = new GenericTree(sarr);
		gt.display();
		System.out.println(gt.size2());
		System.out.println(gt.max());
		System.out.println(gt.height());
		System.out.println(gt.find(63));
		System.out.println(gt.nodeToRootPath(110));
//		gt.removeAllLeaves();
		System.out.println("===============");
//		gt.display();
		
//		gt.mirror();
//		gt.display();
		System.out.println("===============");

		
//		gt.linearize();
		gt.display();
		
		int sarr2[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };
		
//		GenericTree gt2 = new GenericTree(sarr2);
//		//gt2.mirror();
//		System.out.println(GenericTree.haveSimilarStructure(gt, gt2));
//		System.out.println(GenericTree.havemirrorStructure(gt, gt2));
////		gt.FloorCeil(7);
////		gt.preOrderpredSucc(10);
//		System.out.println("kth Largest = " + gt.kthLargest(1));
//
//		System.out.println("kth Largest = " + gt.kthLargest(3));
//		System.out.println("kth Largest = " + gt.kthLargest(4));
//		System.out.println("kth Largest = " + gt.kthLargest(12));
//		gt.levelO();
		System.out.println("=========================================================");


		gt.levelOLevelWiseDelimiter();
//		gt.levelOLineWise2LLZigZag();
		System.out.println("=================================");

		
		gt.levelOLineWise2LLZigZag();
		
	}

}
