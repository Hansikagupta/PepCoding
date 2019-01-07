package day20;

public class longestCommonSubsequenceMemo {

	public static void main(String[] args) {
		System.out.println(lcs("abcd", "abed"));
	}

	private static int lcs(String string1, String string2) {
		int[][] storage = new int[string1.length()+1][string2.length()+1];
		for (int i = storage.length - 1; i >= 0; i--) {
			for (int j = storage[0].length - 1; j >= 0; j--) {
				if (i == storage.length - 1 || j == storage[0].length - 1) {
					storage[i][j] = 0;
				} else {
					if (string1.charAt(i) == string2.charAt(j)) {
						storage[i][j] = storage[i + 1][j + 1] + 1;
					} else {
						storage[i][j] = Math.max(storage[i][j + 1], storage[i + 1][j]);
					}
				}
			}
		}
		return storage[0][0];
	}

}
