package day15;

import java.util.Arrays;

public class dp1 {
	public static void main(String[] args) {
		//soeratosthenesPrimess(10, 30);
//		String word = "aabbabccddbbbzzzzzzzzzz";
//		highestFreqChar(word);
//		int[] arr = {2, 3, 9, 6, 5, 2, 5, 8, 3, 9};
//		all22uni(arr);
//		char a = '\0';
//		System.out.println((int)a);
		int[] arr = {2, 2,3, 9, 6, 6, -5, 3, 9, 6, -5, -0, 2, -5, 8, 8, 8,3, 9};

		allthrice1unique(arr);
	}
	
	private static void allthrice1unique(int[] arr) {
		int ans = 0;
		
		for(int i = 0; i <= 31; i++) {
			int count = 0;

			int bm = 1;
			bm = bm<<i;
			for(int val:arr) {
				if((val&bm) == bm) {
					count++;
				}
			}
			if(count%3 == 1) {
				ans|=bm;
			}
			
		}
		System.out.println(ans);
		
	}

	private static void all22uni(int[] arr) {
		int allxor = 0;
		for(int i = 0; i < arr.length; i++ ) {
			allxor ^= arr[i];
		}
		int lsbon = allxor & -allxor;
		int x = 0, y = 0;
		for(int i = 0; i < arr.length; i++) {
			if((lsbon & arr[i]) == 0) {
				x^= arr[i];
			}
			else {
				y^= arr[i];
			}
		}
		System.out.println(x + " " + y);
		
	}

	private static void highestFreqChar(String word) {
		
		int max = 0;
		char maxChar = ' ';
		int[] arr = new int[26];
		for(int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			arr[index] += 1;
			if(arr[index] > max) {
				max = arr[index];
				maxChar = word.charAt(i);
			}
		}
		System.out.println(max);
		System.out.println(maxChar);		
	}

	private static void soeratosthenesPrimes(int start, int end) {
		boolean[] prime = new boolean[end - start +1];

		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; i * i < end; i++) {
			if (prime[i] == true) {
				for (int j = start/i; j * i < end; j++) {
					prime[i * j] = false;
				}
			}
		}
		printArray(start, prime);

	}

	private static void soeratosthenes(int end) {
		boolean[] prime = new boolean[end];

		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; i * i < end; i++) {
			if (prime[i] == true) {
				for (int j = i; j * i < end; j++) {
					prime[i * j] = false;
				}
			}
		}
		printArray(prime);

	}

	private static void printArray(int start, boolean[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == true) {
				System.out.print(i + start + " ");
			}
		}
	}

}
