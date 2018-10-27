package Day1;

import java.util.Scanner;

public class GCD {
	//LongDivision

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//int num1 = scn.nextInt();
		//int num2 = scn.nextInt();
		int num1 = 164, num2 = 12;
		int rem = num1%num2;

		while(rem > 0) {
			num1 = num2;
			num2 = rem;
			rem = num1%num2;
		}
		System.out.println("gcd = "+ num2);
	}

}
