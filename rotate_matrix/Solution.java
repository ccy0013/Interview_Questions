/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sun Nov 22 15:33:43 2015
 ************************************************************************/

import java.util.Arrays;

public class Solution {
	public static int[][] rotateMatrix(int[][] matrix, int dir) {
		if(matrix==null || matrix[0].length==0)    return matrix;

		int m = matrix.length, n = matrix[0].length;

		int[][] result = new int[n][m];

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(dir==1)
					result[j][m-i-1] = matrix[i][j];
				else
					result[n-j-1][i] = matrix[i][j];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = { {1, 2, 3}, {4, 5, 6} };

		System.out.println("[Original Matrix]");
		for(int i=0; i<matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));

		System.out.println("[After rotate 90 degree to right]");
		int[][] result = rotateMatrix(matrix, 1);
		for(int i=0; i<result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}

		System.out.println("[After rotate 90 degree to left]");
		result = rotateMatrix(matrix, 0);
		for(int i=0; i<result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
}
