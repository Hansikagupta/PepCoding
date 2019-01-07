package day25;

public class BinaryCodeInTree {
	private static class Pair{
		int num;
		String bin;
	}

	public static void main(String[] args) {		 
		 printBinaries(10);	 
	}

	private static void printBinaries(int n) {
		Q<Pair> myq = new Q<>(10); 
		Pair fp = new Pair();
		fp.bin = "1";
		fp.num = 1;
		myq.enqueue(fp);;
		while(!myq.isEmpty()) {
			
		}
		
		
	}

}
