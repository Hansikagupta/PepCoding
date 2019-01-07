package Day22;

import gs5_10_18.stock;

public class SparseTables {
	static int[] oarr;
	static int[][] sparseTable;
	static int[] logs;

	public static void main(String[] args) {
		oarr = new int[] { 1, 4, -9, 4, 6, 8, 1, 0 };
		build();
		System.out.println(query(2, 5));

	}

	private static int query(int l, int r) {
		int count = r - l + 1;
		//int log = getLog(count); // can be stored
		int log = logs[count];
		int ans = Math.min(sparseTable[l][log], sparseTable[r - (1 << log) + 1][log]);
		return ans;
	}

	private static void build() {
		int log = getLog(oarr.length);
		sparseTable = new int[oarr.length][log + 1];
		logs = new int[oarr.length];
		for(int i = 0; i < oarr.length; i++) {
			logs[i] = getLog(i);
		}

		for (int i = 0; i < sparseTable.length; i++) {
			sparseTable[i][0] = oarr[i];
		}
		for (int c = 1; c <= log; c++) {
			for (int r = 0; r < sparseTable.length - (1 << c); r++) {
				sparseTable[r][c] = Math.min(sparseTable[r][c - 1], sparseTable[r + (1 << (c - 1))][c - 1]);
			}
		}
	}

	private static int getLog(int n) {
		int log = 0;
		while ((1 << log) <= n) {
			log++;
		}
		return log - 1;
	}

}
