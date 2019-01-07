package Day22;

public class SegmantTree {
	static int[] baseArray ;
	static int [] segmentTree;
	static int height;
	static int size;
	

	public static void main(String[] args) {
		baseArray = new int[] { 1, 4, -9, 4, 6, 8, 1 };
		build();
		System.out.println(query(2, 5));

	}
	
	private static void build(int si, int bl, int br ) {
		height = (int)Math.ceil(getLog(baseArray.length));
		segmentTree = new int[(1<<(height+1))-1];
		
	}
	private static void update(int idx, int val) {
		
	}
	private static int query(int l, int r) {
		return query(0, 0, baseArray.length -1, l, r);
	}
	private static int query(int si, int bl, int br, int l, int r) {
		
	}
	private static int getLog(int n) {
		int log = 0;
		while ((1 << log) < n) {
			log++;
		}
		return log;
	}





}
