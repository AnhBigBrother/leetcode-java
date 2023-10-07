package LeetCode.WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return wb(s, set);
    }
    public boolean wb(String s, Set<String> wordDict) {
        boolean[] b = new boolean[s.length()+1];
        b[0] = true;
        for (int i=1; i<=s.length(); i++){
            for (int j=0; j<=i; j++){
                if (b[j] == true && wordDict.contains(s.substring(j, i))){
                    b[i] = true;
                }
            }
        }
        return b[s.length()];
    }
}
