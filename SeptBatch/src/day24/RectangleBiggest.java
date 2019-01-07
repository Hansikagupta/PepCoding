package day24;

public class RectangleBiggest {

	public static void main(String[] args) {
		int rate[] = { 5, 2, 5, 4, 5, 1, 6 };
		System.out.println(rectArea(rate));
	}

	public static int rectArea(int[] rate) {
		stack lstack = new stack(rate.length);
		stack rstack = new stack(rate.length);

		int[] leftArea = new int[rate.length];
		int[] rightArea = new int[rate.length];

		for (int i = 0; i < rate.length; i++) {
			while (lstack.isEmpty() == false && rate[lstack.top()] > rate[i]) {
				lstack.pop();
			}
			if (lstack.isEmpty()) {
				leftArea[i] = -1;
			} else {
				leftArea[i] =  lstack.top();
			}
			lstack.push(i);
		}

		for (int i = rate.length - 1; i >= 0; i--) {
			while (rstack.isEmpty() == false && rate[rstack.top()] > rate[i]) {
				rstack.pop();
			}
			if (rstack.isEmpty()) {
				rightArea[i] = rate.length;
			} else {
				rightArea[i] = rstack.top();
			}
			rstack.push(i);
		}
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < leftArea.length; i++) {
			if ((rightArea[i] - leftArea[i] - 1) * rate[i] > maxArea) {
				maxArea = (rightArea[i] - leftArea[i] - 1) * rate[i];
			}
		}
		return maxArea;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
