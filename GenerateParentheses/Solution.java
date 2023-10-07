package LeetCode.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, "", n, n);
        return ans;
    }
    public void backTrack(List<String> ans, String s, int n1, int n2){
        if (n1 == 0 && n2 == 0){
            ans.add(s);
            return;
        }
        if (n2 > n1){
            backTrack(ans, s+')', n1, n2-1);
        }
        if (n1 > 0){
            backTrack(ans, s+'(', n1-1, n2);
        }
    }
}
class Entry{
    public static void main(String[] args) {
        List<String> out = new Solution().generateParenthesis(3);
        System.out.println(out);
    }
}