package Day1;

import javax.swing.plaf.synth.SynthStyle;

public class Pattern1 {

	public static void main(String[] args) {

		// Pattern1(4);
		// Pattern2(4);
		//Pattern3(6);
		//Pattern4(5);
		//Pattern5(5);			//cross
		Pattern6(5);			//cross easily

	}
	
	
	public static void Pattern6(int row) {
		for (int i = 0; i < row; i++) {
						
				for (int j = 0; j < row; j++) {
					if(i == j || i + j == row-1) {
						System.out.print(" *");
					}
					else System.out.print("  ");
				}
			
			System.out.println();
		}
	}
	
	public static void Pattern5(int row) {
		int space1 = 0,space2 = row-2, i = 1;
		for (; i <= row; i++) {
			for (int s = 0; s < space1; s++) {
				System.out.print("  ");
			}			
			System.out.print(" *");
			if(i != (row +1)/2) {			
				for (int s = 0; s < space2; s++) {
					System.out.print("  ");
				}
				System.out.print(" *");		
			}
			if (i < (row+1)/2) {
				space1 += 1;
				space2 -= 2;
			} 
			else  {
				space1 -= 1;
				space2 += 2;
			}
			System.out.println();
		}
	}
	
	public static void Pattern4(int row) {

		int ncount = 1, space = row / 2, num = 1;

		for (int i = 0; i < row; i++) {
			
			for (int s = 0; s < space; s++) {
				System.out.print("  ");
			}
			for (int s = 0; s < ncount; s++) {
				System.out.print(" "+num);
				if(s < ncount/2) 
				num++;
				else if(s < ncount - 1)num--;
				else num++;
			}

			if (i < row /2) {
				space -= 1;
				ncount += 2;
			} 
			else  {
				space += 1;
				ncount -= 2;
				num-= 2;
			}
			System.out.println();
		}
	}
	


	public static void Pattern3(int row) {

		int space = 1, star = row / 2;

		for (int i = 0; i < row; i++) {
			if (i == (row - 1) / 2) {continue;}
			for (int s = 0; s < star; s++) {
				System.out.print(" *");
			}
			for (int s = 0; s < space; s++) {
				System.out.print("  ");
			}
			for (int s = 0; s < star; s++) {
				System.out.print(" *");
			}

			if (i < row /2-1) {
				star -= 1;
				space += 2;
			} 
			else  {
				star += 1;
				space -= 2;
			}
			System.out.println();
		}

	}

	public static void Pattern2(int row) {

		int num = 1;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < (2 * row - 1 - 2 * i) / 2; j++) {
				System.out.print("  ");
			}
			for (int j = 0; j <= 2 * i; j++) {
				System.out.print(" *");
			}

			System.out.println();
		}
	}

	public static void Pattern1(int row) {

		int num = 1;
		int prev = 0;
		int temp;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(prev + " ");
				temp = num;
				num = num + prev;
				prev = temp;

			}
			System.out.println();
		}
	}
}
