package Day1;

import java.util.Scanner;

public class arraybasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter size ");
		Scanner scn = new Scanner(System.in);
		int []arr = {1 , 4 , 100 , 900};
/*		int size = scn.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scn.nextInt();
		}
*/
		int max = findMax(arr);
		System.out.println("Maximum number in array is " + max);

		System.out.println("Reverse of array is ");
		printArr(findRev(arr));

		System.out.println("");
		System.out.println("Enter key ");
		int key = scn.nextInt();
		linearSearch(arr, key);
		System.out.println("Binary Search ");

		binarySearchCaller(arr, key);
	}

	public static int findMax(int[] arr) {
		int max;
		max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static int[] findRev(int[] arr) {

		for (int i = 0; i < arr.length / 2; i++) {
			swap(arr, i, arr.length - 1 - i);
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
			System.out.println(arr[i] + " ");
		}
	}

	public static void linearSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				System.out.println("Key found at index " + (i + 1));
				return;
			}
		}
		System.out.print("Key not found ");
	}

	public static int binarySearch(int[] arr, int low, int high, int key) {
		if (high > low) {
			int mid = (high + low) / 2;
			if (key == arr[mid]) 
				return mid;
			else if (key < mid)
				return binarySearch(arr, low, mid, key);
			else if (key > mid)
				return binarySearch(arr, mid, high, key);
			
		}
			return -1;

	}

	public static void binarySearchCaller(int[] arr, int key) {
		int result = binarySearch(arr, 0, arr.length - 1, key);
		if (result != -1) {
			System.out.println("Key found at index " + result);
		} else
			System.out.println("Key not found ");

	}
}