package day2;

public class BaseToBase {
	public static void main(String[] args) {
		int b1 = 10;
		int b2 = 8;
		int num = 80;
		System.out.println(convert(b1, b2, num));
	}

	private static int convert(int b1, int b2, int num) {
		if (b1 != 10) {
			num = baseToDecimal(b1,num);
			System.out.println("no in decimal = "+ num);

		}
		return decimalToBase(b2, num);
		

	}
	private static int decimalToBase(int base, int num) {//base = destination base
		int pow = 1, rem = 0, i, res = 0;
		for (i = num; i > 0; i = i /base) {
			rem = i % base;
			res = res + pow*rem;
			pow = pow * 10;
		}
		return res;
	}


	private static int baseToDecimal(int base, int num) {//base = sourceBase
		int pow = 1, rem = 0, i, res = 0;
		for (i = num; i > 0; i = i / 10) {
			rem = i % 10;
			res = res + pow*rem;
			pow = pow * base;
		}
		return res;
	}

}
