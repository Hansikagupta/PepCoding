package Day3;
//COMPLICATED

public class PrintSubsetsOfArray {
	public static void main(String args[]) {
		// for arrSize <= 32
		int arr[] = { 1, 2, 3 };
		printSubset(arr);
	}

	private static void printSubset(int[] arr) {
		int mask = 1;
		printer(mask, arr.length - 1, arr);
	}

	private static void printer(int mask, int k, int[] arr) {
		if (k >= 0) {
			mask = setBit(mask, k);
			printer(mask, k - 1, arr);
			if (k == 0) {
				//System.out.print(Integer.toBinaryString(mask) + " ");
				System.out.print("{");
				for (int i = 0; i < arr.length; i++) {
					if (testBit(mask, i) != 0) {
						System.out.print(arr[i] + " ");
					}
				}
				System.out.print("},  ");
			}
			mask = resetBit(mask, k);
			printer(mask, k - 1, arr);
			if (k == 0) {
				//System.out.print(Integer.toBinaryString(mask) + " ");
				System.out.print("{");
				for (int i = 0; i < arr.length; i++) {
					if (testBit(mask, i) != 0) {
						System.out.print(arr[i] + " ");
					}
				}
				System.out.print("}, ");
			}

		}
	}

	private static int setBit(int i, int k) {
		int tempmask = 1;
		tempmask = tempmask << k;
		i = i | tempmask;
		return i;
	}

	private static int resetBit(int i, int k) {
		int tempmask = 1;
		tempmask = tempmask << k;
		tempmask = ~tempmask;
		i = i & tempmask;
		return i;
	}

	private static int testBit(int i, int k) {
		int tempmask = 1;
		tempmask = tempmask << k;
		i = i & tempmask;
		return i;

	}
	

}
