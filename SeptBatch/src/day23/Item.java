package day23;

public class Item implements Comparable<Item> {
	int weight;
	int val;
	double vwRatio;

	@Override
	public int compareTo(Item o) {
		if (this.vwRatio > o.vwRatio) {
			return 1;
		} else if (this.vwRatio < o.vwRatio) {
			return -1;
		} else
			return 0;
	}

}
