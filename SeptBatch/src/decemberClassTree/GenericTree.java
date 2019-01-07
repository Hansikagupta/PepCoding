package decemberClassTree;

import java.util.*;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private int size;
	private Node root;

	public GenericTree(int[] sarr) {
		Stack<Node> stk = new Stack<>();

		for (int i = 0; i < sarr.length; i++) {

			int val = sarr[i];
			if (val != -1) {
				Node node = new Node();
				node.data = val;

				if (size == 0) {
					root = node;
				} else {
					stk.peek().children.add(node);
				}
				size++;
				stk.push(node);
			} else {
				stk.pop();
			}
		}
	}

	public void display() {
		display(root);
	}

	public void display(Node node) {
		String str = new String();
		str = "" + node.data + " -> ";
		for (Node val : node.children) {
			str += val.data + ", ";
		}
		System.out.println(str);

		for (Node val : node.children) {
			display(val);
		}
	}

	public int size2() {
		return (size2(root));
	}

	private int size2(Node node) {
		int size = 1;
		for (Node val : node.children) {
			size += size2(val);
		}
		return size;
	}

	public int max() {
		return (max(root));
	}

	private int max(Node node) {
		int max = node.data;
		for (Node val : node.children) {
			max = Math.max(max(val), max);
		}
		return max;
	}

	public int height() {
		return (height(root));
	}

	private int height(Node node) {
		int height = 1;
		int mheight = 0;
		for (Node val : node.children) {
			mheight = Math.max(height(val), mheight);
		}

		return height + mheight;
	}

	public boolean find(int data) {
		return (find(root, data));
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}
		boolean retVal = false;
		for (Node val : node.children) {
			retVal = retVal || find(val, data);
		}

		return retVal;
	}

	public ArrayList<Integer> nodeToRootPath(int data) {
		return (nodeToRootPath(root, data));
	}

	private ArrayList<Integer> nodeToRootPath(Node node, int data) {

		if (node.data == data) {
			ArrayList<Integer> path = new ArrayList<>();
			path.add(node.data);
			return path;
		}
		ArrayList<Integer> myPath = new ArrayList<>();

		for (Node val : node.children) {
			myPath = nodeToRootPath(val, data);
			if (myPath.size() != 0) {
				myPath.add(node.data);
				return myPath;
			}
		}

		return myPath;
	}

	public void mirror() {
		mirror(root);
	}

	public void mirror(Node node) {

		for (int i = 0; i < node.children.size(); i++) {
			Node val = node.children.get(i);
			mirror(val);
		}
		ReverseArrList(node.children);

	}

	private void ReverseArrList(ArrayList<Node> children) {
		int left = 0;
		int right = children.size() - 1;

		for (; right > left; left++, right--) {
			Node lChildNode = children.get(left);
			Node rChildNode = children.get(right);
			children.set(left, rChildNode);
			children.set(right, lChildNode);
		}
	}

	public void removeAllLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node val = node.children.get(i);
			if (val.children.size() != 0)
				removeLeaves(val);
			else {
				node.children.remove(val);
				size--;
			}
		}
	}

	public void linearizeN2() {
		linearize(root);
	}

	public void linearizeN2(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node val = node.children.get(i);
			linearize(val);
		}
		Node lastVal = node.children.get(node.children.size() - 1);

		for (int i = node.children.size() - 2; i >= 0; i--) {
			Node val = node.children.get(i);
			Node tailofVal = getTail(val);
			tailofVal.children.add(lastVal);
			node.children.remove(lastVal);
			size--;
			lastVal = val;
		}
		return;
	}

	private Node getTail(Node node) {
		for (Node child : node.children)

			return null;
	}

	public void linearize() {
		linearize(root);
	}

	public Node linearize(Node node) {
		if (node.children.size() == 0) {
			return node;
		}

		Node retTail = linearize(node.children.get(node.children.size() - 1));
		Node lastVal = node.children.get(node.children.size() - 1);

		for (int i = node.children.size() - 2; i >= 0; i--) {
			Node val = node.children.get(i);
			Node tailofVal = linearize(val);
			tailofVal.children.add(lastVal);
			node.children.remove(i + 1);
			size--;
			lastVal = val;
		}
		return retTail;
	}

	public static boolean haveSimilarStructure(GenericTree gt1, GenericTree gt2) {
		return haveSimilarStructure(gt1.root, gt2.root);
	}

	private static boolean haveSimilarStructure(Node node1, Node node2) {
		if (node1.children.size() != node2.children.size()) {
			return false;
		} else {
			boolean prevAns = true;
			for (int i = 0; i < node1.children.size(); i++) {
				Node newNode1 = node1.children.get(i);
				Node newNode2 = node2.children.get(i);
				prevAns = prevAns && haveSimilarStructure(newNode1, newNode2);
			}
			return prevAns;

		}
	}

	public static boolean havemirrorStructure2(GenericTree gt1, GenericTree gt2) {
		gt1.mirror();
		boolean ans = haveSimilarStructure(gt1, gt2);
		gt1.mirror();
		return ans;
	}

	public static boolean havemirrorStructure(GenericTree gt1, GenericTree gt2) {
		return havemirrorStructure(gt1.root, gt2.root);
	}

	private static boolean havemirrorStructure(Node node1, Node node2) {
		if (node1.children.size() == node2.children.size() && node1.children.size() == 0) {
			return true;
		}
		if (node1.children.size() != node2.children.size()) {
			return false;
		} else {
			boolean prevAns = true;
			for (int i = 0; i < node1.children.size(); i++) {
				Node newNode1 = node1.children.get(i);
				Node newNode2 = node2.children.get(node2.children.size() - 1 - i);
				prevAns = prevAns && havemirrorStructure(newNode1, newNode2);
			}
			return prevAns;

		}
	}

	public boolean isFoldableOrSymmetric() {
		return havemirrorStructure(this, this);
	}

//	Integer floor, ceil;

	public int FloorCeil(int data) {
		floor = null;
		ceil = null;
		FloorCeil2(root, data);
//		System.out.println("floor = " + floor);
//		System.out.println("ceil = " + ceil);
		return floor;
	}

	static class HeapMover {
		Integer floor, ceil;

		Integer pred;
		boolean nodeFound;
		Integer succ;

		Integer curr;
		Integer prev;
	}

	private void FloorCeil2(Node node, int data) {
		HeapMover mover = new HeapMover();
		for (Node val : node.children) {
			FloorCeil2(val, data);
		}
		if (data < node.data && (mover.ceil == null || node.data < mover.ceil)) {
			mover.ceil = node.data;
		}
		if (data > node.data && (mover.floor == null || node.data > mover.floor)) {
			mover.floor = node.data;
		}
	}

	public int kthLargest(int k) {
		int largest = FloorCeil(Integer.MAX_VALUE);
		for (int i = 1; i < k; i++) {
			largest = FloorCeil(largest);
		}
		return largest;
	}

//	public int kthLargestPrivate(int k) {
//		FloorCeil2(root, Integer.MAX_VALUE);
//		int largest = 
//		for (int i = 1; i < k; i++) {
//			largest = FloorCeil2(root, largest);
//		}
//		return largest;
//	}

	public void preOrderpredSucc(int data) {
		HeapMover mover = new HeapMover();

		preOrderpredSucc2(root, data, mover);
		System.out.println("pred = " + mover.pred);
		System.out.println("succ = " + mover.succ);
	}

	private void preOrderpredSucc2(Node node, int data, HeapMover mover) {
		mover.prev = mover.curr;
		mover.curr = node.data;

		if (mover.curr == data) {
			mover.pred = mover.prev;
		} else if (mover.prev != null && mover.prev == data) {
			mover.succ = mover.curr;
		}
		for (Node val : node.children) {
			if (mover.succ != null)
				return;
			preOrderpredSucc2(val, data, mover);
		}

	}

	private void preOrderpredSucc(Node node, int data, HeapMover mover) {

		if (node.data != data && mover.nodeFound == false) {
			mover.pred = node.data;
		} else if (node.data != data && (mover.succ == null)) {
			mover.succ = node.data;
		} else {
			mover.nodeFound = true;
		}
		for (Node val : node.children) {
			if (mover.succ != null)
				return;
			preOrderpredSucc(val, data, mover);
		}

	}

	public void levelO() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (queue.size() > 0) {
			Node removed = queue.removeFirst();
			System.out.print(removed.data + " ");
			for (Node child : removed.children) {
				queue.addLast(child);
			}
		}
		System.out.println(".");

	}

	public void levelOLevelWiseDelimiter() {
		Node blank = new Node();
		blank.data = -1;
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		queue.addLast(blank);

		while (queue.size() > 0) {
//			System.out.print(", ");
			Node removed = queue.removeFirst();
			if (removed.data == -1) {
				System.out.println(" ");
				if (queue.size() > 0)
					queue.addLast(blank);

			} else {
				System.out.print(removed.data + " ");
				for (Node child : removed.children) {
					queue.addLast(child);
				}

			}
		}
		System.out.println(".");
	}

	public void levelOLineWise2LL() {

		LinkedList<Node> curr = new LinkedList<>();
		LinkedList<Node> next = new LinkedList<>();
		curr.addLast(root);
		while (curr.size() > 0) {

			Node removed = curr.removeFirst();
			System.out.print(removed.data + " ");
			for (Node child : removed.children) {
				next.addLast(child);
			}

			if (curr.size() == 0) {
				curr = next;
				next = new LinkedList<>();
				System.out.println();
			}
		}
		System.out.println(".");
	}

	public void levelOLineWise2LLZigZag() {

		LinkedList<Node> curr = new LinkedList<>();
		LinkedList<Node> next = new LinkedList<>();
		curr.addLast(root);
		while (curr.size() > 0) {

			Node removed = curr.removeFirst();
			System.out.print(removed.data + " ");
			for (Node child : removed.children) {
				next.addFirst(child);
			}

			if (curr.size() == 0) {
				System.out.println();

				while (next.size() > 0) {
					Node removed1 = next.removeFirst();
					System.out.print(removed1.data + " ");
					for (int i = removed1.children.size() - 1; i >= 0; i--) {
						Node val = removed1.children.get(i);
						curr.addFirst(val);
					}
				}
				System.out.println();
			}
		}
		System.out.println(".");
	}
}
