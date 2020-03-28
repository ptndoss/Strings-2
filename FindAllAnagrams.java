// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result  =new ArrayList<>();
        
        if(s == null || s.length() < p.length())
            return result;
        
        int[] frequencyP = new int[26];
        int[] frequencyWindow = new int[26];
        
        for(int i=0; i<p.length();i++){
            char ch = p.charAt(i);
            frequencyP[ch - 'a']++;
        }
        
        int start = 0, end = 0;
        while(end < s.length()){
            char ch = s.charAt(end);
            frequencyWindow[ch - 'a']++;
            if(end-start+1 >= p.length()){
                
                if(Arrays.equals(frequencyWindow, frequencyP)){
                        result.add(start);   
                 }
                frequencyWindow[s.charAt(start) - 'a']--;
                start++;
            }
            

            
            end++;
        }
        return result;
    }
}
