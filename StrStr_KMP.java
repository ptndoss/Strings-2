// Time Complexity :O(n+m) n is the lenth of haystack string adn m is needed length
// Space Complexity : O(m) we store the pi values in a seperate array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

class Solution {
    public int strStr(String haystack, String needle) {
      
        // if(haystack.length() < needle.length())
        //     return -1;
        // if(haystack.length()==0 && needle.length() ==0 )
        //     return 0;
        if(needle.length() ==0)
            return 0;
        
        int[] pi = computePi(needle);
        int i=0, j= 0;
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == needle.length())
                    return i-j;
            }else{
                if(j == 0){
                    i++;
                }else{
                    j = pi[j -1];
                }
            }
        }
              return -1;

   }     
        /// ************Bruteforce without KMP Algo************
        // if(haystack.length() < needle.length())
        //     return -1;
        // if(haystack.length()==0 && needle.length() ==0 )
        //     return 0;
        // int i=0;
        // int j = 0;
        // while(i < haystack.length()){
        //     if(i + needle.length() > haystack.length()) break;
        //     while(j< needle.length() && haystack.charAt(i+j) == needle.charAt(j)){
        //        j++;
        //     }
        //     if(j == needle.length())
        //         return i;
        //     else
        //         j = 0;
        //     i++;
        // }
        // return -1;
        
    private int[] computePi(String needle){
        int[] pi = new int[needle.length()];
        int i=1;
        int j = 0;
            pi[0] = 0;
            while(i< needle.length()){
                char pref = needle.charAt(j);
                char suf = needle.charAt(i);
                if(pref == suf){
                    j++;
                    pi[i] = j;
                    i++;
                }else{
                    if(j == 0 ){ //sufix reaches starting point
                        pi[i] = 0; //No sufix match with prefix so its value is 0
                        i++;
                    }else{
                       j = pi[j-1]; //preserve the sufix of previous value.  
                    }
                }

            }
        return pi;
}
              
}
              
