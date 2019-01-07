package day23;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GreedyandDP {
//Fractional Knapsack
	public static void main(String[] args) {
		int wts[] = { 10, 40, 20, 30 };
		int val[] = { 60, 40, 100, 120 };
		fractionalKs(wts, val, 50);

	}

	private static int fractionalKs(int[] wts, int[] val, int capacity) {
		Item[] items = new Item[wts.length];
		for (int i = 0; i < items.length; i++) {
			items[i] = new Item();
			items[i].val = val[i];
			items[i].weight = wts[i];
			items[i].vwRatio = val[i] * 1.0 / wts[i];
		}
		Arrays.sort(items);
		int rc = capacity;
		int ans = 0;
		for (int i = items.length - 1; i >= 0 && rc > 0; i--) {
			if (rc >= items[i].weight) {
				rc -= items[i].weight;
				ans += items[i].val;
			} else {
				ans += items[i].val * rc / items[i].weight;
				rc = 0;
			}
		}
		System.out.println(ans);
		return ans;

	}

}
