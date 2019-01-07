package mineSweeper;

public class cheatSheetforMineSweeper {

	public static void main(String[] args) {
		int length = 6;
		int breadth = 6;
		int[][] table = new int[length][breadth];
		int[][] probabilityTable = new int[length][breadth];
		initializeTable(probabilityTable, -1);
		showCheat(table, probabilityTable);
	}


	private static void showCheat(int[][] table, int[][] probabilityTable) {
		for(int row = 0; row < table.length; row++) {
			for(int column = 0; column < table[0].length; column++) {
				findProbability(row, column, table, probabilityTable);
			}
		}
	}


	private static void findProbability(int row, int column, int[][] table, int[][] probabilityTable) {
		
		
		if(probabilityTable[row][column]!= -1) {
			return;
		}
		else {
			if(row != table.length-1) {
				
			}
			if(row != 0) {
				
			}
			if(column != table[0].length) {
				
			}
			if(column != 0) {
				
			}
			if(column != 0 && row != 0) {
				
			}
			if(row != table.length-1 && column != table[0].length) {
				
			}
			if(row !=0 &&column != table[0].length) {
				
			}
			if(column != 0 && row != table.length) {
				
			}
		}
	}
	
	private static void initializeTable(int[][] table, int i) {
		for(int row = 0; row < table.length; row++) {
			for(int column = 0; column < table[0].length; column++) {
				table[row][column] = i;
			}
		}
	}

}

