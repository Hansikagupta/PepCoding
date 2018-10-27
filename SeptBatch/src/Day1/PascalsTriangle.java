package Day1;

public class PascalsTriangle {
	public static void main(String[] args) {
		int num = 5;
		int val = 1;
		int prevVal = 1;
		// n = row no(0 to n-1), k = col no - 1
		for (int row = 0; row < num; row++) {
			val = 1;
			for (int k = 0; k <= row; k++) {
				System.out.print(val+" ");
				val = (val * (row - k)) /( k + 1);
			}
			System.out.println();
		}
	}

}
