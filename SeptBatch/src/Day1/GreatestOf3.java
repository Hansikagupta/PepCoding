package Day1;

import java.util.Scanner;

public class GreatestOf3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int p = scn.nextInt();
		int q = scn.nextInt();
		int r = scn.nextInt();

		if (p > q && p > r) {
			System.out.println("Greateat is " + p);
		} else if (q > r) {
			System.out.println("Greateat is " + q);
		} else
			System.out.println("Greateat is " + r);
		
	}

}
