package Day1;

public class SSsorting {
	public static void main(String[] args) {
		int[] arr = { 12, 20, 3, 10, 1, -4 };
		insertionSort(arr);
		display(arr);

	}

	private static void insertionSort(int[] arr) {
		for (int i = 1; i <= arr.length - 1; i++) {
			for(int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
				swap(arr, j, j-1);
			}
		}

	}

	private static void selectionSort(int[] arr) {
		for (int i = 1; i <= arr.length - 1/* because n-1 times */; i++) {
			for (int j = i; j < arr.length; /* everything compared to i-1 */ j++) {
				if (arr[i - 1] > arr[j]) {
					swap(arr, i - 1, j);
				}
			}
		}
	}

	private static void bubbleSort(int[] arr) {
		for (int i = 1; i <= arr.length - 1/* because n-1 times */; i++) {
			for (int j = 0; j < arr.length - i; /* because j+1 */ j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
