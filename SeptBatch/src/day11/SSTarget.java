package day11;

//targetSet 
//EquiSet 
//StringBuilder permutations //1) where in answer to place
//2) which char from question to place

import java.util.ArrayList;

public class SSTarget {
	public static void main(String[] args) {
//		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
//		int tar = 50;
// 		printTargetSS1(arr, tar, 0, 0, "");
//		ArrayList<Integer> ssf = new ArrayList<>();
//		printTargetSS2(arr, tar, 0, ssf);
//		printEquiset(arr, 0, new ArrayList<>(), 0, new ArrayList<>(), 0);
//		printPerm("abc", "");
//		printPerm2(new StringBuilder("abc"), new StringBuilder());
//		printPerm3("abc", "");
		printPerm4(new StringBuilder("abc"), new StringBuilder());
	}

	public static void printTargetSS1(int[] arr, int tar, int vidx, int sosf, String ssf) {
		if (sosf == tar && vidx == arr.length) {
			System.out.println(ssf);
		}
		if (vidx < arr.length) {
			printTargetSS1(arr, tar, vidx + 1, sosf + arr[vidx], ssf + " + " + arr[vidx]);
			printTargetSS1(arr, tar, vidx + 1, sosf, ssf);
		}

	}

	static int sosf = 0;

	public static void printTargetSS2(int[] arr, int tar, int vidx, ArrayList<Integer> ssf) {
		if (vidx == arr.length && sosf == tar) {
			System.out.println(ssf);
			return;
		}
		if (vidx < arr.length) {
			sosf += arr[vidx];
			ssf.add(arr[vidx]);
			printTargetSS2(arr, tar, vidx + 1, ssf);

			sosf -= arr[vidx];
			ssf.remove(ssf.size() - 1);
			printTargetSS2(arr, tar, vidx + 1, ssf);
		}
	}

	public static void printEquiset(int[] arr, int vidx, ArrayList<Integer> set1, int sos1, ArrayList<Integer> set2,
			int sos2) {
		if (vidx == arr.length) {
			if (sos1 == sos2 && set1.size() >= set2.size())
				System.out.println(set1 + " || " + set2);
			return;
		}

		set1.add(arr[vidx]);
		printEquiset(arr, vidx + 1, set1, sos1 + arr[vidx], set2, sos2);
		set1.remove(set1.size() - 1);

		set2.add(arr[vidx]);
		printEquiset(arr, vidx + 1, set1, sos1, set2, sos2 + arr[vidx]);
		set2.remove(set2.size() - 1);

	}

	private static void printPerm1(String s, String asf) {
		if (s.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = s.charAt(0);

		String ros = s.substring(1);
		for (int i = 0; i <= asf.length(); i++) {
			printPerm1(ros, asf.substring(0, i) + ch + asf.substring(i));
		}
	}

	private static void printPerm2(StringBuilder s, StringBuilder asf) {
		if (s.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = s.charAt(0);
		s.deleteCharAt(0);
		for (int i = 0; i <= asf.length(); i++) {
			asf.insert(i, ch);
			printPerm2(s, asf);
			asf.deleteCharAt(i);
		}
		s.insert(0, ch);
	}

	private static void printPerm3(String s, String asf) {
		if (s.length() == 0) {
			System.out.println(asf);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String temp = s.substring(0, i) + s.substring(i + 1);
			printPerm3(temp, asf + ch);
		}

	}

	private static void printPerm4(StringBuilder s, StringBuilder asf) {
		if (s.length() == 0) {
			System.out.println(asf);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			s.deleteCharAt(i);
			asf.append(ch);
			printPerm4(s, asf);
			asf.deleteCharAt(asf.length() - 1);
			s.insert(i, ch);
		}
	}

}
