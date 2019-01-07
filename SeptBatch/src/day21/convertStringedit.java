package day21;

public class convertStringedit {

	public static void main(String[] args) {
		String s1 = "acdefgki";
		String s2 = "abcdfghi";
		int operations = editDistanceTab(s1, s2);
		System.out.println(operations);
	}

//do memoize
	private static int editDistanceTab(String s1, String s2) {
		int[][] storage = new int[s1.length() + 1][s2.length() + 1];
		int gap = s1.length() -s2.length();
		for (int row = storage.length - 1; row >= 0; row--) {
			for (int col = storage[0].length - 1; col >= 0; col--) {
				if (row == storage.length - 1) {
					storage[row][col] = row - col - gap;
				} else if (col == storage[0].length - 1) {
					storage[row][col] = col - row+ gap;
				} else if (s1.charAt(row) == s2.charAt(col)) {
					storage[row][col] = storage[row + 1][col + 1];
				} else {
					int replace = 1 + storage[row + 1][col + 1];
					int insert = 1 + storage[row + 1][col];
					int remove = 1 + storage[row][col + 1];
					storage[row][col] = Math.min(replace, Math.min(insert, remove));
				}
			}
		}
		return storage[0][0];
	}

}
