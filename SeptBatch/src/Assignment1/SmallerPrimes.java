package Assignment1;

import java.util.Scanner;

public class SmallerPrimes {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int num = 50;// scn.nextInt();
		for (int k = 2; k < num; k+= 2) {
			int i;
			for (i = 2; i * i <= k; i++) {
				if (k % i == 0) {
					break;
				}
			}
			if (i * i  < k) {
				continue;

			} else
				System.out.println(k + " ");
		}
	}

}
