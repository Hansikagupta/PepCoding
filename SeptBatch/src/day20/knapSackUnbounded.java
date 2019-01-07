package day20;

public class knapSackUnbounded {

	public static void main(String[] args) {
		int[] wts = {2, 5, 1, 3, 4};
		int[] profits = {15, 14, 10, 45, 30};
		int capacity = 7;
		ubknapSack(wts, profits, capacity);
	}

	private static void ubknapSack(int[] wts, int[] profits, int capacity) {
		int[] storage = new int[capacity +1];
		String ans;
		for(int j = 0; j < wts.length; j++) {
			int weight = wts[j];
			for(int i = 0; i < storage.length; i++) {
				if(i >= weight) {
					storage[i] = Math.max(storage[i], storage[i - weight] + profits[j]);
				}
			}
		}
		System.out.println(storage[capacity]);
	}

}
