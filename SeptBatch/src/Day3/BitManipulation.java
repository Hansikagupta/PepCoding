package Day3;


public class BitManipulation {

	public static void main(String[] args) {
		int i = 57;
		System.out.println("Number = " + i);
		System.out.println("Binary = " + Integer.toBinaryString(i));
		int k = 1;
		//System.out.println("TEST: The number after masking is = " + Integer.toBinaryString(testBit(i, k)));
		System.out.println("ON: The number after setting kth bit is = " + Integer.toBinaryString(setBit(i, k)));
		System.out.println("OFF: The number after resetting kth bit is = " + Integer.toBinaryString(resetBit(i, k)));
		System.out.println("TOGGLE: The number after toggling kth bit is = " + Integer.toBinaryString(toggleBit(i, k)));


	}
	private static int toggleBit (int i, int k) {
		int mask = 1;
		mask = mask << k;
		i = i ^ mask;
		
		return i;
	}
	
	private static int setBit (int i, int k) {
		int mask = 1;
		mask = mask << k;
		i = i | mask;
		return i;
	}
	
	private static int resetBit (int i, int k) {
		int mask = 1;
		mask = mask << k;
		mask = ~mask;
		i = i & mask;	
		return i;
	}


	private static int testBit(int i, int k) {
		int mask = 1;
		mask = mask << k;
		i = i & mask;
		if (i != 0) {
			System.out.println("ON");
		} else
			System.out.println("OFF");
		return i;

	}

}
