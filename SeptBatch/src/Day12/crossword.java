package Day12;

import java.util.Scanner;

public class crossword {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] board = new char[10][10];
		for (int i = 0; i < 10; i++) {
			board[i] = scn.nextLine().toCharArray();
		}
		String[] words = scn.nextLine().split(";");
		boolean[] wordsdone = new boolean[words.length];
		crossword(board, words, 1, wordsdone);
		
	}

	private static void crossword(char[][] board, String[] words, int bno, boolean[] wordsdone) {
		int row = (bno - 1) / board.length;
		int col = (bno - 1) % board.length;

		if (bno == board.length * board.length + 1) {
			printArr(board);
			return;
		}

		if (board[row][col] == '+') {
			crossword(board, words, bno + 1, wordsdone);
		} else {
			boolean flag = false;
			for (int i = 0; i < words.length; i++) {
				if (wordsdone[i] == false) {
					String word = words[i];
					boolean[] arr = new boolean[word.length()];
					// Horizontal
					if (canPlaceHorizontally(board, word, row, col)) {
						flag = true;
						//System.out.println(word + row + " " + col);
						arr = placeHorizontally(board, word, row, col);
						wordsdone[i] = true;
						crossword(board, words, bno + 1, wordsdone);
						unplaceHorizontally(board, arr, row, col);
						wordsdone[i] = false;						
					}

					// Vertical
					if (canPlaceVertically(board, word, row, col)) {
						flag = true;
						//System.out.println(word +" "+ row + " " + col);
						arr = placeVertically(board, word, row, col);
						wordsdone[i] = true;
						crossword(board, words, bno + 1, wordsdone);
						unplaceVertically(board, arr, row, col);
						wordsdone[i] = false;

					}
				}
			}
			if(flag == false && board[row][col] != '-' ) {
				crossword(board, words, bno+1, wordsdone);
			}
		}
	}

	private static void printArr(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void unplaceHorizontally(char[][] board, boolean[] reset, int row, int col) {
		for (int i = 0; i < reset.length; i++) {
			if (reset[i] == true)
				board[row][col + i] = '-';
		}
	}

	private static boolean[] placeHorizontally(char[][] board, String word, int row, int col) {

		boolean[] ret = new boolean[word.length()];
		for (int i = 0; i < word.length(); i++) {
			if (board[row][col + i] == '-') {
				ret[i] = true;
			}
			board[row][col + i] = word.charAt(i);
		}
		return ret;

	}

	private static boolean canPlaceHorizontally(char[][] board, String word, int row, int col) {
		if (col + word.length() < board.length)
			if (board[row][col + word.length()] != '+') {
				return false;
			}
		if (col != 0)
			if (board[row][col - 1] != '+')
				return false;
		for (int i = 0; i < word.length(); i++) {
			if (col + i >= board.length || (board[row][col + i] != '-' && board[row][col + i] != word.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static void unplaceVertically(char[][] board, boolean[] reset, int row, int col) {
		for (int i = 0; i < reset.length; i++) {
			if (reset[i] == true)
				board[row + i][col] = '-';
		}
	}

	private static boolean[] placeVertically(char[][] board, String word, int row, int col) {

		boolean[] ret = new boolean[word.length()];
		for (int i = 0; i < word.length(); i++) {
			if (board[row + i][col] == '-') {
				ret[i] = true;
			}
			board[row + i][col] = word.charAt(i);
		}
		return ret;

	}

	private static boolean canPlaceVertically(char[][] board, String word, int row, int col) {
		if (row + word.length() < board.length) { // endFit
			if (board[row + word.length()][col] != '+') {
				return false;
			}
		}
		if (row != 0) { // startFit
			if (board[row - 1][col] != '+')
				return false;
		}
		for (int i = 0; i < word.length(); i++) {
			if (row + i == board.length || (board[row + i][col] != '-' && board[row + i][col] != word.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
