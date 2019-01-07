package day19;

public class MatrixMultiplicationCost {

	public static void main(String[] args) {
		int[] dims = { 10, 20, 30, 40, 50, 60 };
//		int[] dims = { 10, 20, 30, 40 };
		Matrix[] matricies = new Matrix[dims.length - 1];
		for (int i = 0; i < matricies.length; i++) {
			matricies[i] = new Matrix(dims[i], dims[i+ 1]);
		}
		int cost = minCostMatTab(matricies);
		System.out.println(cost);
	}

	private static int minCostMatTab(Matrix[] matrices) {
		int[][] storage = new int[matrices.length][matrices.length];
		for(int subArrayLength = 0; subArrayLength < matrices.length; subArrayLength++ ) {
			for(int subArrayStart = 0; subArrayStart + subArrayLength < matrices.length; subArrayStart++ ) {
				if(subArrayLength == 0) {
					storage[subArrayStart][subArrayStart] = 0;
				} else if(subArrayLength == 1) {
					// assert matrices[row].columnCount == matrices[row + 1].rowCount
					storage[subArrayStart][subArrayStart + 1] = matrices[subArrayStart].rowCount * matrices[subArrayStart].columnCount * matrices[subArrayStart + 1].columnCount;
				} else {
					int min = Integer.MAX_VALUE;
					for (int rightArrayStart = subArrayStart + 1; rightArrayStart <= subArrayStart + subArrayLength; rightArrayStart++) {
						int leftArrayStart = subArrayStart;
						int leftArrayEnd = rightArrayStart - 1; // inclusive
						int rightArrayEnd = subArrayStart + subArrayLength; // inclusive
						int leftArrayCost = storage[leftArrayStart][leftArrayEnd];
						int rightArrayCost = storage[rightArrayStart][rightArrayEnd];
						int totalCost = leftArrayCost + rightArrayCost 
								+ matrices[leftArrayStart].rowCount * matrices[leftArrayEnd].columnCount * matrices[rightArrayEnd].columnCount;
						if (totalCost < min) {
							min = totalCost;
						}
					}
					storage[subArrayStart][subArrayStart + subArrayLength] = min;
//					for(int gapCount = 0; gapCount < gap; gapCount++ ) {
//						int divisionPoint = row + 1 + gapCount;
//						int leftCost = storage[row][column-gap+gapCount]; //(a)(col increases) -> (ab) (cost before cut) //
//						int rightCost = storage[divisionPoint][column];//(bc)(row increases) -> (c) (cost after cut)
//						int multiplicationCost = dims[row]*dims[column-gap+gapCount]*dims[column];
//						int totalCost = leftCost + rightCost + multiplicationCost;
//						min = Math.min(totalCost, min);
//					}
//					storage[subArrayStart][column] = min;
				}
			}
		}
		return storage[0][storage.length - 1];
//		System.out.println(storage[dims.length -2][dims.length -2]);
//		return storage[dims.length -2][dims.length -2];
	}

	private static class Matrix {
		public int rowCount;
		public int columnCount;

		public Matrix(int rowCount, int columnCount) {
			super();
			this.rowCount = rowCount;
			this.columnCount = columnCount;
		}
		
	}
}
