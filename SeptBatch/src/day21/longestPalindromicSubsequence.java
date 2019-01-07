package day21;

public class longestPalindromicSubsequence {

	public static void main(String[] args) {
//		String word = "abkczcbc";
//		int length = longestPalindromicSubstringMemo(word, new int[word.length()][word.length()], 0 , word.length() -1);
//		System.out.println(length);

		String word = "abkczcbc";
		longestPalindromicSubstringTab(word);
	}

	private static void longestPalindromicSubstringTab(String word) {
		int[][] storage = new int[word.length()][word.length()];
		for (int gap = 0; gap < word.length(); gap++) {
			for (int row = 0, col = row; col < word.length(); row++, col++) {
				if (gap == 0) {
					storage[row][col] = 1;
				} else if (gap == 1) {
					if (word.charAt(row) == word.charAt(col)) {
						storage[row][col] = 2;
					} else
						storage[row][col] = 1;
				}
				if (word.charAt(row) == word.charAt(col)) {
					storage[row][col] = storage[row + 1][col - 1] + 2;
				}
				else {
					storage[row][col] = Math.max(storage[row+1][col], storage[row][col-1]);
				}
			}
		}
		System.out.println(storage[0][storage.length -1]);
	}

	private static int longestPalindromicSubstringMemo(String word, int[][] qb, int start, int end) {

		if (start == end) {
			return 1;
		}
		if (qb[start][end] != 0) {
			return qb[start][end];
		} else {
			int ans = 0;
			if (word.charAt(start) == word.charAt(end)) {

				ans = longestPalindromicSubstringMemo(word, qb, start + 1, end - 1) + 2;
			} else {
				ans = Math.max(longestPalindromicSubstringMemo(word, qb, start + 1, end),
						longestPalindromicSubstringMemo(word, qb, start, end - 1));
			}
			qb[start][end] = ans;
			return ans;
		}
	}

}
