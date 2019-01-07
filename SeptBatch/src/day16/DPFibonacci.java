package day16;

public class DPFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int n = 10;
//		System.out.println(fibmem(n, new int[n+1]));
//		System.out.println(fibTab(n, new int[n+1]));

//		int[][] arr = { { 1, 0, 2, 0, 3, 0 }, { 5, 10, 8, 7, 0, 6 }, { 3, 0, 1, 1, 2, 0 }, { 4, 4, 7, 0, 0, 6 },
//				{ 3, 9, 11, 2, 1, 3 }, { 8, 0, 4, 4, 6, 9 }, { 1, 0, 0, 9, 6, 2 }
//
//		};
//
		int[][] arr = { { 2, 5, 0, 8, 7 }, { 3, 6, 0, 3, 2 }, { 0, 4, 7, 7, 9 }, { 1, 8, 0, 0, 10 }, { 5, 3, 2, 0, 0 }

		};

		long start = System.currentTimeMillis();
		//System.out.println(countBoardPathTab(0, 10, new int[11]));
		goldMine(arr);
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

	private static int fibmem(int n, int[] qb) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (qb[n] != 0) {
			return qb[n];
		}

		else {
			int fn;
			fn = fibmem(n - 1, qb) + fibmem(n - 2, qb);
			qb[n] = fn;
			return fn;

		}
	}

	private static int fibTab(int n, int[] qb) {
		qb[0] = 0;
		qb[1] = 1;
		for (int i = 2; i <= n; i++) {
			qb[i] = qb[i - 1] + qb[i - 2];
		}
		return qb[n];

	}

	private static int countBoardPath(int s, int d, int[] arr) {
		if (s == d) {
			return 1;
		}
		if (arr[s] != 0)
			return arr[s];

		int maxDiceMove = (d - s > 6) ? 6 : (d - s);
		int pathSum = 0;
		int paths;
		for (int i = 1; i <= maxDiceMove; i++) {
			paths = countBoardPath(s + i, d, arr);
			pathSum += paths;
		}
		arr[s] = pathSum;
		return pathSum;
	}

	private static void matPathTab(int size) {

		int[][] mat = new int[size][size];
		mat[size - 1][size - 1] = 1;

		for (int r = size - 1; r >= 0; r--) {
			for (int c = size - 1; c >= 0; c--) {
				if (r == size - 1 && c == size - 1)
					continue;
				int right = 0, down = 0;
				if (c < size - 1)
					right = mat[r][c + 1];
				if (r < size - 1)
					down = mat[r + 1][c];
				mat[r][c] = right + down;
			}
		}
		System.out.println(mat[0][0]);
	}

	private static void goldMine(int[][] mine) {
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
		for (int r = 0; r < mine.length; r++) {
			max = Math.max(arr[r][0], max);
		}
		System.out.println(max);

	}

	private static void minCostBoardTravel(int[][] costArr) {

		int[][] minCostArr = new int[costArr.length][costArr[0].length];

		for (int r = costArr.length - 1; r >= 0; r--) {
			for (int c = costArr[0].length - 1; c >= 0; c--) {

				if (r == costArr.length - 1 && c == costArr[0].length - 1) {
					minCostArr[r][c] = costArr[r][c];
				} else if (r == costArr.length - 1) {
					minCostArr[r][c] = costArr[r][c] + minCostArr[r][c + 1];
				} else if (c == costArr[0].length - 1) {
					minCostArr[r][c] = costArr[r][c] + minCostArr[r + 1][c];
				} else {

					minCostArr[r][c] = costArr[r][c] + Math.min(minCostArr[r + 1][c], minCostArr[r][c + 1]);
				}
			}
		}
		System.out.println(minCostArr[0][0]);

	}

	private static int countBoardPathTab(int s, int d, int[] arr) {// Pending

		arr[d] = 1;

		for (int q = d-1; q >= 0; q--) {
			int maxDiceMove = (d - q > 6) ? 6 : (d - q);
			int pathSum = 0;
			for (int dice = 1; dice <= maxDiceMove; dice++) {
				pathSum += arr[q + dice];
			}
			arr[q] = pathSum;
		}
		return arr[0];
	}
}
