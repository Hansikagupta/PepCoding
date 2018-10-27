package Day1;

import java.util.Scanner;

public class ReverseDigits {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int i, rev = 0;
		int remainder;
		for(i = num; i > 0; i = i/10) {
			remainder = i%10;
			rev = rev *10 +remainder;		
		}
		System.out.println(rev);		
	}

}
