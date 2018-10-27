package Day1;
//Inverse, Rotate, Reverse
public class Arr_Rotate_Invert_Reverse {

	public static void main(String[] args) {
		// int arr[] = {0,1,2,3,4,5,6,7,8};
		// rotate(arr,5);
		// printArr(arr);
		int arr[] = { 4, 2, 0, 3, 1 };
		inverse(arr);
		printArr(arr);
	}

	private static void inverse(int[] arr) {
		int size = arr.length;
		int[] newArr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			newArr[arr[i]] = i;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = newArr[i];
		}
	}

	private static void rotate(int[] arr, int index) {
		reverse(arr, 0, index + 1);
		reverse(arr, index + 1, arr.length);
		reverse(arr, 0, arr.length);
	}

	public static int[] reverse(int[] arr, int low, int high) {

		for (int i = low; i < (high + low) / 2; i++) {
			swap(arr, i, high - 1 - i + low);
		}
		return arr;
	}

	public static void swap(int[] arr, int index1, int index2) {
		int temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
