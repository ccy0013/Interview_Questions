/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sun Nov 22 14:31:57 2015
 ************************************************************************/

import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
	public static int cacheMiss(int[] nums, int k) {
		if(nums==null || nums.length<2)	   return 0;

		LinkedList<Integer> cache = new LinkedList<Integer>();
		int countMiss = 0;

		for(int i=0; i<nums.length; i++) {
			if(cache.contains(nums[i])) {
				cache.remove(new Integer(nums[i]));
				cache.offerFirst(nums[i]);
			} else {
				if(cache.size()>=k)
					cache.pollFirst();
				cache.offerLast(nums[i]);
				countMiss++;
			}
		}

		return countMiss;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 4, 1};

		System.out.println(Arrays.toString(nums));
		System.out.println("Miss: " + cacheMiss(nums, 4));
	}
}