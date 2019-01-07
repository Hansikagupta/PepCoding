package day19;

public class minJumps {

	public static void main(String[] args) {
//		int[] jumpArray = { 3, 4, 0, 1, 2, 0, 3, 1, 0, 2, 1 }; // ans = 5
//		int minJump = minJumpCount(jumpArray);
//		System.out.println(minJump);
		
		
	}

	private static int minJumpCount(int[] jumpArray) {
		int[] minJumpToDestination = new int[jumpArray.length];
		// dest = minJumpToDestination.length -1
		minJumpToDestination[minJumpToDestination.length - 1] = 0;
		for (int start = minJumpToDestination.length - 2; start >= 0; start--) {
			if (jumpArray[start] == 0) {
				minJumpToDestination[start] = -1;
			} else {
				int min = Integer.MAX_VALUE;
				boolean otherOptionFlag = false;
				for (int jumpsize = 1; jumpsize <= jumpArray[start]; jumpsize++) {
					if (start + jumpsize < minJumpToDestination.length && minJumpToDestination[start + jumpsize] != -1) {
						int jumpsReq = minJumpToDestination[start + jumpsize] + 1;
						otherOptionFlag = true;
						min = Math.min(min, jumpsReq);
					}
				}
				if (otherOptionFlag == false) {
					minJumpToDestination[start] = -1;
				} else
					minJumpToDestination[start] = min;

			}
		}
		printArr(minJumpToDestination);
		return minJumpToDestination[0];
	}
	
//	private static int minJumpCountSir(int[] jumpArray) {
//		Integer[] minJumpToDestination = new Integer[jumpArray.length];
//		// dest = minJumpToDestination.length -1
//		minJumpToDestination[minJumpToDestination.length - 1] = 0;
//		for (int start = minJumpToDestination.length - 2; start >= 0; start--) {
//			if (jumpArray[start] == 0) {
//				minJumpToDestination[start] = -1;
//			} else {
//				for (int jumpsize = 1; jumpsize <= jumpArray[start] && start + jumpsize < minJumpToDestination.length; jumpsize++) {
//					if (minJumpToDestination[start + jumpsize] != -1) {
//						
//					}
//				}
//				if (otherOptionFlag == false) {
//					minJumpToDestination[start] = -1;
//				} else
//					minJumpToDestination[start] = min;
//
//			}
//		}
//		printArr(minJumpToDestination);
//		return minJumpToDestination[0];
//	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
