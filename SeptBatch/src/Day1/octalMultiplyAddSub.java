package Day1;

public class octalMultiplyAddSub {

	public static void main(String[] args) {
		int num1, num2, sum, diff, prod;
		num1 = 10;
		num2 = 7;
		sum = add(num1, num2);
		System.out.println("sum " + sum);
		diff = sub(num1, num2);
		System.out.println("diff " + diff);
		prod = mul(num1, num2);
		System.out.println("prod " + prod);

	}

	private static int mul(int num1, int num2) {
		int prod = 0, line = 0;
		int rem1, rem2;
		int i, j = num2;
		int carry, pow, linePow = 1;
		while (j > 0) {
			rem2 = j % 10;
			i = num1;
			carry = 0;
			pow = 1;
			while (i > 0 || carry > 0) {
				rem1 = i % 10;
				line = line + ((rem1 * rem2 + carry) % 8) * pow;
				carry = (rem1 * rem2 + carry) / 8;
				pow = pow * 10;
				i = i / 10;
			}
			prod = add(line * linePow, prod);
			j = j / 10;
			linePow = linePow * 10;

		}
		return prod;
	}

	private static int sub(int num1, int num2) {
		int diff = 0;
		int rem1, rem2;
		int i, j;
		int borrow = 0, pow = 1;
		for (i = num1, j = num2; i > 0 || j > 0; i = i / 10, j = j / 10) {
			rem1 = i % 10;
			rem1 = rem1 - borrow;
			rem2 = j % 10;

			if (rem2 > rem1) {
				borrow = 1;
				rem1 = rem1 + 8;

			} else {
				borrow = 0;
			}

			diff = diff + (rem1 - rem2) * pow;
			pow = pow * 10;
		}
		return diff;
	}

	private static int add(int num1, int num2) {
		int sum = 0;
		int rem1, rem2;
		int i, j;
		int carry = 0, pow = 1;
		for (i = num1, j = num2; i > 0 || j > 0 || carry > 0; i = i / 10, j = j / 10) {
			rem1 = i % 10;
			rem2 = j % 10;
			sum = sum + ((rem1 + rem2 + carry) % 8) * pow;
			carry = (rem1 + rem2 + carry) / 8;

			pow = pow * 10;
		}

		return sum;
	}

}