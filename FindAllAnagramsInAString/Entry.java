package LeetCode.FindAllAnagramsInAString;

import java.util.List;

public class Entry {
    public static void main(String[] args) {
        List<Integer> ans = new Solution().findAnagrams("abc", "abc");
        System.out.println(ans);
    }
}
