package day24;

public class StockSpanClient {

	public static void main(String[] args) {
		int stockRate[] = { 10, 20, 50, 30 };
		display(stockSpans(stockRate));
	}

	public static int[] stockSpans(int[] stockRate) {
		stack mystk = new stack();
		int[] spans = new int[stockRate.length];

		for (int i = 0; i < stockRate.length; i++) {
			while (mystk.isEmpty() == false && stockRate[mystk.top()] < stockRate[i]) {
				mystk.pop();
			}
			if (mystk.isEmpty()) {
				spans[i] = i + 1;
			} else {
				spans[i] = i - mystk.top();
			}
			mystk.push(i);
		}
		return spans;

	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
