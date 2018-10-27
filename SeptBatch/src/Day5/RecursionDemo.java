package Day5;

public class RecursionDemo {
	public static void main(String[] args) {
		// printIncreasing(5);
		// pyramid(3);
		toh("a", "b", "c", 3);

	}

	private static void printIncreasing(int n) {
		if (n == 0)
			return;
		printIncreasing(n - 1);
		System.out.println(n);
	}

	private static void pyramid(int n) {
		if (n == 0) {
			return;
		}
		System.out.print(n + " ");
		pyramid(n - 1);
		System.out.print(n + " ");

	}

	private static void toh(String s, String d, String h, int n) {
		if (n == 0)
			return;
		toh(s, h, d, n - 1);
		System.out.println(n + " from " + s + " to " + d);
		toh(h, d, s, n - 1);

	}

}
