/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Jun 16 11:34:45 2015
 ************************************************************************/

/*Problem Description
 *Given a binary number with length n, where neighbour digits cannot both be 1, how many possibilities this number can be
 e.g. For n=3, 111 is not allowed, which there are consecutive 1s in the binary number.
 */

public class Solution{

	public static int countNum( int n ){

		if( 0 == n )
			return 0;
		
		int[] endWithZero = new int[n];
		int[] endWithOne = new int[n];
	
		endWithZero[0] = 1;
		endWithOne[0] = 1;

		for( int i=1; i<n; i++ ){
			endWithOne[i] = endWithZero[i-1];
			endWithZero[i] = endWithOne[i-1] + endWithZero[i-1];
		}

		return endWithOne[n-1] + endWithZero[n-1];
	}

	public static void main( String[] args ){

		for( int i=0; i<5; i++ ){
			int result = countNum(i);

			System.out.print( "[Num " + i + "]   " );
			System.out.println( "Count: " + result );
		}
	}
}
