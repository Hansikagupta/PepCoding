package Day1;

public class DecimalToBinary {
	public static void main(String[] args) {
		int num = 57;
		System.out.println(DtoB(num));
	}

	private static long DtoB(int num) {

		int rem;
		int pow = 1;
		long newbin = 0;
		for (int i = num; i > 0; i = i / 2) {
			rem = i % 2;
			newbin = (newbin +  rem*pow);
			pow = pow*10;

		}
		return newbin;
	}

}
