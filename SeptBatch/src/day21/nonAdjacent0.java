package day21;

public class nonAdjacent0 {

	public static void main(String[] args) {
		int length = 6;
		int num = nonAjacent0(length);
		System.out.println(num);
		
		int[] arr = {5, 6, 10, 100, 10, 5};
		greedyIncExc(arr);
	}
	
	private static void greedyIncExc( int[] arr) {
		int include = arr[0];
		int exclude = 0;
		int nInclude = 0;
		int nExclude = 0;
		for(int i = 1; i < arr.length; i++) {
			nInclude = exclude + arr[i];
			nExclude = Math.max(include, exclude);
			include = nInclude;
			exclude = nExclude;
		}
		System.out.println( Math.max(include, exclude));
		
	}

	private static int nonAjacent0(int length) {
		int num0 = 1;
		int num1 = 1;
		int new0 = 0;
		int new1 = 0;
		for(int l = 2; l <= length; l++) {
			new0 = num1;
			new1 = num0 + num1;
			num0 = new0;
			num1 = new1;
		}
		return num1+num0;
	}

}
