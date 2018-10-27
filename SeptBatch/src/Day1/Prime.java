package Day1;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int num = scn.nextInt();
		int i = 2;
		while (i * i <= num) {
			if (num % i == 0) {
				System.out.println("not Prime");
				return;
			}
			i++;
		}
		System.out.println("Prime");
	}
}
