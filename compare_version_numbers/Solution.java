/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Thu Sep 17 16:51:34 2015
 ************************************************************************/

import java.util.ArrayList;

public class Solution{
	public static ArrayList<String> stringTokenize(String s){
        ArrayList<String> array = new ArrayList<String>();
        
        StringBuilder sb = new StringBuilder();
        for( int i=0; i< s.length(); i++ ){
            
            if( s.charAt(i) != '.' )
                sb.append(s.charAt(i));
            else{
                array.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        
        if( sb.length()!=0 )
            array.add(sb.toString());
        
        return array;
    }
    
    public static int compareVersion(String version1, String version2) {
        
        ArrayList<String> array1 = stringTokenize(version1);
        ArrayList<String> array2 = stringTokenize(version2);

        System.out.println( array1.size() );
        System.out.println( array2.size());
        
        
        int size1 = array1.size(), size2 = array2.size();
        if( size1 < size2 ){
            for( int i=0; i<size2-size1; i++ ){
                array1.add("0");
            }
        }else if( size1 > size2 ){
            for( int i=0; i<size1-size2; i++ ){
                array2.add("0");
            }
        }
   
        
        System.out.println( array1.size() );
        System.out.println( array2.size());

        for( int i=0; i<array1.size(); i++ ){
            String s1=array1.get(i);
            String s2=array2.get(i);
            if( Integer.parseInt(s1) > Integer.parseInt(s2) )
                return 1;
            else if( Integer.parseInt(s1) < Integer.parseInt(s2) )
                return -1;
        }
        
        return 0;
    }

    public static void main(String[] args){
    	String s1 = "1.0.0";
    	String s2 = "1";

    	System.out.println( s1 + '\n' + s2 + '\n' + "[Result]: " + compareVersion(s1, s2) );
    }
}