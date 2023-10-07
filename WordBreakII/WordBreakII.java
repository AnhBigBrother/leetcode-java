package LeetCode.WordBreakII;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> ans = new Solution().wordBreak(s, wordDict);
        System.out.println(ans);
    }
}
