package Assignment1;

import java.util.Scanner;

public class Triangles {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int Q = s.nextInt();
        int[] queryN = new int[Q];
        int nMax = Integer.MIN_VALUE;
        for(int i = 0; i < Q; i++) {
            queryN[i] = s.nextInt(); 
            if(nMax < queryN[i]) {
                nMax = queryN[i];
            }
        }
        countTriangles(queryN, nMax);
        
   
    }
    static int[] countTriangles(int[] queryN, int N){
        for(int smallestSide = 1; smallestSide <= N/3; smallestSide++){
            for(int mediumSide = smallestSide; mediumSide <= N - smallestSide - mediumSide; mediumSide++) {
                for(int largestSide = mediumSide; largestSide < smallestSide + mediumSide; largestSide++ ) {
                    
                }
            }           
        }
    }

}
