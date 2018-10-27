package Day3;

public class FindUnPaired {
	public static void main(String[] args) {
		int[]arr = {2,3,1,3,6,4,2,4,1};
		//XOR is commutative
		int ans = 0;
		for(int i = 0; i < arr.length; i++) {
			ans = ans ^arr[i];
		}
		System.out.println("ans = " + ans);
	}


}
