package day19;

public class coinChange {

	public static void main(String[] args) {
		int amount = 10;
		int[] coins = { 2, 3, 5, 6 };
		int perm = coinChangeCom(amount, coins);
		System.out.println(perm);
	}

	private static int coinChangePermutation1(int amount, int[] coins) {
		int[] arr = new int[amount + 1];
		arr[0] = 1;
		for (int tempAmt = 1; tempAmt < arr.length; tempAmt++) {
			for (int coin = 0; coin < coins.length; coin++) {

				if (coins[coin] <= tempAmt) {
					arr[tempAmt] += arr[tempAmt - coins[coin]];
				}
			}
		}
		System.out.println(arr[arr.length - 1]);
		
		return 0;

	}

	private static int coinChangeCom(int amount, int[] coins) {
		int[] arr = new int[amount + 1];
		arr[0] = 1;
		for (int coin = 0; coin < coins.length; coin++) {
			for (int tempAmt = 1; tempAmt <= amount; tempAmt++) {

				if (coins[coin] <= tempAmt) {
					arr[tempAmt] += arr[tempAmt - coins[coin]];
				}
			}
		}
		System.out.println(arr[arr.length - 1]);
		return 0;

	}

}
