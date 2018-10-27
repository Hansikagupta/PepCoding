package day13;

public class SSmergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr1 = { 10, 20, 30, 40, 50 };
//		int[] arr2 = { 11, 15, 22, 27, 37, 57, 67 };
		int[] ans;// = merge(arr1, arr2);
		int arr[] = { 6, 32, 7, 43, 8 };
		ans = mergeSort(arr, 0, arr.length - 1);
		printArr(ans);

	}

	private static void printArr(int[] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.print(board[i] + " ");
		}
	}

	private static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] ans = { arr[lo] };
			return ans;

		} else {
			int mid = (lo + hi) / 2;
			int[] fhalf = mergeSort(arr, lo, mid);
			int[] shalf = mergeSort(arr, mid + 1, hi);
			int[] ans = merge(fhalf, shalf);
			return ans;
		}

	}

	private static int[] merge(int[] one, int[] two) {
		int i = 0, j = 0, k = 0;
		int[] ans = new int[one.length + two.length];
		for (; i < one.length && j < two.length; k++) {
			if (one[i] < two[j]) {
				ans[k] = one[i];
				i++;
			} else {
				ans[k] = two[j];
				j++;
			}
		}
		for (; j < two.length; j++, k++) {
			ans[k] = two[j];
		}
		for (; i < one.length; i++, k++) {
			ans[k] = one[i];
		}
		return ans;
	}

}
