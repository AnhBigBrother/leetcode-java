package LeetCode.WordBreak;

import java.util.ArrayList;
import java.util.List;

public class Entry {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        String s = "aaaaaaa";
        System.out.println(new Solution().wordBreak(s,wordDict));
    }
}
