package day27Egg;

public class EggDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int eggs = 2, floors = 10; // ans 4
		int[][] storage = new int[eggs+1][floors+1];

		System.out.println(minAttempts(eggs, floors, storage));

	}

	private static int minAttempts(int eggs, int floors,int[][] storage) {
		
		
		if(floors == 0|| floors == 1|| eggs == 1) {
			return floors;
		}
		
		if(storage[eggs][floors]!= 0) {
			return storage[eggs][floors];
		}
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= floors; i++) {
			int temp = Math.max(minAttempts(eggs-1, i - 1, storage), minAttempts(eggs, floors - i, storage)) + 1;
			if(temp < min) {
				min = temp;
			}
		}
		
		storage[eggs][floors] = min;
		return min;
	}

}
