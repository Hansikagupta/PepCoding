package JanbinaryTree;

import java.util.ArrayList;
import java.util.Stack;

import javax.management.AttributeList;

public class BinaryTree {
	Node root;

	class Node {
		int data;
		Node left;
		Node right;
	}

	public BinaryTree(int... arr) {
		Stack<Node> stack = new Stack<>();
		for (int val : arr) {
			if (val == -1) {
				stack.pop();
			} else {
				Node node = new Node();
				node.data = val;
				node.left = node.right = null;
				if (stack.empty()) {
					root = node;
				} else if (stack.peek().left == null) {
					stack.peek().left = node;
				} else {
					stack.peek().right = node;
				}

				stack.push(node);
			}
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "<- " + node.data + " ->";
		String lstr = node.left == null ? ". " : node.left.data + " ";
		String rstr = node.right == null ? " ." : " " + node.right.data + "";

		System.out.println(lstr + str + rstr);
		display(node.left);
		display(node.right);
	}

	// NOTE : For recursion
	// Complete Euler Visit?
	// No Null pointer Exception
	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return 0;
			// -1 for Edge Height
		}
		return 1 + Integer.max(height(node.left), height(node.right));
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int maxChildVal = Integer.max(max(node.left), max(node.right));
		int max = node.data > maxChildVal ? node.data : maxChildVal;

		return max;
	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {
		if (node == root) {
			if (hasAnyChild(node) == false) {
				root = null;
				return;
			}
		}
		if (hasAnyChild(node.left) == false) {
			node.left = null;
		} else
			removeLeaves(node.left);

		if (hasAnyChild(node.right) == false) {
			node.right = null;
		} else
			removeLeaves(node.right);
	}

	private boolean hasAnyChild(Node node) {
		if (node == null) {
			return false;
		} else if (node.left == null && node.right == null) {
			return false;
		}
		return true;
	}

	public void noSibling() {
		noSibling(root);
	}

	private void noSibling(Node node) {
		if (node.left != null) {
			if (node.right == null) {
				System.out.println(node.left.data);
			}
			noSibling(node.left);
		}
		if (node.right != null) {
			if (node.left == null) {
				System.out.println(node.right.data);
			}
			noSibling(node.right);
		}
	}

	public boolean find(int key) {
		return find(root, key);
	}

	private boolean find(Node node, int key) {
		if (node == null) {
			return false;
		}
		if (node.data == key) {
			return true;
		} else {
			boolean lAns, rAns;
			lAns = find(node.left, key);
			if (lAns == true) {
				return true;
			} else {
				rAns = find(node.right, key);
				return rAns;
			}
		}
	}

	public ArrayList<Integer> nodeToRootPath(int key) {
		return nodeToRootPath(root, key);
	}

	private ArrayList<Integer> nodeToRootPath(Node node, int key) {
		if (node == null) {
			return new ArrayList<>();
		}
		if (node.data == key) {
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(node.data);
			return ans;
		} else {
			ArrayList<Integer> childAns = new ArrayList<>();
			childAns = nodeToRootPath(node.left, key);
			if (childAns.isEmpty() == false) {
				childAns.add(node.data);
				return childAns;
			} else {
				childAns = nodeToRootPath(node.right, key);
				if (childAns.isEmpty() == false) {
					childAns.add(node.data);
				}
			}
			return childAns;
		}
	}

	private ArrayList<Node> nodeToRootPath2(Node node, int key) {
		if (node == null) {
			return new ArrayList<>();
		}
		if (node.data == key) {
			ArrayList<Node> ans = new ArrayList<>();
			ans.add(node);
			return ans;
		} else {
			ArrayList<Node> childAns = new ArrayList<>();
			childAns = nodeToRootPath2(node.left, key);
			if (childAns.isEmpty() == false) {
				childAns.add(node);
				return childAns;
			} else {
				childAns = nodeToRootPath2(node.right, key);
				if (childAns.isEmpty() == false) {
					childAns.add(node);
				}
			}
			return childAns;
		}
	}

	private void kDown(Node node, int k) {
		if (k == 0) {
			System.out.println(node.data);
			return;
		}
		if (node.left != null) {
			kDown(node.left, k - 1);
		}
		if (node.right != null) {
			kDown(node.right, k - 1);
		}
	}

	private void kDownControlled(Node node, Node controlled, int k) {
		if (node == controlled) {
			return;
		}
		if (k == 0) {
			System.out.println(node.data);
			return;
		}
		if (node.left != null) {
			kDown(node.left, k - 1);
		}
		if (node.right != null) {
			kDown(node.right, k - 1);
		}
	}

	public void kAway(int data, int k) {
		kAway(data, null, k);
	}

	private void kAway(int data, Node controller, int k) {
		ArrayList<Node> path = nodeToRootPath2(root, data);
		for (int i = 0; i <= k && i < path.size(); i++) {
			kDownControlled(path.get(i), ((i == 0) ? null : path.get(i - 1)), k - i);
		}

	}

	class heapMover {
		Integer height;
		Integer size;
		Integer max;
	}

	public void printPathToLeafInRange(int lo, int hi) {
		printPathToLeafInRange(root, 0, lo, hi, "");
	}

//if you use ArrayList in this, O(n) but then remember to remove while returning
	// Numbers can be negative too.
	private void printPathToLeafInRange(Node node, int sumSoFar, int lo, int hi, String asf) {
		sumSoFar = sumSoFar + node.data;
		if (sumSoFar > hi || node == null) {
			return;
		}
		if (sumSoFar > lo && sumSoFar < hi && hasAnyChild(node) == false) {
			System.out.println(asf + " " + node.data);
		}
		if (sumSoFar < hi && hasAnyChild(node)) {
			printPathToLeafInRange(node.left, sumSoFar, lo, hi, asf + " " + node.data);
			printPathToLeafInRange(node.right, sumSoFar, lo, hi, asf + " " + node.data);
		}
	}

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int myDia = height(node.left) + height(node.right) + 1;
		return Math.max(myDia, Math.max(diameter(node.left), diameter(node.right)));
	}

	class DiaHeight {
		int htOfSubtree;
		int Dia;
	}

	public int diameter2() {
		return diameter2(root).Dia;

	}

	private DiaHeight diameter2(Node node) {
		DiaHeight dh = new DiaHeight();
		DiaHeight dhofLeft = new DiaHeight();
		DiaHeight dhofRight = new DiaHeight();

		if (node == null) {
			dh.htOfSubtree = 0;
			dh.Dia = 0;
			return dh;
		}
		dhofLeft = diameter2(node.left);
		dhofRight = diameter2(node.right);
		dh.htOfSubtree = Math.max(dhofLeft.htOfSubtree, dhofRight.htOfSubtree) + 1;
		int myDia = dhofLeft.htOfSubtree + dhofRight.htOfSubtree + 1;
		dh.Dia = Math.max(myDia, Math.max(dhofLeft.Dia, dhofRight.Dia));
		return dh;

	}

	class isBal {
		int ht;
		boolean isSubtreeBal;
	}

	public boolean isTreeBalanced() {
		return isTreeBalanced(root).isSubtreeBal;
	}

	class isBSTPair {
		int maxVal = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;
		boolean isBST;

		int maxSize;
		Node largestBSTRoot;
	}

	private isBal isTreeBalanced(Node node) {
		isBal myVal = new isBal();
		if (hasAnyChild(node) == false) { // or node == null
			myVal.ht = 0;
			myVal.isSubtreeBal = true;
			return myVal;
		}
		isBal leftVal = isTreeBalanced(node.left);
		isBal rightVal = isTreeBalanced(node.right);

		myVal.ht = Math.max(leftVal.ht, rightVal.ht) + 1;

		int htDiff = leftVal.ht - rightVal.ht;
		if (htDiff <= 1 && htDiff >= -1) {
			myVal.isSubtreeBal = leftVal.isSubtreeBal && rightVal.isSubtreeBal;
		} else
			myVal.isSubtreeBal = false;
		return myVal;

	}

	public boolean isBST() {
		return isBst(root).isBST;
	}

	private isBSTPair isBst(Node node) {
		isBSTPair myVAl, rightVal, leftVal;
		myVAl = new isBSTPair();
		if (hasAnyChild(node) == false) {
			myVAl.isBST = true;
			myVAl.maxVal = node.data;
			myVAl.minVal = node.data;
			return myVAl;
		}
		leftVal = isBst(node.left);
		rightVal = isBst(node.right);
		if (leftVal.isBST && rightVal.isBST) {
			if (leftVal.maxVal < node.data && node.data < rightVal.minVal) {
				myVAl.isBST = true;
			} else
				myVAl.isBST = false;
		} else
			myVAl.isBST = false;

		myVAl.maxVal = rightVal.maxVal;
		myVAl.minVal = leftVal.minVal;
		return myVAl;
	}

	public void largestBST() {
		isBSTPair ans;
		ans = largestBST(root);
		System.out.println(ans.largestBSTRoot.data);
		System.out.println(ans.maxSize);
	}

	private isBSTPair largestBST(Node node) {
		isBSTPair leftVal, rightVal, myVal;
		myVal = new isBSTPair();

		if (hasAnyChild(node) == false) {
			myVal.isBST = true;
			myVal.maxVal = node.data;
			myVal.minVal = node.data;
			return myVal;
		}

		leftVal = largestBST(node.left);
		rightVal = largestBST(node.right);
		// myVal Cal
		if (leftVal.isBST == true && rightVal.isBST == true) {
			if (leftVal.maxVal < node.data && node.data < rightVal.minVal) {
				myVal.isBST = true;
				myVal.largestBSTRoot = node;
				myVal.maxSize = leftVal.maxSize + rightVal.maxSize + 1;
			}
		} else {
			if (leftVal.maxSize > rightVal.maxSize) {
				myVal.maxSize = leftVal.maxSize;
				myVal.largestBSTRoot = leftVal.largestBSTRoot;
			} else {
				myVal.maxSize = rightVal.maxSize;
				myVal.largestBSTRoot = rightVal.largestBSTRoot;
			}
		}
		myVal.maxVal = rightVal.maxVal;
		myVal.minVal = leftVal.minVal;
		return myVal;
	}

	public BinaryTree(int[] pre, int[] in) {
		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int prelow, int prehi, int[] in, int inlow, int inhigh) {
		if (prehi < prelow) {
			return new Node();
		}

		Node node = new Node();
		node.data = pre[prelow];

		int inNode = index(in, pre[prelow], inlow, inhigh);
		int countOfleftChildren = inNode - inlow;
		int newPreHighLeft = prelow + countOfleftChildren;// index(pre, newinHighLeft, prelow, prehi);
		node.left = construct(pre, prelow + 1, newPreHighLeft, in, inlow, inNode - 1);

		int newpreLowRight = newPreHighLeft + 1;
		node.right = construct(pre, newpreLowRight, prehi, in, inNode + 1, inhigh);

		return node;
	}

	private int index(int[] in, int key, int low, int high) {
		for (int i = low; i <= high; i++) {
			if (key == in[i]) {
				return i;
			}
		}
		return -1;
	}

	public BinaryTree(int[] post, int[] in, boolean postDummy) {
		root = construct(post, 0, post.length - 1, in, 0, in.length - 1, false);
	}

	private Node construct(int[] post, int postLow, int postHigh, int[] in, int inLow, int inHigh, boolean postDummy) {
		if (postHigh < postLow) {
			return null;
		}

		Node node = new Node();
		node.data = post[postHigh];

		int inNode = index(in, post[postHigh], inLow, inHigh);
		int countOfleftChildren = inHigh - inNode;
		node.left = construct(post, postLow, postHigh - countOfleftChildren - 1, in, inLow, inNode - 1, false);

		node.right = construct(post, postHigh - countOfleftChildren, postHigh - 1, in, inNode + 1, inHigh, false);
		return node;
	}

	class PairPO {
		int counter = 0;
		Node node;
	}

	public void preOrderIterative() {
		Stack<PairPO> stack = new Stack<>();
		PairPO rootp = new PairPO();
		rootp.node = root;
		stack.push(rootp);
		while (stack.size() > 0) {
			PairPO top = stack.peek();
			if (top.counter == 0) {
				System.out.println(top.node.data);
			}
			else if (top.counter == 1) {
				if (top.node.left != null) {
					PairPO leftPair = new PairPO();
					leftPair.node = top.node.left;
					stack.push(leftPair);
				}
			}
			else if (top.counter == 2) {
				if (top.node.right != null) {
					PairPO rightPair = new PairPO();
					rightPair.node = top.node.right;
					stack.push(rightPair);
				}
			} else {
				stack.pop();
			}
			top.counter++;
		}
	}
	

}
