/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Thu Sep 17 17:44:43 2015
 ************************************************************************/
 
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public class Solution{
 
public static int[] topKFrequent(int[] nums, int k){
 
         if( nums==null || nums.length==0 )  return null;
 
         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
 
         for( int i=0; i<nums.length; i++ ){
             if( map.containsKey(nums[i]) )
                 map.put(nums[i], map.get(nums[i])+1);
             else
                 map.put(nums[i], 1);
         }
 
         Comparator cmp = new Comparator() {
             public int compare(Object o1, Object o2){
             	Integer i1 = (Integer)o1, i2 = (Integer)o2;

                return map.get(i2) - map.get(i1);
             }
         };
 
         PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, cmp);
 
         Iterator itr = map.entrySet().iterator();
         while( itr.hasNext() ){
         	Map.Entry pair = (Map.Entry)itr.next();
         	Integer i = (Integer)pair.getKey();
         	minHeap.offer(i);
         }

         int[] result = new int[k];

         for( int i=0; i<k; i++ ){
         	result[i] = minHeap.poll();
         }                                                                                                                                                                                              
     
     	return result;
     }
     
     public static void main(String[] args){
     	int[] testCase = { 1, 2, 2, 1, 3, 1, 5, 2, 7, 8, 10, 0, -1, -4, -2, 0 };

     	System.out.println( Arrays.toString(testCase) );
     	System.out.println( "[Result]: " + Arrays.toString(topKFrequent(testCase, 3)));
     }
 }
 
 class Item {
     public int val;
     public int fre;
     
     public Item(){
         val=0;
         fre=0;
	}
}
