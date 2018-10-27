package day13;

import java.util.Scanner;

public class crossword {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		char[][] board = new char[10][10];
		for (int i = 0; i < 10; i++) {
			board[i] = scn.nextLine().toCharArray();
		}
		String[] words = scn.nextLine().split(";");
		crossword(board, words, 0);
	}

	private static void crossword(char[][] board, String[] words, int wsf) {
		if (wsf == words.length) {
			printArr(board);
			return;
		}
		boolean reset[] = new boolean[words[wsf].length()];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] != '+' && canPlaceVertically(board, words[wsf], row, col)) {
					reset = placeVertically(board, words[wsf], row, col);
					crossword(board, words, wsf + 1);
					unplaceVertically(board, reset, row, col);
				}
				if (board[row][col] != '+' && canPlaceHorizontally(board, words[wsf], row, col)) {
					reset = placeHorizontally(board, words[wsf], row, col);
					crossword(board, words, wsf + 1);
					unplaceHorizontally(board, reset, row, col);
				}
			}
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
			if (col+i >= board.length || (board[row][col + i] != '-' && board[row][col + i] != word.charAt(i))) {
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
		if (row + word.length() < board.length) {		//endFit
			if (board[row + word.length()][col] != '+') {
				return false;
			}
		}
		if (row != 0) {			//startFit
			if (board[row - 1][col] != '+')
				return false;
		}
		for (int i = 0; i < word.length(); i++) {
			if (row+i== board.length || (board[row + i][col] != '-' && board[row + i][col] != word.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static void printArr(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
