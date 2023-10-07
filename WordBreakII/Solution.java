package LeetCode.WordBreakII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        BackTrack(s, "", set);
        return ans;
    }
    void BackTrack(String s, String str, Set<String> wordDict){
        if (s == ""){
            ans.add(str);
            return;
        }
        for (int i=0; i<=s.length(); i++){
            String subS = s.substring(0, i);
            if (wordDict.contains(subS)){
                String str2 = str;
                if (str2 == ""){
                    str2 = subS;
                }
                else{
                    str2 = str2+ " " + subS;
                }
                BackTrack(s.substring(i), str2, wordDict);
            }
        }
    }
}
