package decemberClass1LL;

public class SSLL {

	private class Node {
		int data;
		Node next;
	}

	int size;
	Node head;
	Node tail;

	public void addLastNode(int data) {
		if (this.size == 0) {
			handle0SizeException(data);
			return;
		}
		Node temp = new Node();
		temp.data = data;
		temp.next = null;

		this.tail.next = temp;

		this.tail = temp;
		size++;
	}

	private void handle0SizeException(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.next = null;

		this.head = temp;
		this.tail = temp;
		size++;

	}

	public void display() {
		for (Node temp = head; temp != null; temp = temp.next) {
			System.out.print(temp.data + " -> ");
		}
		System.out.println(". ");
	}

	public void addfirstNode(int data) {
		if (this.size == 0) {
			handle0SizeException(data);
			return;
		}
		Node temp = new Node();
		temp.data = data;
		temp.next = this.head;

		this.head = temp;
		size++;
	}

	public int getfirst() throws Exception {
		// System.out.println(this.head.data);
		if (size == 0) {
			throw new Exception(" No Element present");
		}
		return this.head.data;

	}

	public int getlast() throws Exception {
		if (size == 0) {
			throw new Exception(" No Element present");
		}
		// System.out.println(this.tail.data);
		return this.tail.data;

	}

	public int getat(int n) throws Exception {

		if (n < 1 || n > size) {
			throw new Exception("index out of bound");
		}
		Node temp = this.head;
		int i = 1;
		for (; temp != null && i < n; temp = temp.next, i++) {
			// System.out.print(temp.data + " -> ");
		}

		// System.out.println(temp.data);
		return temp.data;
	}

	public Node getNodeat(int n) throws Exception {
		if (n < 1 || n > size) {
			throw new Exception("index out of bound");
		}
		Node temp = this.head;
		int i = 1;
		for (; temp != null && i < n; temp = temp.next, i++) {
			// System.out.print(temp.data + " -> ");
		}
		return temp;
	}

	public Node retLast() {
		// System.out.println(this.head.data);
		return this.tail;

	}

	public Node retfirst() {
		// System.out.println(this.head.data);
		return this.head;

	}

	public void remfirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("No element");
		}
		if (this.size == 1) {
			this.tail = null;
		}
		Node temp = getNodeat(1);
		this.head = temp.next;
		size--;
	}

	public int remlast() throws Exception {
		if (this.size == 0) {
			throw new Exception("No element");
		}
		if (this.size == 1) {
			int retVal = this.head.data;

			this.head = null;
			this.tail = null;
			size--;
			return retVal;
		}
		int newLast = this.size - 1;
		Node temp = getNodeat(newLast);
		int retVal = temp.next.data;

		temp.next = null;
		size--;
		return retVal;

	}

	public int remat(int n) throws Exception {
		if (n == size) {

			return remlast();
		}

		if (n == 1) {

			return remfirst();
		}

		// int newLast = this.size -1;
		Node temp = getNodeat(n - 1);
		int retVal = temp.next.data;
		temp.next = temp.next.next;
		size--;
		return retVal;
	}

	public void addAt(int n, int data) throws Exception {
		if (n == 1) {
			addfirstNode(data);
			return;
		}
		if (n == size) {
			addLastNode(data);
			return;
		}

		Node newNode = new Node();

		// initialize
		newNode.data = data;
		newNode.next = null;
		Node temp = getNodeat(n - 1);

		if (n < size) {
			newNode.next = temp.next;
		}

		temp.next = newNode;
		size++;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void ReversePointerIterativeLL() {
		if (size >= 2) {
			Node left = this.head;
			Node middle = this.head.next;
			while (middle != null) {
				Node right = middle.next;

				middle.next = left;

				left = middle;
				middle = right;
			}
			Node temp = tail;
			tail = head;
			head = temp;
			tail.next = null;
		}
	}

	public void ReverseDataIterativeLL() throws Exception {

		int leftNodeNo = 1;
		int rightNodeNo = this.size;

		while (rightNodeNo > leftNodeNo) {
			Node rightNode = getNodeat(rightNodeNo);
			Node leftNode = getNodeat(leftNodeNo);

			int temp = leftNode.data;
			leftNode.data = rightNode.data;
			rightNode.data = temp;
			leftNodeNo++;
			rightNodeNo--;
		}

	}

	public void displayRevRec() {
		dprr(head);
	}

	private void dprr(Node node) {
		if (node == null) {
			return;
		}
		dprr(node.next);
		System.out.print(node.data + "-> ");
	}

	public void reversePointerRecursive() {
		rpr(head);
		Node temp = tail;
		tail = head;
		head = temp;
		tail.next = null;

	}

	private void rpr(Node node) {
		if (node == tail) {
			return;
		}
		rpr(node.next);
		node.next.next = node;
	}

	public void reverseDataRec() {
		leftNoderdr = head;

		rdr(head, 1);

	}

	static Node leftNoderdr;

	private void rdr(Node curNode, int no) {
		if (curNode == null) {
			return;
		}

		rdr(curNode.next, no + 1);
		if (no > size / 2) {
			int tempdata = curNode.data;
			curNode.data = leftNoderdr.data;
			leftNoderdr.data = tempdata;
			leftNoderdr = leftNoderdr.next;
		}
	}

	static Node isPalinLeft;

	public boolean isPalindrome() {
		isPalinLeft = head;
		return isPalin(head);
	}

	private boolean isPalin(Node right) {
		if (right == null) {
			return true;
		}
		if (isPalin(right.next)) {
			if (isPalinLeft.data == right.data) {
				isPalinLeft = isPalinLeft.next;
				return true;
			}
		}
		isPalinLeft = isPalinLeft.next;
		return false;
	}

	static Node foldLeft;

	public void fold() {
		foldLeft = head;
		fold(head, 0);
	}

	private void fold(Node last, int count) {
		if (last == null) {
			return;
		}
		fold(last.next, count + 1);
		if (count > size / 2) {
			last.next = foldLeft.next;
			foldLeft.next = last;
			foldLeft = foldLeft.next.next;
		} else if (count == size / 2) {
			tail = last;
			tail.next = null;
		}

	}

	public int kfromLast(int k) {
		Node rnode = head;
		Node lnode = head;
		int count = 1;
		while (rnode != null && count <= k) {
			rnode = rnode.next;
			count++;
		}
		while (rnode != null) {
			rnode = rnode.next;
			lnode = lnode.next;
		}
		return lnode.data;
	}

	public int mid() {
		Node node1 = head;
		Node node2 = head;
		while (node2.next != null && node2.next.next != null) {
			node1 = node1.next;
			node2 = node2.next.next;
		}
		return node1.data;
	}

	public Node midNode() {
		Node node1 = head;
		Node node2 = head;
		while (node2.next != null && node2.next.next != null) {
			node1 = node1.next;
			node2 = node2.next.next;
		}
		return node1;
	}

	public static SSLL mergeTwoLL(SSLL one, SSLL two) {
		SSLL merged = new SSLL();
		Node inode = one.head;
		Node jnode = two.head;
		while (inode != null && jnode != null) {
			if (inode.data < jnode.data) {
				merged.addLastNode(inode.data);
				inode = inode.next;
			} else {
				merged.addLastNode(jnode.data);
				jnode = jnode.next;
			}

		}
		while (inode != null) {
			merged.addLastNode(inode.data);
			inode = inode.next;
		}
		while (jnode != null) {
			merged.addLastNode(jnode.data);
			jnode = jnode.next;
		}
		return merged;
	}

	public static SSLL mergeSortLL(SSLL one) {
		if (one.size >= 2) {
			Node mid = one.midNode();
			SSLL two = one.breakInTwo(mid);

			return mergeTwoLL(mergeSortLL(one), mergeSortLL(two));
		} else
			return one;

	}

	private SSLL breakInTwo(Node mid) {
		SSLL two = new SSLL();
		two.head = mid.next;
		two.tail = this.tail;

		this.tail = mid;
		this.tail.next = null;

		two.size = size / 2;
		this.size = (size + 1) / 2;

		return two;
	}

	public static SSLL mergeSortLL2(SSLL one) {
		if (one.head != one.tail) {
			Node mid = one.midNode();
			SSLL two = one.breakInTwo(mid);
			SSLL mergedSortedList = mergeTwoLL(mergeSortLL2(one), mergeSortLL2(two));
			join(one, two);

			return mergedSortedList;
		} else
			return one;
	}

	public static SSLL mergeSort(SSLL list) {
		return mergeSort(list, list.head, list.tail);
	}

	public static SSLL mergeSort(SSLL list, Node low, Node high) {
		if (low == high) {
			SSLL newList = new SSLL();
			newList.addLastNode(low.data);
			return newList;
		}

		Node mid = list.midNode(low, high);
		SSLL fh = mergeSort(list, low, mid);
		SSLL sh = mergeSort(list, mid.next, high);

		return mergeTwoLL(fh, sh);

	}

	private Node midNode(Node low, Node high) {
		Node node1 = low;// slow
		Node node2 = low;// fast
		while (node2.next != high.next && node2.next.next != high.next) {
			node1 = node1.next;
			node2 = node2.next.next;
		}
		return node1;
	}

	private static void join(SSLL one, SSLL two) {
		one.tail.next = two.head;
		one.tail = two.tail;

	}

	public void kRev(int k) {
		SSLL curList = new SSLL();
		SSLL prevList = null;
		while (this.size > 0) {
			for (int i = 0; i < k && this.size > 0; i++) {
				curList.addfirstN(this.remfirstN());
			}
			if (prevList == null) {
				prevList = curList;
			} else {
				prevList.size += curList.size;
				prevList.tail.next = curList.head;
				prevList.tail = curList.tail;
			}
			curList = new SSLL();
		}

		this.head = prevList.head;
		this.tail = prevList.tail;
		this.size = prevList.size;
	}

	private void addfirstN(Node node) {
		if (this.size == 0) {
			head = tail = node;
			size++;
			return;
		}
		node.next = this.head;
		this.head = node;
		size++;
	}

	private Node remfirstN() {
		if (this.size == 0) {
			handle0SizeException(0);
		}
		if (this.size == 1) {
			Node node = this.head;
			head = tail = null;
			size--;
			return node;
		}
		Node node = this.head;
		this.head = head.next;
		size--;
		node.next = null;
		return node;
	}

//	private void remDuplicate(int k) {
//		for(int i = 0; i < )
//	}
//
//	private void evenOdd() {
//		SSLL evenList = new SSLL();
//		SSLL oddList = new SSLL();;
//		for (int i = 0;  this.size > 0; i++) {
//			
//		}
//		evenList.tail.next = oddList.head;
//	}

}
