package Day22;

public class RangeQueries {

	static int[] sqrt;
	static int[] oarr;
	static int bs;
	static int bc;

	public static void main(String[] args) {
		oarr = new int[] { 1, 4, -9, 4, 6, 8, 1, 0 };
		build();
		System.out.println(query(2, 5));
		update(4, 5);
		System.out.println(query(2, 5));

	}

	private static void build() {
		bs = (int) Math.sqrt(oarr.length);
		bc = (int) Math.ceil(oarr.length * 1.0 / bs);
		sqrt = new int[bc];
		for (int i = 0; i < oarr.length; i++) {
			sqrt[i / bs] += oarr[i];
		}
	}

	private static void update(int idx, int val) {
		sqrt[idx/bs] += val - oarr[idx];
		oarr[idx] = val; 
	}

	private static int query(int l, int r) {
		int sum = 0;
		int lb = l / bs;
		int rb = r / bs;

		if (lb != rb) {
			for (int i = l; i / bs == lb; i++) {
				sum += oarr[i];
			}

			for (int i = lb + 1; i <= rb - 1; i++) {
				sum += sqrt[i];
			}
			for (int i = r; i / bs == rb; i--) {
				sum += oarr[i];
			}
		} else {
			for (int i = l; i <= r; i++) {
				sum += oarr[i];
			}
		}
		return sum;
	}
}
