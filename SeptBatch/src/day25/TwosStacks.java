package day25;
public class TwosStacks {
	private int t1 = -1, t2;
	private int[] arr;

	TwosStacks(int cap) {
		arr = new int[cap];
		t2 = arr.length;
	}

	void push1(int val) {
		if (!isFull()) {
			t1++;
			arr[t1] = val;
		} else
			System.out.println("Full stack");
	}

	boolean isFull() {
		if (t1 + 1 == t2) {
			return true;
		}
		return false;
	}

	void push2(int val) {
		if (t1 + 1 < t2) {
			t2--;
			arr[t2] = val;
		} else
			System.out.println("Full stack");
	}

	int pop1() {
		if (isEmpty1() == false) {
			int val = arr[t1];
			arr[t1] = 0;
			t1--;
			System.out.println(val);

			return val;

		}
		System.out.println("Empty");
		return -1;
	}

	int pop2() {
		if (isEmpty2() == false) {
			int val = arr[t2];
			arr[t2] = 0;
			t2++;
			System.out.println(val);

			return val;

		}
		System.out.println("Empty");
		return -1;
	}

	int top2() {
		if (isEmpty2() == false) {
			int val = arr[t2];
			System.out.println(val);

			return val;

		}
		System.out.println("Empty");
		return -1;
	}

	int top1() {
		if (isEmpty1() == false) {
			int val = arr[t1];
			System.out.println(val);

			return val;

		}
		System.out.println("Empty");
		return -1;
	}
	private boolean isEmpty1() {
		if (t1 == -1)
			return true;
		return false;
	}

	private boolean isEmpty2() {
		if (t1 == arr.length)
			return true;
		return false;
	}

	public void display() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
