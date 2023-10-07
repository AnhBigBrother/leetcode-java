package LeetCode.LongestSubstring;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap <Character, Integer> lastVisited = new HashMap<Character, Integer>();
        int [] d = new int[n];
        for (char c : s.toCharArray()){
            lastVisited.put(c, -1);
        }
        d[0] = 1;
        lastVisited.put(s.charAt(0), 0);
        for (int i=1; i<n; i++){
            int j = lastVisited.get(s.charAt(i));
            if (j != -1 && i-j < d[i-1]+1){
                d[i] = i-j;
            }
            else {
                d[i] = d[i-1] + 1;
            }
            lastVisited.put(s.charAt(i), i);
        }
        int ret = d[0];
        for (int i=0; i<n; i++){
            if (ret < d[i]) {ret = d[i];}
        }
        return ret;
    }
}
