package Day8;

import java.util.ArrayList;

public class SSRec4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(board2(0, 0, 2, 2));
		// printSSAscii("9865", "");
		// printKPC("9867", "");
		// printBP(0, 10, " ");
		// printMP(0, 0, 2, 2, "");

	}

	private static ArrayList<String> board2(int sr, int sc, int dr, int dc) {
		if (sr == dr && sc == dc) {
			ArrayList<String> bresult = new ArrayList<>();
			bresult.add("");
			return bresult;

		}
		ArrayList<String> rrec = new ArrayList<>();
		ArrayList<String> mrec = new ArrayList<>();
		if (sc < dc) {
			rrec = board2(sr, sc + 1, dr, dc);
			for (String res : rrec) {
				mrec.add("H" + res);
			}
		}
		if (sr < dr) {
			rrec = board2(sr + 1, sc, dr, dc);
			for (String res : rrec) {
				mrec.add("V" + res);
			}
		}
		return mrec;
	}

	private static void printSSAscii(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = ques.charAt(0);
		int ascii = ch;
		String roq = ques.substring(1);
		printSSAscii(roq, asf + ch);
		printSSAscii(roq, asf);
		printSSAscii(roq, asf + ascii);

	}

	static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wx", "yz" };

	private static void printKPC(String ques, String asf) {
		if (ques.length() == 0) {
			System.out.println(asf);
			return;
		}
		char ch = ques.charAt(0);
		int val = chartoInt(ch);
		int l = codes[val].length();
		String roq = ques.substring(1);

		for (int i = 0; i < l; i++) {
			printKPC(roq, asf + codes[val].charAt(i));
		}
	}

	private static int chartoInt(char ch) {
		int val = ch - '0';
		return val;
	}

	private static void printBP(int source, int dest, String asf) {

		if (source == dest) {
			System.out.println(asf + "\n");
			return;
		}

		for (int i = 1; i < 6 && i < dest - source; i++) {
			printBP(source + i, dest, asf + i);
		}
	}

	private static void printMP(int sr, int sc, int dr, int dc, String asf) {
		if (sr == dr && sc == dc) {
			System.out.println(asf);
			return;

		}
		if(sr<dr) {
			printMP(sr+1, sc, dr, dc, asf + "V");
		}
		if(sc<dc) {
			printMP(sr, sc+1, dr, dc, asf + "H");
		}

	}

//	private static ArrayList<String> board2(int sr, int sc, int dr, int dc) {
//		if(sr == dr && sc == dc) {
//			ArrayList<String> bresult = new ArrayList<>();
//			bresult.add("");
//			return bresult;
//			
//		}
//		ArrayList<String> rrec = new ArrayList<>();
//		ArrayList<String> mrec = new ArrayList<>();
//		if(sc < dc) {
//			rrec = board2(sr, sc+1, dr, dc);
//			for(String res: rrec ) {
//				mrec.add("H" + res);
//			}
//		}		
//		if(sr < dr) {
//			rrec = board2(sr+1, sc, dr, dc);
//			for(String res: rrec ) {
//				mrec.add("V" + res);
//			}
//		}
//		return mrec;		
//	}

}
