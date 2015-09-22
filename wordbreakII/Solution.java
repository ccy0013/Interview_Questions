/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Mon Sep 21 20:35:33 2015
 ************************************************************************/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Solution {
    
    public static List<String> concatenateAll( String str, List<String> array ){
        List<String> result = new ArrayList<String>();

        for( String s : array ){
            result.add( s + " " + str );
        }
        
        if(array.size()==0)
           result.add(str);
        
        return result;
    }
    
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        
        if(wordDict==null || wordDict.size()==0)    return new ArrayList<String>();
        
        List<String> result = new ArrayList<String>();
        
        boolean[] opt = new boolean[s.length()+1];
        
        opt[0] = true;
        
        for(int i=0; i<s.length()+1; i++) {
            for( int j=0; j<i; j++ ) {
                opt[i] |= (opt[j] && wordDict.contains(s.substring(j, i)));
            }

            System.out.print( opt[i] + " " );
        }
        System.out.println("");
        
        return helper(s, wordDict, opt, s.length());
    }
    
    public static List<String> helper(String s, Set<String> wordDict, boolean[] opt, int end ) {

        List<String> result = new ArrayList<String>();
        
        for(int i=0; i<end; i++) {
            if( opt[i] && wordDict.contains(s.substring(i, end)) ) {
                List<String> temp = concatenateAll(s.substring(i, end), helper(s, wordDict, opt, i) );

                for( String ss : temp ) {
                    result.add(ss);
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
    	String s = "catsanddog";
    	HashSet<String> wordDict = new HashSet<String>();
    	wordDict.add( "cat" );
    	wordDict.add( "cats" );
    	wordDict.add( "sand" );
    	wordDict.add( "and" );
    	wordDict.add( "dog" );


    	List<String> result;
    
    	result = wordBreak(s, wordDict);

    	for( String ss : result ) {
    		System.out.println( ss );
    	}

    	if( result.size()==0 )
    		System.out.println( "EMPTY");
    }
}