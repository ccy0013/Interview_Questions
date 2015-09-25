/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Wed Sep 23 19:40:06 2015
 ************************************************************************/

/*

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

*/


import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Solution {

	public static void combinationSumHelper(int[] candidates, int target, LinkedList<List<Integer>> resultList, LinkedList<Integer> result, int start) {
        
        for( int i=start; i<candidates.length; i++ ) {
            if(candidates[i]==target) {
                result.offer(candidates[i]);
                resultList.offer((LinkedList<Integer>)result.clone());
                result.pollLast();
                break;
            } else if( candidates[i]<target ) {
                result.offer(candidates[i]);
                combinationSumHelper(candidates, target-candidates[i], resultList, result, i);
                result.pollLast();
            } else
                break;
        }
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0)    return new LinkedList<List<Integer>>();
        
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        
        combinationSumHelper(candidates, target, (LinkedList<List<Integer>>)resultList, new LinkedList<Integer>(), 0);
        
        return resultList;
    }

	public static void main( String[] args ) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;

		Arrays.sort(candidates);
		List<List<Integer>> result = combinationSum(candidates, target);

		for( List<Integer> list : result ) {
			System.out.print( "[List]: ");
			for( Integer i : list ) {
				System.out.print( i + " " );
			}
			System.out.println( "" );
		}
	}
}