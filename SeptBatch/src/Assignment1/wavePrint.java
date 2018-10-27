package Assignment1;

import java.util.Scanner;

public class wavePrint {

	public static void main(String[] args) {
		int[][] mat;
		mat = getInput();
		wavePrint(mat);
	}

	private static int[][] getInput() {
		Scanner scn = new Scanner(System.in);
		int r = scn.nextInt();
		int c = scn.nextInt();
		int[][] mat = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++)
				mat[i][j] = scn.nextInt();
		}
		return mat;
	}

	private static void wavePrint(int mat[][]) {
		int j = 0;
		for (int i = 0; i < mat.length; i++) {
			if (i % 2 == 0)
				j = 0;
			else
				j = mat[0].length-1;
			for (; (j < mat[0].length) && (j >= 0);) {
				System.out.print(mat[i][j] + " ");
				if (i % 2 == 0)
					j++;
				else
					j--;
			}
		}
	}
}
