package gs5_10_18;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class bank {
	private static float fee(int n, int k, int x, int[] p) {
		float pay = 0;
		int kLimit = (100 * k);

		for (int i = 0; i < n; i++) {
			if (x * p[i] > kLimit)
				pay = pay +  ((float)x * (float)p[i]) / 100;
			else
				pay = pay + k;
		}
		return pay;
	}

	static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
		float f = fee(n, k, x, p);
		String answer = "";

		if (f > d) {
			answer = "upfront";
		} else {
			answer = "fee";
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int x = in.nextInt();
			int d = in.nextInt();
			int[] p = new int[n];
			for (int p_i = 0; p_i < n; p_i++) {
				p[p_i] = in.nextInt();
			}
			String result = feeOrUpfront(n, k, x, d, p);
			System.out.println();
			System.out.println(result);
		}
		in.close();
	}
}
