/*  Given a string of numbers and operators, return all possible results from 
 *  computing all the different possible ways to group numbers and operators. 
 *  The valid operators are +, - and *.
 */

/*
Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]
*/

/*
Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    
    public static ArrayList<Integer> listMultiplication( ArrayList<Integer> l1, ArrayList<Integer>l2, char sign ){
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        switch( sign ){
            case '+':{
                for( Integer i: l1 ){
                    for( Integer j : l2 )
                        result.add( i+j );
                }
            }
            break;

            case '-':{
                for( Integer i: l1 ){
                    for( Integer j : l2 )
                        result.add( i-j );
                }
            }
            break;
            
            case '*':{
                for( Integer i: l1 ){
                    for( Integer j : l2 )
                        result.add( i*j );
                }
            }
            break;
            
            default:
            break;
        }
        
        return result;
    }

    public static int calculate( int a, int b, char sign ){
        int result = Integer.MAX_VALUE;
        switch( sign ){
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break; 
            default:
                break;
        }
        return result;
    }

    public static ArrayList<Integer> diffWaysToComputeHelper( ArrayList<Integer> nums, ArrayList<Character> signs, int start, int end ){

        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

        if( start == end ){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(nums.get(start));
            return temp;
        }

        if( start + 1 == end ){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(calculate(nums.get(start), nums.get(end), signs.get(start)));
            return temp;
        }

        for( int i=start; i<end; i++ ){
            results.add(listMultiplication( diffWaysToComputeHelper( nums, signs, start, i ), diffWaysToComputeHelper( nums, signs, i+1, end), signs.get(i) ));
        }

        ArrayList<Integer> temp = new ArrayList<Integer>();
        for( ArrayList<Integer> l : results )
            for( Integer i : l )
                temp.add(i);
        
        return temp;
    }
    
    public static List<Integer> diffWaysToCompute(String input) {

        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Character> signs = new ArrayList<Character>();

        read( input, nums, signs );

        System.out.print( "[Numbers]: " );
        for( Integer i : nums )
            System.out.print( i + " " );
        System.out.println( "" );

        System.out.print( "[Signs]: " );
        for( Character i : signs )
            System.out.print( i + " " );
        System.out.println( "" );

        return diffWaysToComputeHelper( nums, signs, 0, nums.size()-1 );
    }

    public static void read( String str, ArrayList<Integer> nums, ArrayList<Character> signs ){
        if( str == null )   return;

        int i=0;

        while( i < str.length() ){
            String temp = "";

            while( i < str.length() && Character.isDigit(str.charAt(i)) ){
                temp += str.charAt(i++);
            }

            nums.add( Integer.parseInt(temp) );
            
            if( i < str.length() )
                signs.add( str.charAt(i++) );
        }

    }

	public static void main( String[] args ){
		
		String s = "2*3-4*5";

		ArrayList<Integer> result = (ArrayList<Integer>)diffWaysToCompute( s );

		System.out.print( "[Result]: " );
		for( Integer i : result )
			System.out.print( i + " " );
		System.out.println( "" );
	}
}
