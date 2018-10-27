package Day4;

public class SSstringDemo {
	public static void main(String[] args) {
		String s = "abc";
		/*
		 * printChar(s); printAllSubstrings(s); System.out.println(isPalindrome(s));
		 * allPalindromes(s);
		 */
		allPermutations(s);
		
	}

	private static void printChar(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}

	}

	private static void printAllSubstrings(String s) {
		System.out.println();

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j <= s.length(); j++) {
				System.out.println(s.substring(i, j));
			}
		}
	}

	private static boolean isPalindrome(String s) {
		int start = 0, end = s.length() - 1;
		for (; start < end; start++, end--) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
		}
		return true;

	}

	private static void allPalindromes(String s) {

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (isPalindrome(s.substring(i, j))) {
					System.out.println("palindrome = " + s.substring(i, j));
				}
			}
		}

	}

	private static int factorial(int n) {

		if (n == 0) {
			return 1;
		} else
			return n * factorial(n - 1);
	}

	private static void allPermutations(String s) {
		int length = s.length();
		String ss = s;
		String result = "";
		for (int i = factorial(length) - 1; i >= 0; i--) {// i = 5-> 0
			int k = i;
			ss=s;
			result="";
			for (int j = length; j > 0; j--) {// j = 3->1
				int rem = k % j;
				k = k/j;
				result = result + ss.charAt(rem);
					ss = ss.substring(0, rem) + ss.substring(rem + 1);
			}
			System.out.println(result);
		}
	}

	//Assignment
	private static void allSubsequences(String s) {
		int length = s.length();
		
		
	}
}
