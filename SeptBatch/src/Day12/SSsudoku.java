package Day12;

public class SSsudoku {
	public static void main(String[] args) {
		int[][] arr = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },

				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 8, 0 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },

				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 }, };

		int[] rows = new int[9];
		int[] cols = new int[9];
		int[][] subMat = new int[3][3];
		preProcess(arr, rows, cols, subMat);
		sudoku(arr, 1, rows, cols, subMat);
	}

	private static void sudoku(int[][] board, int cellNo, int[] rows, int[] cols, int[][] subMat) {
		
		if (cellNo == 82) {
			printArr(board);
			return;
		}
		
		int row = (cellNo - 1) / board.length;
		int col = (cellNo - 1) % board.length;
		if (board[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isBoxSafe(rows, cols, subMat, row, col, i)) {
					board[row][col] = i;
					setBit(row, col, i, rows, cols, subMat);
					sudoku(board, cellNo + 1, rows, cols, subMat);
					board[row][col] = 0;
					resetBit(row, col, i, rows, cols, subMat);
				}
			}
		} else
			sudoku(board, cellNo + 1, rows, cols, subMat);
	}

	private static void setBit(int row, int col, int num, int[] rows, int[] cols, int[][] subMat) {
		rows[row] = setBit(rows[row], num);
		cols[col] = setBit(cols[col], num);
		subMat[row / 3][col / 3] = setBit(subMat[row / 3][col / 3], num);
	}

	private static void resetBit(int row, int col, int num, int[] rows, int[] cols, int[][] subMat) {
		rows[row] = resetBit(rows[row], num);
		cols[col] = resetBit(cols[col], num);
		subMat[row / 3][col / 3] = resetBit(subMat[row / 3][col / 3], num);
	}

	private static boolean isBoxSafe(int[] rows, int[] cols, int[][] subMat, int row, int col, int i) {
		if (testBit(rows[row], i) == false && testBit(cols[col], i) == false
				&& testBit(subMat[row / 3][col / 3], i) == false) {
			return true;
		}
		return false;
	}

	private static void preProcess(int[][] board, int[] rows, int[] cols, int[][] subMat) {
		// ROWS
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 0) {
					setBit(i, j, board[i][j], rows, cols, subMat);
				}
			}

		}
	}

	private static int setBit(int i, int k) {
		int mask = 1;
		mask = mask << k;
		i = i | mask;
		return i;
	}

	private static int resetBit(int i, int k) {
		int mask = 1;
		mask = mask << k;
		mask = ~mask;
		i = i & mask;
		return i;
	}

	private static boolean testBit(int i, int k) {
		int mask = 1;
		mask = mask << k;
		i = i & mask;
		if (i != 0) {
			return true;
		} else
			return false;

	}

	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

//Rough

//private static int findSubMat(int row, int col) {
//int subMatIndex = (row / 3) * 3 + col / 3;
//
//}

//private static int toggleBit(int i, int k) {
//int mask = 1;
//mask = mask << k;
//i = i ^ mask;
//
//return i;
//}