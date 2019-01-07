package day21;

public class egyptianFraction {

	public static void main(String[] args) {
		int numerator = 3;
		int denominator = 7;
		distributeFraction(numerator, denominator, "");

	}

	private static void distributeFraction(int numerator, int denominator, String asf) {
		if (denominator % numerator == 0) {
			asf = asf + " 1 /" + denominator/numerator;
			System.out.println(asf);
			return;
		}

		int ansDenominator = 0;
		ansDenominator = (denominator / numerator + 1);

		int newDenominator = ansDenominator * denominator;
		int newNumerator = (numerator * ansDenominator) - denominator;
		//System.out.println(ansDenominator + " " + newNumerator + " " + newDenominator);

		distributeFraction(newNumerator, newDenominator, asf + " " + "1 /" + ansDenominator +" +");

	}

}
