package Day7;

import java.util.ArrayList;
import java.util.Arrays;

public class SSRecursion3 {
	// 1123 -> aabc, kw, aaw, alc, aaw

	// static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs",
	// "tuv", "wx", "yz" };

	public static void main(String[] args) {
//		int[] arr = { 3, 4, 1, 0, 2 };
//		inverse(arr, 0);	
//		printArr(arr);
		
//		System.out.println(asciiWithSubsequence("ab"));
//		System.out.println(getKPC("25"));
//		System.out.println(findStrings("1123"));
//		ArrayList<String> ans = new ArrayList<>();
//		ans = getBoardPath(0, 10);
//		System.out.println(ans);
//		System.out.println(ans.size());
		
		
	}

//	private static ArrayList<String> findStrings(String keys) {
//		if (keys.length() == 0) {
//			ArrayList<String> bresult = new ArrayList<>();
//			bresult.add("");
//			return bresult;
//		}
//		char ch = keys.charAt(0);
//		int keyNumber = ch - '0';
//		int state = 0, nextKeyNumber = 0, newNumber = 0;
//		if (keys.length() > 1) {
//			nextKeyNumber = keys.charAt(1) - '0';
//			newNumber = keyNumber * 10 + nextKeyNumber;
//			if (newNumber <= 26)
//				state = 2;		//13
//			else
//				state = 3;		// 45
//		}
//		if (keyNumber == 0)
//			state = 1;// 03
//		String ros = keys.substring(1);
//		ArrayList<String> rresult = new ArrayList<>();
//		ArrayList<String> mresult = new ArrayList<>();
//		rresult = findStrings(ros);
//		for (String res : rresult) {
//			if (state == 1)
//				return rresult;
//			if (state == 2) {
//				ch = (char) ('a' + newNumber - 1);// -1 because a == 1 in our code
//				mresult.add(ch + "" + res);
//			}
//			ch = (char) ('a' + keyNumber - 1);
//			mresult.add(ch + "" + res);
//		}
//		return mresult;
//	}

	private static ArrayList<String> getBoardPath(int src, int dest) {
		if (src >= dest) {
			ArrayList<String> blank = new ArrayList<>();
			blank.add("\n");
			return blank;
		}
		int movesLeft = dest - src;
		// int possibleMoves = (6 < movesLeft) ? 6 : movesLeft;
		int possibleMoves;
		if (6 < movesLeft)
			possibleMoves = 6;
		else
			possibleMoves = movesLeft;
		ArrayList<String> rresult = new ArrayList<>();
		ArrayList<String> mresult = new ArrayList<>();
		for (int i = 1; i <= possibleMoves; i++) {
			rresult = getBoardPath(src + i, dest);
			for (String res : rresult) {
				mresult.add(i + res);
			}
		}
		return mresult;
	}

	private static ArrayList<String> getKPC(String keys) {
		if (keys.length() == 0) {
			ArrayList<String> bresult = new ArrayList<>();
			bresult.add("");
			return bresult;
		}
		char ch = keys.charAt(0);
		int keyNumber = (int) ch - '0';

		String ros = keys.substring(1);
		ArrayList<String> rresult = new ArrayList<>();
		ArrayList<String> mresult = new ArrayList<>();
		rresult = getKPC(ros);
		for (String res : rresult) {
			for (int i = 0; i < codes[keyNumber].length(); i++) {
				mresult.add(codes[keyNumber].charAt(i) + res);
			}
		}
		return mresult;
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static ArrayList<String> asciiWithSubsequence(String str) {
		if (str.length() == 0) {
			ArrayList<String> bresult = new ArrayList<>();
			bresult.add("");
			return bresult;
		}
		char ch = str.charAt(0);
		int ascii = ch;
		String ros = str.substring(1);
		ArrayList<String> rresult = new ArrayList<>();
		ArrayList<String> mresult = new ArrayList<>();
		rresult = asciiWithSubsequence(ros);
		for (String res : rresult) {
			mresult.add("_" + " " + res);
			mresult.add(ch + " " + res);
			mresult.add(ascii + " " + res);
		}
		return mresult;
	}

	    public static ArrayList<String> findStrings(String keys) {
	        ArrayList<String> result = new ArrayList<>();
	        findStrings(result, new StringBuilder(), keys, 0);
	        return result;
	    }

	    private static void findStrings(ArrayList<String> result, StringBuilder out, String keys, int i) {
	        if (keys.length() == i) {
	            result.add(out.toString());
	            return;
	        }
	        int initialOutLen = out.length();

	        out.append(oneDigitChar(keys, i));
	        findStrings(result, out, keys, i + 1);

	        out.setLength(initialOutLen);

	        char twoDigitChar = twoDigitChar(keys, i);
	        if (twoDigitChar == '\0') return;
	        out.append(twoDigitChar);
	        findStrings(result, out, keys, i + 2);
	    }

	    private static char oneDigitChar(String key, int i) {
	        return (char) (key.charAt(i) - '1' + 'a');
	    }

	    private static char twoDigitChar(String key, int i) {
	        if (key.length() <= i + 1) {
	            return '\0';
	        }
	        int tens = key.charAt(i) - '0';
	        int ones = key.charAt(i + 1) - '1';
	        char out = (char) ('a' + tens * 10 + ones);
	        if (out > 'z') return '\0';
	        return out;
	    }
	    
	    
	    private static void inverse(int[] arr, int i) {
	    	if(i == arr.length) {return;}
	    	int temp = arr[i];
	    	inverse(arr, i+1);
	    	arr[temp] = i;
	    	return;
	    	
	    }

}
