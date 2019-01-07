package day17;

public class dp3 {

	public static void main(String[] args) {
//		int[][] arr = { { 5, 1, 3, 2, 3 }, { 4, 4, 0, 0, 6 }, { 6, 4, 1, 1, 2 }, { 4, 0, 1, 7, 2 }, { 5, 1, 0, 0, 3 } };
//		goldMineWithPath(arr);

//		int[] arr = { 1, 2, 3, 4, 5 };
//		int targetSum = 10;
//		targetSum(targetSum, arr);

//		int[] weights = { 2, 5, 1, 3, 4 };
//		int[] profits = { 15, 14, 10, 45, 30 };
//		int capacity = 7;
//		//knapSack(weights, profits, capacity);
//		System.out.println(knapsackRec(weights, profits, 0, capacity, new int[weights.length+1][capacity+1]));
//
//		String s = "abccbc";
//		System.out.println(countPalindromes(s));

//		String s = "abccbc";
//		System.out.println(minCutsMemo(s, 0, s.length()-1, new int[s.length()][s.length()]));

		int dims[] = { 10, 20, 30, 40, 50, 60 };
		int cost = minCostMatMem(dims, 0, dims.length - 1, new int[dims.length][dims.length]);
		System.out.println(cost);
	}

	private static int minCostMatMem(int[] dims, int i, int j, int[][] qb) {
		if (i + 1 == j) {
			return 0;
		}
		if(qb[i][j] != 0) {
			return qb[i][j];
		}
		int min = Integer.MAX_VALUE;
		for (int c = i; c < j - 1; c++) {
			int lc = minCostMatMem(dims, i, c + 1, qb);
			int rc = minCostMatMem(dims, c + 1, j, qb);
			int tc = lc + rc + dims[i] * dims[c + 1] * dims[j];
			min = Math.min(tc, min);
		}
		qb[i][j] = min;
		return min;
	}

	private static int minCutsMemo(String s, int i, int j, int[][] qb) {
		boolean[][] isPalin = new boolean[s.length()][s.length()];
		isPalin = isPalindromeforSubString(s);
		if (isPalin[i][j] == true) {
			return 0;
		}
		if (qb[i][j] != 0)
			return qb[i][j];
		int min = Integer.MAX_VALUE;
		for (int cut = i; cut < j; cut++) {
			int lc = minCutsMemo(s, i, cut, qb);
			int rc = minCutsMemo(s, cut + 1, j, qb);
			int tc = lc + rc + 1;
			min = Math.min(tc, min);
		}
		qb[i][j] = min;
		return min;
	}

	private static boolean[][] isPalindromeforSubString(String s) {
		boolean[][] storage = new boolean[s.length()][s.length()];
		for (int gap = 0; gap < storage.length; gap++) {
			for (int row = 0, j = gap + row; j < storage[0].length; row++, j++) {
				if (gap == 0) {
					storage[row][j] = true;

				} else if (gap == 1 && s.charAt(row) == s.charAt(j)) {
					storage[row][j] = true;

				} else if (s.charAt(row) == s.charAt(j)) {
					if (storage[row + 1][j - 1] == true) {
						storage[row][j] = true;
					}
				}
			}
		}
		return storage;
	}

	private static int countPalindromes(String s) {

		boolean[][] storage = new boolean[s.length()][s.length()];
		int count = 0;

		for (int gap = 0; gap < storage.length; gap++) {
			for (int row = 0, j = gap + row; j < storage[0].length; row++, j++) {
				if (gap == 0) {
					storage[row][j] = true;
					count++;
				} else if (gap == 1 && s.charAt(row) == s.charAt(j)) {
					storage[row][j] = true;
					count++;

				} else if (s.charAt(row) == s.charAt(j)) {
					if (storage[row + 1][j - 1] == true) {
						storage[row][j] = true;
						count++;
					}
				}
			}
		}
//		int count = 0;
//		for (int i = 0; i < storage.length; i++) {
//			for (int j = 0; j < storage[0].length; j++) {
//				if (storage[i][j] == true) {
//					count++;
//				}
//			}
//		}

		return count;

	}

	private static int knapsackRec(int[] weights, int[] profits, int itemNo, int rc, int[][] qb) {
		if (itemNo == weights.length) {
			return 0;
		}
		if (qb[itemNo][rc] != 0) {
			return qb[itemNo][rc];
		}
		int ans = 0;
		ans = knapsackRec(weights, profits, itemNo + 1, rc, qb);
		if (weights[itemNo] <= rc) {
			int max;
			max = knapsackRec(weights, profits, itemNo + 1, rc - weights[itemNo], qb) + profits[itemNo];
			if (max > ans)
				ans = max;

		}
		qb[itemNo][rc] = ans;
		return ans;
	}

	private static void knapSack(int[] weights, int[] profits, int capacity) {
		int[][] storage = new int[weights.length + 1][capacity + 1];

		for (int r = 0; r < storage.length; r++) {
			for (int c = 0; c < storage[0].length; c++) {
				if (r == 0 || c == 0) {
					storage[r][c] = 0;
				} else {
					if (c >= weights[r - 1]) {// THINK
						if (storage[r - 1][c - weights[r - 1]] + profits[r - 1] > storage[r - 1][c]) {
							storage[r][c] = storage[r - 1][c - weights[r - 1]] + profits[r - 1];
						} else
							storage[r][c] = storage[r - 1][c];
					} else
						storage[r][c] = storage[r - 1][c];
				}
			}
		}
		System.out.println("Max Profit is = " + storage[storage.length - 1][storage[0].length - 1]);
		printKnapSackPath(storage, weights, profits, storage.length - 1, storage[0].length - 1, "");
	}

	private static void printKnapSackPath(int[][] storage, int[] weights, int[] profits, int r, int c, String asf) {
		if (r == 0) {
			System.out.println(asf);
			return;
		}
		if (c >= weights[r - 1]) {
			int max = 0;
			max = max(storage[r - 1][c - weights[r - 1]] + profits[r - 1], storage[r - 1][c]);
			if (storage[r - 1][c - weights[r - 1]] + profits[r - 1] == max) {
				printKnapSackPath(storage, weights, profits, r - 1, c - weights[r - 1], asf + " " + weights[r - 1]);
			}
			if (storage[r - 1][c] == max) {
				printKnapSackPath(storage, weights, profits, r - 1, c, asf);
			}
		} else
			printKnapSackPath(storage, weights, profits, r - 1, c, asf);

	}

	private static int max(int... vals) {
		int max = vals[0];
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] > max)
				max = vals[i];
		}
		return max;
	}

	private static void goldMineWithPath(int[][] mine) {
		int[][] arr = new int[mine.length][mine[0].length];
		for (int c = mine[0].length - 1; c >= 0; c--) {
			for (int r = mine.length - 1; r >= 0; r--) {
				if (c == arr.length - 1)
					arr[r][c] = mine[r][c];
				else {
					if ((r < arr.length - 1) && (r > 0))
						arr[r][c] = Math.max(arr[r][c + 1], Math.max(arr[r - 1][c + 1], arr[r + 1][c + 1]))
								+ mine[r][c];
					else if (r < arr.length - 1)
						arr[r][c] = Math.max(arr[r][c + 1], arr[r + 1][c + 1]) + mine[r][c];
					else if (r > 0)
						arr[r][c] = Math.max(arr[r][c + 1], arr[r - 1][c + 1]) + mine[r][c];

				}
			}
		}
		int max = 0;
		for (int r = 0; r < arr.length; r++) {
			max = Math.max(arr[r][0], max);
		}
		System.out.println(max);
		for (int r = 0; r < arr.length; r++) {
			if (arr[r][0] == max) {
				System.out.println(r);
				printPaths(arr, r, 0);
			}
		}
	}

	private static void printPaths(int[][] arr, int rno, int col) {
		if (col == arr[0].length)
			return;
		int max;
		if (rno == arr.length - 1) {
			max = max(arr[rno][col + 1], arr[rno - 1][col + 1]);
			if (arr[rno][col + 1] == max) {
				System.out.println("R");
				printPaths(arr, rno, col + 1);
			}
			if (arr[rno - 1][col + 1] == max) {
				System.out.println("U");
				printPaths(arr, rno - 1, col + 1);
			}
		} else if (rno == 0) {
			max = max(arr[rno][col + 1], arr[rno + 1][col + 1]);

			if (arr[rno][col + 1] == max) {
				System.out.println("R");
				printPaths(arr, rno, col + 1);
			}
			if (arr[rno + 1][col + 1] == max) {
				System.out.println("D");
				printPaths(arr, rno + 1, col + 1);
			}
		}

		else {
			max = max(arr[rno][col + 1], arr[rno + 1][col + 1], arr[rno - 1][col + 1]);

			if (arr[rno][col + 1] == max) {
				System.out.println("R");
				printPaths(arr, rno, col + 1);
			}
			if (arr[rno + 1][col + 1] == max) {
				System.out.println("D");
				printPaths(arr, rno + 1, col + 1);
			}
			if (arr[rno - 1][col + 1] == max) {
				System.out.println("U");
				printPaths(arr, rno - 1, col + 1);
			}
		}

	}

	private static void targetSum(int targetSum, int[] arr) {
		boolean[][] strg = new boolean[arr.length + 1][targetSum + 1];
		for (int r = 0; r < strg.length; r++) {
			for (int c = 0; c < strg[0].length; c++) {
				if (c == 0) {
					strg[r][c] = true;
				} else if (r == 0) {
					strg[r][c] = false;
				}

				else {
					if ((strg[r - 1][c] == true) || ((c - arr[r - 1] >= 0) && (strg[r - 1][c - arr[r - 1]] == true))) {
						strg[r][c] = true;
					}
				}
			}

		}
		if (strg[strg.length - 1][strg[0].length - 1] == true) {
			System.out.println("true");
			targetSumPath(strg, arr, strg.length - 1, strg[0].length - 1, "");
		}
	}

	private static void targetSumPath(boolean[][] strg, int[] arr, int row, int col, String asf) {
		if (row == 0) {
			System.out.println(asf);
			return;
		}

		if (strg[row - 1][col] == true) {
			targetSumPath(strg, arr, row - 1, col, asf);
		}
		if (col - arr[row - 1] >= 0 && strg[row - 1][col - arr[row - 1]] == true) {
			targetSumPath(strg, arr, row - 1, col - arr[row - 1], asf + " " + arr[row - 1]);

		}
	}
}
