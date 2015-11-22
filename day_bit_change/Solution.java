/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sun Nov 22 15:05:59 2015
 ************************************************************************/

import java.util.Arrays;

public class Solution {
	public static int[] findBitSequence(int[] nums, int k) {
		if(nums==null || nums.length==0 || k<1)    return nums;

		int[] result = new int[nums.length+2];

		for(int i=0; i<nums.length; i++)
			result[i+1] = nums[i];

		for(int j=0; j<k; j++) {

			int preNum = result[0];
			for(int i=1; i<result.length-1; i++) {
				int temp = result[i];
				result[i] = preNum ^ result[i+1];
				preNum = temp;
			}
		}

		return Arrays.copyOfRange(result, 1, result.length-1);
	}

	public static void main(String[] args) {
		int[] nums = {1, 0, 0, 0, 0, 1, 0, 0};

		System.out.println(Arrays.toString(nums));

		System.out.println("After 1 day: " + Arrays.toString(findBitSequence(nums, 1)));
		System.out.println("After 2 days: " + Arrays.toString(findBitSequence(nums, 2)));
	}
}