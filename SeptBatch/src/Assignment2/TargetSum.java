package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class TargetSum {

	public static void main(String[] args) {
		int size = 0;
		Scanner scn;
		scn = new Scanner(System.in);
		size = scn.nextInt();
		int [][] arr1 = new int[size][2];
		for (int i = 0; i < size; i++) {
			arr1[i][0] = scn.nextInt();
			arr1[i][1] = scn.nextInt();
		}
		int arr2[] = {1, 4, 5}; 
		int sum = 0;
		System.out.println(targetSum(arr2, sum));
		
		System.out.println(checkOnLine(arr1));	
 	}
	
	private static ArrayList<String> targetSum(int[] arr, int sum) {
		if()
	}
	
	private static boolean checkOnLine(int[][] arr) {
		if(a) {
			
		}
	}

}
