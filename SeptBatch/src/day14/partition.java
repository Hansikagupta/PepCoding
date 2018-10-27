package day14;

public class partition {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 11, 99, 1, 7, 11 };
//		partitioning(arr, 11);
//		printArr(arr);
//		int[] arr = { 0, 1, 2, 2, 1, 0, 0, 1, 2, 1};
//		sort012(arr);
//		printArr(arr);
//		quickSort(arr, 0, arr.length - 1);
//		printArr(arr);
		getPolyVal(2, 3);

	}
	private static int getPolyVal (int x, int n) {
		int sum = 0;
		int co = n;
		int px = x;
		for(int i = 1; i <= n; i++) {	
			sum = sum + co*px;
			co--;
			px*=x;
		}
		System.out.println(sum);
		return sum;
		
	}

	private static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return;
		int pivot = arr[hi];
		int pivotLoc = partitioning(arr, pivot, lo, hi);
		swap(arr, pivotLoc, hi);
		quickSort(arr, lo, pivotLoc - 1);
		quickSort(arr, pivotLoc + 1, hi);

	}

	private static void printArr(int[] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.print(board[i] + " ");
		}
	}

	private static int partitioning(int[] arr, int pivot, int lo, int hi) {
		int p = lo;
		for (int i = lo; i < hi; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, p);
				p++;
			}
		}
		// System.out.println(p);
		return p;
	}

	private static void swap(int[] arr, int i, int p) {
		int temp = arr[p];
		arr[p] = arr[i];
		arr[i] = temp;
	} // 0, 1, 2, 2, 1, 0, 0, 1, 2, 1}

	private static void sort012(int[] arr) {
		int ze = 0, start2 = arr.length - 1;
		for (int i = 0; i <= start2; i++) {
			while (arr[i] == 2) {
				swap(arr, i, start2);
				start2--;
			}
			if (arr[i] == 0) {
				swap(arr, ze, i);
				ze++;
			}
		}
	}

}
