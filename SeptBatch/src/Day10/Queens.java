package Day10;

public class Queens {

	public static void main(String[] args) {
		// boolean[] boxes = new boolean[4];
		boolean[][] board = new boolean[3][3];

		// printCombinations2(boxes, 2, 0, 0, "");
		// printCombinations(boxes, 2, 0, -1, "");
		// nQueen(board, 5, 0, 1, "");
		// nKnights(board, 0, 1, "");
		printLexicographic(0, 1000, 0);

	}

//	{
//	0000
//	0001
//	0010
//	0100
//	1000
//	0101
//	0102
//	
//	
//	}
	static char[] alphabet = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	private static void printLexicographic(int start, int end, int prevNo) {
		if (start > end) {
			return;
		}
		int newNo = prevNo;
		for(int i = 0; i < alphabet.length; i++) {
			newNo = prevNo* 10 + i;
			printLexicographic(start, end, prevNo);
		}

		

		System.out.println(newNo);

	}

	static int count = 0;

	private static void nKnights(boolean[][] board, int k, int cellNo, String asf) {
		if (k == board.length) {
			if (isBoardValidKnight(board)) {
				count++;
				System.out.println(asf + " " + count);
			}
			return;
		}
		if (cellNo == board.length * board.length + 1) {
			return;
		}
		int row = (cellNo - 1) / board.length;
		int col = (cellNo - 1) % board.length;
		nKnights(board, k, cellNo + 1, asf);
		if (board[row][col] == false) {
			board[row][col] = true;
			nKnights(board, k + 1, cellNo + 1, asf + cellNo + " ");
			board[row][col] = false;
		}
		return;

	}

	private static boolean isBoardValidKnight(boolean[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == true) {
					if (isKnightSafe(board, i, j)) {
						continue;
					} else
						return false;
				}
			}

		}
		return true;
	}

	private static boolean isKnightSafe(boolean[][] board, int i, int j) {
		int row = i, col = j;
		int[][] dirs = { { -1, -2 }, { -2, -1 }, { 2, -1 }, { 1, -2 }, { 1, 2 }, { 2, 1 }, { -1, 2 }, { -2, 1 } };
//		for (int rad = 1; rad < board.length; rad++) {
		for (int[] dir : dirs) {
			row = i + dir[0];
			col = j + dir[1];

			if (row < board.length && row >= 0 && col < board.length && col >= 0 && board[row][col] == true) {
				return false;
			}
		}
		// }
		return true;
	}

	public static void printCombinations(boolean[] boxes, int totalQueens, int q, int pqb, String asf) {
		if (q == totalQueens) {
			System.out.println(asf);
			return;
		}

		for (int i = pqb + 1; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				printCombinations(boxes, totalQueens, q + 1, i, asf + "q " + q + " b" + i);
				boxes[i] = false;
			}
		}
	}

	public static void printCombinations2(boolean[] boxes, int totalQueens, int q, int cb, String asf) {
		if (q == totalQueens) {
			System.out.println(asf);
			return;
		}
		if (cb == boxes.length) {
			return;
		}
		printCombinations2(boxes, totalQueens, q, cb + 1, asf);
		if (boxes[cb] == false) {
			boxes[cb] = true;
			printCombinations2(boxes, totalQueens, q + 1, cb + 1, asf + "q" + q + "b" + cb + " ");
			boxes[cb] = false;
		}
	}

	private static void nQueen(boolean[][] board, int totalQueens, int q, int cellNo, String asf) {
		if (q == totalQueens) {
			// if (isBoardValid(board)) {
			System.out.println(asf);
			// }
			return;
		}
		if (cellNo == board.length * board.length + 1) {
			return;
		}
		int row = (cellNo - 1) / board.length;
		int col = (cellNo - 1) % board.length;
		nQueen(board, totalQueens, q, cellNo + 1, asf);
		if (board[row][col] == false) {
			if (isQueenSafe(board, row, col)) {
				board[row][col] = true;
				nQueen(board, totalQueens, q + 1, cellNo + 1, asf + cellNo + " ");
				board[row][col] = false;
			}
		}
		return;

	}

	private static boolean isBoardValid(boolean[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == true) {
					if (isQueenSafe(board, i, j)) {
						continue;
					} else
						return false;
				}
			}

		}
		return true;
	}

	private static boolean isQueenSafe(boolean[][] board, int i, int j) {
		// HerColCheck //Vertical
		for (int row = 0; row < board.length; row++) {
			if (row == i) {
				continue;
			}
			if (board[row][j] == true) {
				return false;
			}
		}
		// Horizontal
		for (int col = 0; col < board.length; col++) {
			if (col == j) {
				continue;
			}
			if (board[i][col] == true) {
				return false;
			}
		}

		// Diag1 NW to SE
		for (int row = i, col = j; row < board.length && col < board.length; row++, col++) {
			if (board[row][col] == true && row != i && col != j) {
				return false;
			}
		}
		for (int row = i, col = j; row < board.length && col >= 0; row++, col--) {
			if (board[row][col] == true && row != i && col != j) {
				return false;
			}
		}
		for (int row = i, col = j; row >= 0 && col < board.length; row--, col++) {
			if (board[row][col] == true && row != i && col != j) {
				return false;
			}
		}
		for (int row = i, col = j; row >= 0 && col >= 0; row--, col--) {
			if (board[row][col] == true && row != i && col != j) {
				return false;
			}
		}
		return true;
	}
}
