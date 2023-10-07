package LeetCode.FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int p_len = p.length();
        int s_len = s.length();
        if (s_len < p_len){return ans;}

        int [] countP = new int[26];
        int [] count  = new int[26];
        for (int i=0; i<p_len; i++){
            count[s.charAt(i)-'a']++;
            countP[p.charAt(i)-'a']++;
        }
        for (int i=0; i<s_len-p_len; i++){
            if (check(count, countP)){ans.add(i);}
            count[s.charAt(i)-'a']--;
            count[s.charAt(i+p_len)-'a']++;
        }
        if (check(count, countP)){ans.add(s_len-p_len);}

        return ans;
    }
    boolean check(int[] count, int[] countP){
        for (int i=0; i<26; i++){
            if (count[i] != countP[i]){
                return false;
            }
        }
        return true;
    }
}
