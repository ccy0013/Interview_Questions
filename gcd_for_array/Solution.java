/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sun Nov 22 19:30:01 2015
 ************************************************************************/

import java.util.Arrays;

public class Solution{
	public static int gcd(int a, int b) {
		while(b!=0) {
			int temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}

	public static int gcdForArray(int[] nums) {
		if(nums==null || nums.length==0)	return 0;
		if(nums.length==1)	return nums[0];

		int curGCD=nums[0];

		for(int i=1; i<nums.length; i++) {
			curGCD = gcd(curGCD, nums[i]);
		}

		return curGCD;
	}

	public static void main(String[] args) {
		int[] nums = new int[6];

		nums[0] = 36;
		nums[1] = 12;
		nums[2] = 18;
		nums[3]	= 24;
		nums[4] = 30;
		nums[5] = 39;

		System.out.println(Arrays.toString(nums));
		System.out.println("GCD: " + gcdForArray(nums));
	}
}