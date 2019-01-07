package day2;

public class SSRotateMatrix {
	// public class rotateMatrix {
	public static void main(String[] args) {
		int[][] mat = { { 0, 1, 2 }, { 3, 4, 5 }, { 4, 8, 9 } };
		display(mat);
		System.out.println();
		rotate90(mat);
		display(mat);
	}

	private static void rotate90(int[][] mat) {
		transpose(mat);
		reverseRows(mat);

	}

	private static void transpose(int[][] mat) {
		for (int i = 0; i < mat.length / 2; i++) {
			for (int j = i; j < mat[i].length; j++) {
				swap(mat, i, j);
			}
		}
	}

	public static void swap(int[][] arr, int index1, int index2) {
		int temp;
		temp = arr[index1][index2];
		arr[index1][index2] = arr[index2][index1];
		arr[index2][index1] = temp;
	}

	public static void reverseRows(int[][] mat) {
		for (int i = 0; i < mat.length / 2; i++) {
			reverse(mat[i]);
		}
	}

	public static void reverse(int[] arr) {

		for (int i = 0; i < arr.length / 2; i++) {
			swap2(arr, i, arr.length - 1 - i);
		}
	}

	public static void swap2(int[] arr, int index1, int index2) {
		int temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
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
