package Day1;

public class kadane {

	public static void main(String[] args) {
		int[]arr = {5, 7, -14, 2, 3, 9, -4, 6, -18,7};
		int sum;
		sum = kadane(arr);
		System.out.println(sum);

	}
	private static int kadane (int[] arr) {
		int csum = arr[0], overallsum = arr[0];
		int start = 0, end = 0, tempstart = 0;
		
		for(int i = 1; i < arr.length; i++) {
			if( csum> 0) {
				csum = csum + arr[i];				
			}
			else {
				csum = arr[i];	
				tempstart = i;
			}
			
			if(overallsum < csum) {
				overallsum = csum;
				start = tempstart;
				end = i;
			}
		}
		System.out.println(start + " " + end);

		
		return overallsum;
	}

}
