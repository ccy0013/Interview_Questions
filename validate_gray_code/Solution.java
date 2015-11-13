/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Thu Nov 12 20:09:12 2015
 ************************************************************************/

public class Solution {
	public static boolean isGrayCodeNeighbor(int a, int b) {

		int bit = 1, diff = 0;

		for(int i=0; i<31; i++) {
			int temp = 1 << i;

			if((temp&a) != (temp&b))
				diff++;
		}

		return diff==1;
	}
	
	public static void main(String[] args) {
		int a = 0, b = 1;
		System.out.println("(0, 1):    " + isGrayCodeNeighbor(a, b) );
		a = 10; b = 20;
		System.out.println("(" + a + ", " + b + "):    " + isGrayCodeNeighbor(a, b) );
		a = 1; b = 16;
		System.out.println("(" + a + ", " + b + "):    " + isGrayCodeNeighbor(a, b) );
		a = 4; b = 6;
		System.out.println("(" + a + ", " + b + "):    " + isGrayCodeNeighbor(a, b) );

	}
}
