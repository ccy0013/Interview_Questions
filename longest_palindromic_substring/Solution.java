/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Wed Sep  9 16:26:31 2015
 ************************************************************************/

public class Solution {
    public static String longestPalindrome(String s) {
        // Try to transform the question into LCS, but it fails for the case like:
        // "abcdefcba"
        // In the above test case, the longest palindromic string would be "abc"
        

        /*
        
        if( s == null || s.length()==0 || s.length()==1 )
            return s;
        
        String reverse = new StringBuilder(s).reverse().toString();        
        
        int n = s.length();
        
        int[][] M = new int[n][n];
        
        int maxLen=0, pos=0;
        for( int i=0; i<n; i++ ){
        	for( int j=0; j<n; j++ ){
        		if( s.charAt(i) == reverse.charAt(j) ){
        			if( i==0 || j==0)
        				M[i][j] = 1;
        			else
        				M[i][j] = 1 + M[i-1][j-1];

                    if( M[i][j] > maxLen ){
                        maxLen = M[i][j];
                        pos = i;
                    }
        		}
        	}
        } 

      
        System.out.println( maxLen );
        System.out.println( s.charAt(pos) );

        return s.substring( pos-maxLen+1, pos+1 );
        */


        // A solution with O(n^3) time complexity

        /*
        String result = "";

        int i=0, j=0;
        
        for( i=0; i<s.length(); i++ ){

            j = s.length()-1;
            
            int k = i;
            while( j>k ){
                if( s.charAt(k) == s.charAt(j) ){
                    j--;
                    k++;
                }
                else{
                    k = i;
                    j--;
                }
            }
            
            if( k == j  && (2*(k-i))+1 > result.length() )
                result = s.substring(i, 2*k-i+1);
            else if( k>j && (2*(k-i)) > result.length() )
                result = s.substring( i, 2*k-i );
        }
        
        return result;
    */

        int n = s.length();
        int[][] opt = new int[n][n];

        int[] M = new int[n];
        
        int i=0, j=0, start=0, end=0;
        
        for( j=0; j<n; j++ ){
            for( i=j; i>=0; i-- ){
                
                if( s.charAt(i) == s.charAt(j) ){
                    if( i==j )
                        opt[i][j] = 1;
                    else if( i+1==j )
                        opt[i][j] = 2;
                    else if( opt[i+1][j-1] == (j-i-1) )
                        opt[i][j] = j-i+1;
                }
                else
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j-1]);
                    
                if( opt[i][j] > end-start+1 ){
                    start = i;
                    end = j;
                }
            }
        }
        
        return s.substring(start, end+1);

    }
    

    public static void main( String[] args ){
    	String[] s = new String[4];
    	s[0] = "esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq";
    	s[1] = "abbabcc";
    	s[2] = "azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc";
        s[3] = "abbbccbasdfwf";


    	for( int i=0; i<s.length; i++ ){
    		System.out.println( "Test Case: " + s[i] );
    		System.out.println( longestPalindrome(s[i]) );
    	}
    }
}
