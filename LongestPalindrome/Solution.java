package LeetCode.LongestPalindrome;

public class Solution {
    public int longestPalindrome(String s) {
        int [] count = new int[58];
        boolean[] visited = new boolean[58];
        for (char c : s.toCharArray()){
            count[c - 'A']++;
            visited[c-'A'] = false;
        }
        int ans = 1;
        for (char c : s.toCharArray()){
            if (count[c-'A'] > 1 && visited[c-'A'] == false){
                visited[c - 'A'] = true;
                if (count[c-'A'] %2 == 0){
                    ans += count[c-'A'];
                }
                else {
                    ans += count[c-'A'] -1;
                }
            }
        }
        return ans;
    }
}
