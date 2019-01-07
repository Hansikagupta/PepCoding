package day20;

public class rodCutting {

	public static void main(String[] args) {
		int[] arr = {0, 3, 5, 6, 15, 10, 25, 12, 24};
		int[] wts = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		int capacity = 8;
		ubknapSack(wts, arr, capacity);
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
