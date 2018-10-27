package day2;

public class SSMatrixMultiplication {
	
	public static void main(String[] args) {
		int[][] mat1 = { { 0, 1, 2 }, { 3, 4, 5 }, { 4, 8, 9 } };
		int[][] mat2 = { { 4, 1, 2 }, { 3, 1, 5 }, { 4, 1, 9 } };
		multiply(mat1, mat2);
		

	}

	private static void multiply(int[][] mat1, int[][] mat2) {
		int r1 = mat1.length;
		int r2 = mat2.length;
		int c1 = mat1[0].length;
		int c2 = mat2[0].length;
		int sum = 0;
		int[][] mul = new int[r1][c2];
		if (c1 != r2) {
			System.out.println("Error in Input");
		} else {
			for (int i = 0; i < r1; i++) {
				for (int j = 0; j < c2; j++) {
					for (int k = 0; k < r2; k++) {
						mul[i][j] += mat1[i][k] * mat2[k][j];
					}
				}
				
			}
		}
		display(mul);
	}

	private static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
