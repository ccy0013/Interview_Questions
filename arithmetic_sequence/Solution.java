/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Fri Nov 20 16:58:29 2015
 ************************************************************************/

import java.util.Arrays;

public class Solution {
	public static int arithmeticSequence(int[] nums) {
		if(nums==null || nums.length<3)    return 0;

		int count = 0;

		for(int i=0; i<nums.length-2; i++) {
			for( int j=i+2; j<nums.length; j++ ) {
				if( nums[j] - nums[j-1] == nums[j-1] - nums[j-2] )
					count++;
				else {
					i = j-2;
					break;
				}
			}
		}

		return count > 1000000000 ? -1 : count;
	}


	public static void main(String[] args) {
		int[] nums = {-1, 1, 3, 3, 3, 2, 1, 0};
		System.out.println(Arrays.toString(nums));
		System.out.println("Arithmetic Sequence Number: " + arithmeticSequence(nums));
	}
}