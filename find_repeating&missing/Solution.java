/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Mon Sep 21 21:23:50 2015
 ************************************************************************/

/* Given an unsorted array of size n. Array elements are in range from 1 to n.
 * One number from set {1, 2, …n} is missing and one number occurs twice in array. 
 * Find these two numbers.
 */

import java.util.Arrays;

public class Solution {

	public static void swap(int[] nums, int i, int j) {
		if(i==j)	return;

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static int[] findRandomM(int[] nums) {

		if( nums==null || nums.length==0 )	return null;

		// First element is the number that occurs twice
		// Second element is the missing number
		int[] result = new int[2];
		int i=0;

		while(i<nums.length) {
			if( nums[i] != i+1 ) {
				if( nums[i] == nums[nums[i]-1] ){
					result[0] = nums[i];
					result[1] = ++i;
				} else
					swap(nums, i, nums[i]-1);
			}
			else
				i++;
		}

		return result;
	}

	public static void main(String[] args) {

		int[] nums = {3, 2, 2, 1, 4};
		System.out.println( Arrays.toString(findRandomM(nums)) );
	
		int[] nums2 = {2, 1, 4, 5, 4};
		System.out.println( Arrays.toString(findRandomM(nums2)) );
	}
}
