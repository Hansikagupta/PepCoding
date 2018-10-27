package day2;
public class SSMazeRight {

	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		exitPoint(arr);

	}

	private static void exitPoint(int[][] arr) {
		int i = 0, j = 0, dir = 0;
		while (true) {
			while (j < arr[0].length && arr[i][j] != 1) {// ltor
				j++;
			}
			if (j == arr.length) {
				break;
			}
			i++;

			while (i < arr.length && arr[i][j] != 1) {// u to d
				i++;
			}
			if (i == arr.length) {
				break;
			}
			j--;

			while (j >= 0 && arr[i][j] != 1) {// rtol
				j--;
			}
			if (j == -1) {
				break;
			}
			i--;

			while (i >= 0 && arr[i][j] != 1) {// dtou
				i--;
			}
			if (i == -1) {
				break;
			}
			j++;
		}
		if (i == -1) {
			i++;
		}
		if (j == -1) {
			j++;
		}
		if (i == arr.length) {
			i--;
		}
		if (j == arr[0].length) {
			j--;
		}
		System.out.println(i + " " + j);

	}

	/*
	 * for(int i = 0; i < arr.length; i++) { for(int j = 0; j < arr[0].length||
	 * arr[i][j] != 1; j++) {
	 * 
	 * 
	 * }
	 * 
	 * }
	 */

	// private static void turnright(int[][]arr) {

}
