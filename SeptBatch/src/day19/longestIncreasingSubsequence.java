package day19;

public class longestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] sequence = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		int length = lis(sequence);
		System.out.println(length);
		lisWithPath(sequence);
	}
	
	//For Bitonic, find lds in a reverse loop(right to left)
	//In loop, find max of( Sum of lds+ lis -1)

	private static int lis(int[] sequence) {
		int[] lisEndingatI = new int[sequence.length];
		String ans = "";
		for (int end = 0; end < sequence.length; end++) {
			int max = Integer.MIN_VALUE;
			for (int smallerSubsequenceEnd = 0; smallerSubsequenceEnd <= end; smallerSubsequenceEnd++) {
				if (sequence[smallerSubsequenceEnd] <= sequence[end]) {

					max = Math.max(max, lisEndingatI[smallerSubsequenceEnd]);
				}
			}
			lisEndingatI[end] = max + 1;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < lisEndingatI.length; i++) {
			max = Math.max(max, lisEndingatI[i]);
		}
		// System.out.println(max);
		return max;

	}

	private static int lisWithPath(int[] sequence) {
		int[] lisEndingatI = new int[sequence.length];
		String[] path = new String[sequence.length];
		for (int end = 0; end < sequence.length; end++) {
			int max = Integer.MIN_VALUE;
			String temp = "";
			for (int smallerSubsequenceEnd = 0; smallerSubsequenceEnd <= end; smallerSubsequenceEnd++) {
				if (sequence[smallerSubsequenceEnd] <= sequence[end]) {
					if (lisEndingatI[smallerSubsequenceEnd] > max) {
						max = lisEndingatI[smallerSubsequenceEnd];
						temp = path[smallerSubsequenceEnd];
					}
				}
			}
			lisEndingatI[end] = max + 1;
			path[end] = temp + " " + sequence[end] == null ? "" : sequence[end]+"";
		}
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		for (int i = 0; i < lisEndingatI.length; i++) {
			if (lisEndingatI[i] > max) {
				maxIndex = i;
				max = lisEndingatI[i];
			}
		}
		// System.out.println(max);
		System.out.println(path[maxIndex]);
		return max;
	}
}
