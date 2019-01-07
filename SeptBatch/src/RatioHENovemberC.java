import java.util.Scanner;

public class RatioHENovemberC {
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		int reps = s.nextInt(); // Reading input from STDIN
		for (int r = 0; r < reps; r++) {
			int inputLines = s.nextInt();
			int[] arr = new int[inputLines];
			char[] cArr = new char[inputLines];
			int finalArrLength = 0;
			for (int i = 0; i < arr.length; i++) {
				int numInput = s.nextInt();
				char cInput = s.next().charAt(0);
				arr[i] = numInput;
				cArr[i] = cInput;
				finalArrLength += numInput;
			}
			char[] finalArr = new char[finalArrLength];
			int position = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int sameCharRep = 0; sameCharRep < arr[i]; sameCharRep++, position++) {
					finalArr[position] = cArr[i];
				}
			}
//			for (int i = 0; i < finalArr.length; i++) {
//				System.out.println(finalArr[i]);
//			}

			int ans = maxPartitions(finalArr);
			System.out.println(ans);
		}
	}

	private static int maxPartitions(char[] arr) {
		int maxPartitions = Integer.MIN_VALUE;
		int[][][] strg = new int[arr.length][arr.length][arr.length];


		for (int firstPartitionAfterIndex = 0; firstPartitionAfterIndex < arr.length; firstPartitionAfterIndex++) {
			// Ratio Calculation till First Cut
			int Ano = 0, Bno = 0;
			for (int i = 0; i <= firstPartitionAfterIndex; i++) {
				if (arr[i] == 'A') {
					Ano++;
				} else
					Bno++;
			}
			 int gcm = gcm(Ano, Bno);
			
			// double ratio = (Ano * 1.0 )/Bno;
			int partitions = findMaxCuts(strg, (int)Ano/gcm, (int)Bno/gcm, firstPartitionAfterIndex, arr, 1);
			maxPartitions = Math.max(partitions, maxPartitions);
		}
		return maxPartitions;
	}
	public static int gcm(int a, int b) {
	    return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
	}
	
	private static int findMaxCuts(int[][][] strg, int fAno, int fBno, int lastPartitionAfterIndex, 
													char[] arr, int count) {
		if(strg[fAno][fBno][lastPartitionAfterIndex] != 0)		{
			return strg[fAno][fBno][lastPartitionAfterIndex];
		}

		if(lastPartitionAfterIndex == arr.length -1) {
			return count;
		}
		int Ano = 0, Bno = 0;
		for (int i = lastPartitionAfterIndex + 1; i < arr.length; i++) {
			if (arr[i] == 'A') {
				Ano++;
			} else
				Bno++;
			if (Ano * fBno == Bno * fAno) {
				count = findMaxCuts(strg, fAno, fBno, i, arr, count+1);
				break;
			} else if (i == arr.length - 1) {
				count = 0;
				
			}
		}
		strg[fAno][fBno][lastPartitionAfterIndex] = count;
		return count;
	}

//	private static int findMaxCuts(int fAno, int fBno, int 
	//firstPartitionAfterIndex, char[] arr, int count) {
//		int Ano = 0, Bno = 0;
//		for (int i = firstPartitionAfterIndex + 1; i < arr.length; i++) {
//			if (arr[i] == 'A') {
//				Ano++;
//			} else
//				Bno++;
//			if (Ano * fBno == Bno * fAno) {
//				count++;
//				Ano = 0;
//				Bno = 0;
//			} else if (i == arr.length - 1) {
//				count = 0;
//			}
//		}
//		return count;
//	}
	
	
	
}








/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* IMPORTANT: Multiple classes and nested static classes are supported */

 //uncomment this if you want to read input.
//imports for BufferedReader
// import java.io.BufferedReader;
// import java.io.InputStreamReader;

//
//import java.util.Scanner;

//
//// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
//
//class TestClass {
//    public static void main(String args[] ) {
//       
//         Scanner s = new Scanner(System.in);
//        int reps = s.nextInt();                 // Reading input from STDIN
//        for(int r = 0; r < reps; r++) {
//            int inputLines = s.nextInt();
//            int[] arr = new int[inputLines];
//            char[] cArr = new char[inputLines];
//            int finalArrLength = 0;
//            for(int i = 0; i < arr.length; i++) {
//            	int numInput = s.nextInt();
//            	char cInput = s.next().charAt(0);
//            	arr[i] = numInput;
//            	cArr[i] = cInput;
//            	finalArrLength += numInput;
//            }
//            
//        	char[] finalArr = new char[finalArrLength];
//        	int position = 0;
//            for(int i = 0; i < arr.length; i++) {
//            	for(int sameCharRep = 0; sameCharRep < arr[i]; sameCharRep++, position++) {
//                	finalArr[position] = cArr[i];
//            	}
//            }
//           
//// for (int i = 0; i < finalArr.length; i++) {
//// 				System.out.println(finalArr[i]);
//// 		}
//         
//            int ans = maxPartitions(finalArr);
//            System.out.println(ans);
//        }
//    }
//	
//
//		private static int maxPartitions(char[] arr) {
//		int maxPartitions = Integer.MIN_VALUE;
//		int[][][] strg = new int[arr.length / 2][arr.length/2][arr.length];
//
//
//		for (int firstPartitionAfterIndex = 0; firstPartitionAfterIndex < arr.length; firstPartitionAfterIndex++) {
//			// Ratio Calculation till First Cut
//			int Ano = 0, Bno = 0;
//			for (int i = 0; i <= firstPartitionAfterIndex; i++) {
//				if (arr[i] == 'A') {
//					Ano++;
//				} else
//					Bno++;
//			}
//			 int gcm = gcm(Ano, Bno);
//			
//			// double ratio = (Ano * 1.0 )/Bno;
//			int partitions = findMaxCuts(strg, (int)Ano/gcm, (int)Bno/gcm, firstPartitionAfterIndex, arr, 1);
//			maxPartitions = Math.max(partitions, maxPartitions);
//		}
//		return maxPartitions;
//	}
//	public static int gcm(int a, int b) {
//	    return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
//	}
//	
//	private static int findMaxCuts(int[][][] strg, int fAno, int fBno, int lastPartitionAfterIndex, 
//													char[] arr, int count) {
//		if(fAno < arr.length/2 && fBno < arr.length/2 &&strg[fAno][fBno][lastPartitionAfterIndex] != 0)		{
//			return strg[fAno][fBno][lastPartitionAfterIndex];
//		}
//
//		if(lastPartitionAfterIndex == arr.length -1) {
//			return count;
//		}
//		int Ano = 0, Bno = 0;
//		for (int i = lastPartitionAfterIndex + 1; i < arr.length; i++) {
//			if (arr[i] == 'A') {
//				Ano++;
//			} else
//				Bno++;
//			if (Ano * fBno == Bno * fAno) {
//				count = findMaxCuts(strg, fAno, fBno, i, arr, count+1);
//				break;
//			} else if (i == arr.length - 1) {
//				count = 0;
//				
//			}
//		}
//		if(fAno < arr.length/2 && fBno < arr.length/2) {
//		strg[fAno][fBno][lastPartitionAfterIndex] = count;
//		}
//		return count;
//	}
//}


