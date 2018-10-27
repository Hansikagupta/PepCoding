package Day6;
//

public class SSRecuseWithArray {

	public static void main(String[] args) {
//		System.out.println(fspower(3, 5));
//		System.out.println(fac(3));
		int[] arr = { 11, 4, 9, 8, 30, 8, 2 };
//		displayR(arr, arr.length -1);
//		System.out.println(max(arr, 0));
//		System.out.println(firstIndex(arr, 0, 8));
//		System.out.println(lastIndex(arr, 0, 8));
		
		printArr(allIndices(arr, 0, 8, 0));
		

	}

	private static int power(int x, int n) {
		if (n == 1) {
			return x;
		}

		int res = power(x, n / 2);
		if (n % 2 == 0)
			return res * res;
		else
			return res * res * x;

	}

	private static int fspower(int x, int n) {
		if (n == 1) {
			return x;
		}

		if (n % 2 == 0)
			return fspower(fspower(x, n / 2), 2);

		else
			return fspower(fspower(x, n / 2), 2) * x;

	}

	private static int fac(int n) {
		if (n == 0) {
			return 1;
		}
		return n * fac(n - 1);
	}

	private static void displayR(int[] arr, int vidx) {
		if (vidx < 0)
			return;
		System.out.println(arr[vidx]);
		displayR(arr, vidx - 1);
	}

	private static int max(int[] arr, int vidx) {
		if (vidx == arr.length - 1)
			return arr[arr.length - 1];
		int r1 = max(arr, vidx + 1);
		if (r1 > arr[vidx])
			return r1;
		else
			return arr[vidx];

	}

	private static boolean find(int[] arr, int vidx, int data) {
		if (vidx == arr.length)
			return false;
		if ((arr[vidx] == data) || find(arr, vidx + 1, data) == true)
			return true;

		else
			return false;

	}

	private static int firstIndex(int[] arr, int vidx, int data) {
		if (vidx == arr.length)
			return -1;
		if ((arr[vidx] == data))
			return vidx;

		else
			return firstIndex(arr, vidx + 1, data);

	}

	private static int lastIndex(int[] arr, int vidx, int data) {
		if (vidx == arr.length)
			return -1;

		int res = lastIndex(arr, vidx + 1, data);
		if (arr[vidx] == data) {
			if (vidx > res) {
				return vidx;
			}
			else return res;
		} else
			return res;

	}
	
//	private static int[] allIndices(int[] arr, int vidx, int data) {
//		int[] res = new int[arr.length];
//		return allIndicesResult(arr, vidx, data, res, 0);
//	}
//	private static int[] allIndicesResult(int[] arr, int vidx, int data, int[] res, int resIndex) {
//		if (vidx == arr.length)
//			return res;
//		if (arr[vidx] == data) {
//			res[resIndex] = vidx;
//			return allIndicesResult(arr, vidx + 1, data, res, resIndex+1);	
//
//		}
//		else
//			return allIndicesResult(arr, vidx + 1, data, res, resIndex);	
//
//			
//	}
	
	private static int[] allIndices(int[] arr, int vidx, int data, int fsf) {
		if(vidx == arr.length) {
			int []res = new int[fsf];
			return res;
		}
		if(arr[vidx] == data) {
			int[] a1 = allIndices(arr, vidx+1, data, fsf+1);
			a1[fsf] = vidx;
			return a1;
		}
		else {
			int[] a2 = allIndices(arr, vidx+1, data, fsf);
			return a2;
		}
	}
	
	

	
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	

}
